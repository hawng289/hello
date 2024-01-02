package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoUpdate;
import vn.com.itechcorp.base.util.TextUtil;
import vn.itechcorp.admin.jpa.entity.Hospital;
import vn.itechcorp.admin.util.Util;

@Getter
@Setter
@NoArgsConstructor
public class HospitalDTOUpdate extends DtoUpdate<Hospital, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private String phone;

    private String email;

    private String address;

    private byte[] logo;

    private byte[] logoFull;

    private Boolean enabled;

    @Override
    public boolean apply(Hospital object) {
        boolean modified = false;

        if (name != null) {
            object.setName(name);
            object.setNameSearch(TextUtil.getInstance().toASCIIUpperCase(object.getName(), true));
            modified = true;
        }

        if (phone != null) {
            object.setPhone(Util.toCleanText(phone));
            modified = true;
        }

        if (email != null) {
            object.setEmail(Util.toCleanText(email));
            modified = true;
        }

        if (description != null) {
            object.setDescription(Util.toCleanText(description));
            modified = true;
        }

        if (address != null) {
            object.setAddress(Util.toCleanText(address));
            modified = true;
        }

        if (logo != null) {
            object.setLogo(logo);
            modified = true;
        }

        if (logoFull != null) {
            object.setLogoFull(logoFull);
            modified = true;
        }

        if (enabled != null) {
            object.setEnabled(enabled);
            modified = true;
        }

        return modified;
    }
}
