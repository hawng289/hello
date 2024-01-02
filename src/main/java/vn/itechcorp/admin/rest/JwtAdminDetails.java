package vn.itechcorp.admin.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.itechcorp.admin.jpa.entity.Admin;

import java.util.Collection;


@Getter @Setter
@NoArgsConstructor
public class JwtAdminDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;


    private String password;

    private String username;

    public JwtAdminDetails(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public JwtAdminDetails(Admin admin) {
        id = admin.getId();
        password = admin.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
    public boolean isEnabled() { return true; }
}

