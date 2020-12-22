package com.furama.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_account", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "ACC_NAME_UK", columnNames = "account_name") })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "account_name")
    String name;
    @Column(name = "encrypted_password")
    String encryptedPassword;
    boolean enabled;

}
