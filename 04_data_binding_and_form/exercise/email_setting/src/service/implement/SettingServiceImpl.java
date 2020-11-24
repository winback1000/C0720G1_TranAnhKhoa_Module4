package service.implement;

import model.Setting;
import org.springframework.stereotype.Service;
import service.ISettingService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingServiceImpl implements ISettingService {
    @Override
    public Setting saveSetting(Setting setting) {
        return setting;
    }

    public List<String> getLanguageList(){
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    public List<Integer> getPageList(){
        List<Integer> pageList = new ArrayList<>();
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
        return pageList;
    }
}
