package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.itechcorp.admin.jpa.entity.ModalityTypeName;

@Getter
@Setter
@NoArgsConstructor
public class ModalityTypeNameDTOGet extends MetadataDTOGet<ModalityTypeName> {

    private static final long serialVersionUID = 1L;

    public ModalityTypeNameDTOGet(ModalityTypeName object) {
        super(object);
    }

}
