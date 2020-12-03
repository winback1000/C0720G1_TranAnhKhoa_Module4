package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "card_book",
            joinColumns = @JoinColumn(name = "borrow_card_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    List<Book> bookList;

    @Column(name = "borrow_date", columnDefinition = "DATE")
    String borrowDate;

    @Column(name = "return_date", columnDefinition = "DATE")
    String returnDate;
}
