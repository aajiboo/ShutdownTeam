package com.ShutdownTeam.ShutdownTeam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;
import java.util.List;

/**
 * Created by amino on 18/06/2017
 */

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements UserDetails {

    //--ATTRIBUTS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "idUser", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    //--END ATTRIBUTS

    //--CONSTRUCTEUR
    public User(){}
    //--END CONSTRUCTEUR

    //--GETTERS SETTERS

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    @XmlTransient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    @XmlTransient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    @XmlTransient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    @XmlTransient
    public boolean isEnabled() {
        return true;
    }


    //--END GETTERS SETTERS

    //--METHODES

    @Override
    public String toString() {
        return "User{" +
                "codeUser=" +idUser+
                ", nomUser='" + username + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    //--END METHODES
}