package com.furama.controller;

import com.furama.entity.AttachService;
import com.furama.entity.Contract;
import com.furama.entity.ContractDetail;
import com.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IAttachServiceService iAttachServiceService;

    @GetMapping("")
    public String goContractPage(Model model, Pageable pageable, @RequestParam Optional<String> keyword) {
        String searchData="";
        if(!keyword.isPresent()) {
        model.addAttribute("contractList", iContractService.findAllWithPage(pageable));
        } else {
            searchData = keyword.get();
            model.addAttribute("contractList", iContractService.searchContract(searchData, pageable));
            model.addAttribute("searchData", searchData);
        }
        return "contractPage";
    }

    @GetMapping("/add")
    public String createNewContract (Model model) {
        Contract contract = new Contract();
        for (AttachService attachService: iAttachServiceService.findAll()) {
            contract.addContractDetail(new ContractDetail(attachService));
        }
        model.addAttribute("contract",contract);
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("serviceList", iServiceService.findAll());
        return "editContractPage";
    }
    @PostMapping("/save")
    public String saveContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        List<ContractDetail> tempContractDetailList = new ArrayList<>(contract.getContractDetailList());
        boolean error = true;
        for (ContractDetail contractDetail : contract.getContractDetailList()) {
            if (contractDetail.getQuantity()<0) {
                error = false;
                model.addAttribute("errorMsg","The quantity must be >= 0");
            }
        }
        if(bindingResult.hasErrors() || !error) {
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("customerList", iCustomerService.findAll());
            model.addAttribute("employeeList", iEmployeeService.findAll());
            model.addAttribute("serviceList", iServiceService.findAll());
            return "editContractPage";
        }

        contract.setContractDetailList(new ArrayList<>());
        Contract currentContract = iContractService.saveAndFlush(contract);

            for (ContractDetail contractDetail : tempContractDetailList) {
                if(contractDetail.getContract().getId()==null) {
                    contractDetail.setContract(currentContract);
                }
                    iContractDetailService.save(contractDetail);
            }

        redirectAttributes.addFlashAttribute("successMessage", "Save Contract Successful");
        return "redirect:/contracts";
    }

    @GetMapping("/edit/{id}")
    public String editContract(@PathVariable int id, Model model){
        model.addAttribute("contract", iContractService.selectContractById(id));
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("serviceList", iServiceService.findAll());
        return "editContractPage";
    }

    @GetMapping("/delete")
    public String deleteContract(@RequestParam int deleteID, RedirectAttributes redirectAttributes){
        iContractService.deleteById(deleteID);
        redirectAttributes.addFlashAttribute("successMessage", "Delete Successful");
        return "redirect:/contracts";
    }
}
