package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.itechcorp.admin.jpa.entity.Role;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTOGet extends MetadataDTOGet<Role> {

    private static final long serialVersionUID = 1L;

    public RoleDTOGet(Role object) {
        super(object);
    }
}
