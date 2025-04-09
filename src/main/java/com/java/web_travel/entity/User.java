package com.java.web_travel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone ;

    @Column(name = "password",nullable = false)
    private String password ;

    @Column(name = "full_name",nullable = false)
    private String fullName ;

    @Column(name = "email",nullable = false)
    private String email ;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday ;

    @Column(name = "status")
    private boolean status ;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnore // không lấy dữ liệu từ role khi truy vấn user
    private Role role ;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> order;


    public User(String phone, String password, String fullName, String email, Date birthday, boolean status, Role role) {
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.birthday = birthday;
        this.status = status;
        this.role = role;
    }

    public User( String phone, String password, String fullName, String email, Date birthday, boolean status) {
        this.phone = phone;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.birthday = birthday;
        this.status = status;
    }

    public User(String phone, String password, Role role) {
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
}
