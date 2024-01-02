package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoGet;
import vn.itechcorp.admin.jpa.entity.Hospital;

@Getter
@Setter
@NoArgsConstructor
public class HospitalDTOGet extends DtoGet<Hospital, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private String phone;

    private String email;

    private String address;

    private byte[] logo;

    private byte[] logoFull;

    private boolean enabled;

    public HospitalDTOGet(Hospital object) {
        super(object);
    }

    @Override
    public void parse(Hospital object) {
        this.name = object.getName();
        this.description = object.getDescription();
        this.phone = object.getPhone();
        this.email = object.getEmail();
        this.address = object.getAddress();
        this.enabled = object.isEnabled();
    }
}
