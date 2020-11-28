package com.codegym.blog_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    @Column(columnDefinition = "LONGTEXT")
    String content;
    @Column(name = "post_date", columnDefinition = "DATE")
    String postDate;
    String writer;
    String image;

    public String getShortWord(){
        return this.content.substring(0,60).concat("......");
    }
}
