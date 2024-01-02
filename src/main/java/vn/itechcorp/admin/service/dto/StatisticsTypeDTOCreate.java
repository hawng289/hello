package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoCreate;
import vn.com.itechcorp.base.util.CollectionUtil;
import vn.itechcorp.admin.jpa.entity.StatisticsType;
import vn.itechcorp.admin.util.Util;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsTypeDTOCreate extends DtoCreate<StatisticsType, String> {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    private String description;

    private Set<String> schemaParams;

    private Set<String> filterParams;

    private String config;

    @Override
    public StatisticsType toEntry() {
        StatisticsType object = new StatisticsType();
        object.setId(getId());
        object.setName(Util.toCleanText(name));
        object.setDescription(Util.toCleanText(description));
        object.setConfig(Util.toCleanText(config));
        object.setSchemaParams(CollectionUtil.toString(schemaParams));
        object.setFilterParams(CollectionUtil.toString(filterParams));
        return object;
    }
}
