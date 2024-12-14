package com.desafio.pacto.entities;


import com.desafio.pacto.entities.enums.UserRoleEnum;
import com.desafio.pacto.entities.enums.converter.UserRoleEnumConverter;
import com.desafio.pacto.entities.listener.EntityCreateUpdateListener;
import javax.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@EntityListeners(EntityCreateUpdateListener.class)
public class User implements Serializable, UserDetails, DateInterface{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pacto-custom-generator-user", allocationSize = 1, sequenceName = "user_id_user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacto-custom-generator-user")
    @Column(name = "id_user", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Convert(converter = UserRoleEnumConverter.class)
    @Column(name = "ID_USER_ROLE")
    private UserRoleEnum userRole;

    @Embedded
    private DateEntity dateEntity;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.userRole.getDescricao()));
        authorities.add(new SimpleGrantedAuthority("ROLE_DEFAULT_USER"));

        return authorities;
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
