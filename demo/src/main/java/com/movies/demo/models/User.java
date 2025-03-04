package com.movies.demo.models;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;
    private int role;
    //private String token;

    @OneToMany(mappedBy = "user")
    private List<UserShowing> userShowings;

    public List<UserShowing> getUserShowings() {
        return userShowings;
    }
    public void setUserShowings(List<UserShowing> userShowings) {
        this.userShowings = userShowings;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
   /* public String getUsername() {
        return username;
    }*/
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
   /*public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }*/

    // userdetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
