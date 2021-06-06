package kpi.iasa.marinahw.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "account")
public class Accs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_signin")
    private Long accId;

    @NotNull
    @Column(name="user_name")
    private String userName;


    @NotNull
    @Column(name="phone")
    private String userPhone;

    @NotNull
    @Column(name="email")
    private String userEmail;


    @NotNull
//    @Size(min=4,max = 50 , massage = "{validation.user-login}")
    @Column(name="login")
    private String userLogin;

    @NotNull
    @Column(name="password")
    private String userPassword;
}
