package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.itechcorp.admin.jpa.entity.Role;
import vn.itechcorp.admin.util.Util;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTOCreate extends DtoCreate<Role, String> {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    private String description;

    @Override
    public Role toEntry() {
        Role object = new Role();
        object.setId(getId());
        object.setName(Util.toCleanText(name));
        object.setDescription(Util.toCleanText(description));
        return object;
    }
}
