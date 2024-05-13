package com.example.fbtts.entity;

import com.example.fbtts.security.UserRole;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "users")
public class User implements UserDetails {
    @Id
    private String id;
    private String type = "BetStrategy";
    private String email;
    private String username;
    private String password;
    private UserRole role;

    private int clicks;
    private List<Method> methods;
    private boolean hasPayments;

    private String language;
    private String currency;

    public User(String username, String email, String password, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.clicks = 75;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.USER) {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
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

    public void addMethod(Method method) {
        methods.add(method);
    }
}
