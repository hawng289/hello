package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.itechcorp.admin.jpa.entity.ConsumableType;

@Getter
@Setter
@NoArgsConstructor
public class ConsumableTypeDTOGet extends MetadataDTOGet<ConsumableType> {

    private static final long serialVersionUID = 1L;

    public ConsumableTypeDTOGet(String id) {
        setId(id);
    }

    public ConsumableTypeDTOGet(ConsumableType object) {
        super(object);
    }
}
