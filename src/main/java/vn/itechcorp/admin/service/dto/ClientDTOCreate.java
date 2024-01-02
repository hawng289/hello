package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.com.itechcorp.base.util.CollectionUtil;
import vn.com.itechcorp.pacs.cloud.base.security.UserPasswordEncoder;
import vn.itechcorp.admin.jpa.entity.Client;
import vn.itechcorp.admin.util.Util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTOCreate extends DtoCreate<Client, String> {

    private static final long serialVersionUID = 1L;

    @NonNull
    private String hospitalID;

    @NotNull
    private String secret;

    private ClientType type;

    private Set<String> ipAllowed;

    @NotNull
    @NotEmpty
    private Set<String> authorities;

    public void setHospitalID(String hospitalID) {
        this.hospitalID = Util.toCleanText(hospitalID);
    }

    public void setSecret(String secret) {
        this.secret = Util.toCleanText(secret);
    }

    @Override
    public Client toEntry() {
        Client object = new Client();
        object.setId(getId());
        object.setSecret(UserPasswordEncoder.getInstance().encode(secret));
        if (type != null) object.setType(type);
        object.setIpAllowed(CollectionUtil.toString(ipAllowed));
        object.setAuthorities(CollectionUtil.toString(authorities));

        object.setHospitalID(hospitalID);
        return object;
    }
}
