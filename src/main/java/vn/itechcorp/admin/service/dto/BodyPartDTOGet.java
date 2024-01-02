package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.Setter;
import vn.itechcorp.admin.jpa.entity.BodyPart;

@Getter
@Setter
public class BodyPartDTOGet extends MetadataDTOGet<BodyPart> {

    private static final long serialVersionUID = 1L;

    public BodyPartDTOGet(BodyPart object) {
        super(object);
    }
}
