package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoGet;
import vn.itechcorp.admin.jpa.entity.Domain;


@Getter
@Setter
@NoArgsConstructor
public class DomainDTOGet extends DtoGet<Domain, String> {

    private static final long serialVersionUID = 1L;

    private String hospitalID;

    private byte[] logo;

    private byte[] logoFull;

    public DomainDTOGet(Domain object) {
        super(object);
    }

    @Override
    public void parse(Domain object) {
        hospitalID = object.getHospitalID();
    }
}
