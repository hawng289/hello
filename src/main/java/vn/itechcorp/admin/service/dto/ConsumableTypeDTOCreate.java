package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.itechcorp.admin.jpa.entity.ConsumableType;
import vn.itechcorp.admin.util.Util;

@Getter
@Setter
@NoArgsConstructor
public class ConsumableTypeDTOCreate extends DtoCreate<ConsumableType, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    @Override
    public ConsumableType toEntry() {
        ConsumableType object = new ConsumableType();
        object.setId(getId());
        object.setName(Util.toCleanText(name));
        object.setDescription(Util.toCleanText(description));
        return object;
    }
}
