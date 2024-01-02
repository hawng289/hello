package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoGet;
import vn.itechcorp.admin.jpa.entity.MetadataEntry;


@Getter
@Setter
@NoArgsConstructor
public class MetadataDTOGet<T extends MetadataEntry> extends DtoGet<T, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    public MetadataDTOGet(T t) {
        super(t);
    }

    @Override
    public void parse(T t) {
        name = t.getName();
        description = t.getDescription();
    }
}
