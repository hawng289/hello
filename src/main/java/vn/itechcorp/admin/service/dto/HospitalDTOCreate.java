package vn.itechcorp.admin.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.com.itechcorp.base.util.TextUtil;
import vn.itechcorp.admin.jpa.entity.Hospital;
import vn.itechcorp.admin.util.Util;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class HospitalDTOCreate extends DtoCreate<Hospital, String> {

    @NotNull
    @ApiModelProperty(notes = "Hospital Name", example = "Hai Phong International General Hospital", position = 1, required = true)
    private String name;

    private String description;

    private String phone;

    private String email;

    private String address;

    private byte[] logo;

    private byte[] logoFull;

    private Boolean enabled;

    public void setName(String name) {
        this.name = Util.toCleanText(name);
    }

    @Override
    public Hospital toEntry() {
        Hospital object = new Hospital();
        object.setId(getId());
        object.setName(name);
        object.setNameSearch(TextUtil.getInstance().toASCIIUpperCase(object.getName(), true));
        object.setDescription(Util.toCleanText(description));
        object.setPhone(Util.toCleanText(phone));
        object.setEmail(Util.toCleanText(email));
        object.setAddress(Util.toCleanText(address));
        object.setLogo(logo);
        object.setLogoFull(logoFull);
        if (enabled != null) object.setEnabled(enabled);
        return object;
    }
}
