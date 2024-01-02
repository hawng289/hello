package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.itechcorp.admin.jpa.entity.Domain;

@Getter
@Setter
@NoArgsConstructor
public class DomainDTOCreate extends DtoCreate<Domain, String> {

    private static final long serialVersionUID = 1L;

    private Boolean publicAddress;

    @NonNull
    private String hospitalID;

    @Override
    public Domain toEntry() {
        Domain object = new Domain();
        object.setId(getId());
        if (publicAddress != null) object.setPublicAddress(publicAddress);
        object.setHospitalID(hospitalID);
        return object;
    }
}
