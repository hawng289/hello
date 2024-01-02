package vn.itechcorp.admin.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoGet;
import vn.com.itechcorp.base.util.CollectionUtil;
import vn.itechcorp.admin.jpa.entity.Client;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTOGet extends DtoGet<Client, String> {

    @JsonIgnore
    private String secret;

    private ClientType type;

    private Set<String> ipAllowed;

    private Set<String> authorities;

    private String hospitalID;

    public ClientDTOGet(Client object) {
        super(object);
    }

    @Override
    public void parse(Client object) {
        this.type = object.getType();
        this.secret = object.getSecret();
        this.hospitalID = object.getHospitalID();
        this.authorities = CollectionUtil.toSet(object.getAuthorities());
        this.ipAllowed = CollectionUtil.toSet(object.getIpAllowed());
    }
}
