package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.itechcorp.admin.jpa.entity.ExtensionType;


@Getter
@Setter
@NoArgsConstructor
public class ExtensionTypeDTOGet extends MetadataDTOGet<ExtensionType> {

    private static final long serialVersionUID = 1L;

    public ExtensionTypeDTOGet(ExtensionType object) {
        super(object);
    }

}
