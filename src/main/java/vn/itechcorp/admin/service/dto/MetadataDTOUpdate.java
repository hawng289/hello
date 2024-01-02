package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoUpdate;
import vn.itechcorp.admin.jpa.entity.MetadataEntry;
import vn.itechcorp.admin.util.Util;

@Getter
@Setter
public class MetadataDTOUpdate<T extends MetadataEntry> extends DtoUpdate<T, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    public void setName(String name) {
        this.name = Util.toCleanText(name);
    }

    @Override
    public boolean apply(T object) {
        boolean modified = false;

        if (name != null) {
            object.setName(name);
            modified = true;
        }

        if (description != null) {
            object.setDescription(Util.toCleanText(description));
            modified = true;
        }

        return modified;
    }
}
