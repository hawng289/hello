package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoUpdate;
import vn.com.itechcorp.base.util.CollectionUtil;
import vn.com.itechcorp.pacs.cloud.base.security.UserPasswordEncoder;
import vn.itechcorp.admin.jpa.entity.Client;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTOUpdate extends DtoUpdate<Client, String> {

    private String secret;

    private ClientType type;

    private Set<String> ipAllowed;

    private Set<String> authorities;

    @Override
    public boolean apply(Client object) {
        boolean modified = false;

        if (type != null) {
            object.setType(type);
            modified = true;
        }

        if (authorities != null) {
            object.setAuthorities(CollectionUtil.toString(authorities));
            modified = true;
        }

        if (ipAllowed != null) {
            object.setIpAllowed(CollectionUtil.toString(ipAllowed));
            modified = true;
        }

        if (secret != null) {
            object.setSecret(UserPasswordEncoder.getInstance().encode(secret));
            modified = true;
        }

        return modified;
    }
}

