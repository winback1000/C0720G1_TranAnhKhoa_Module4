package com.codegym.blog_management.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity (name = "catalogue")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "catalogue", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Blog> blogs;
}
