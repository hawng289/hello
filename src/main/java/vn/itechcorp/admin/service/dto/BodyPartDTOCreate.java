package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.itechcorp.admin.jpa.entity.BodyPart;
import vn.itechcorp.admin.util.Util;


@Getter
@Setter
@NoArgsConstructor
public class BodyPartDTOCreate extends DtoCreate<BodyPart, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    @Override
    public BodyPart toEntry() {
        BodyPart object = new BodyPart();
        object.setId(getId());
        object.setName(Util.toCleanText(name));
        object.setDescription(Util.toCleanText(description));
        return object;
    }
}
