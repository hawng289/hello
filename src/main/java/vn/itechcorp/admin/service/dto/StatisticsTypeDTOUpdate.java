package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoUpdate;
import vn.com.itechcorp.base.util.CollectionUtil;
import vn.itechcorp.admin.jpa.entity.StatisticsType;
import vn.itechcorp.admin.util.Util;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsTypeDTOUpdate extends DtoUpdate<StatisticsType, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private Set<String> schemaParams;

    private Set<String> filterParams;

    private String config;

    @Override
    public boolean apply(StatisticsType object) {
        boolean modified = false;

        if (name != null) {
            object.setName(Util.toCleanText(name));
            modified = true;
        }

        if (description != null) {
            object.setDescription(Util.toCleanText(description));
            modified = true;
        }

        if (schemaParams != null) {
            object.setSchemaParams(CollectionUtil.toString(schemaParams));
            modified = true;
        }

        if (filterParams != null) {
            object.setFilterParams(CollectionUtil.toString(filterParams));
            modified = true;
        }

        if (config != null) {
            object.setConfig(Util.toCleanText(config));
            modified = true;
        }

        return modified;
    }
}
