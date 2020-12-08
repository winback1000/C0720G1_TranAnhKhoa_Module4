package com.codegym.blog_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "catalogue_id", referencedColumnName = "id")
    Catalogue catalogue;

    public String getShortWord(){
        if(this.content.length()>60) {
            return this.content.substring(0,60).concat("......");
        } else {
            return this.content;
        }
    }
}
