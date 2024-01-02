package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.DtoGet;
import vn.com.itechcorp.base.util.CollectionUtil;
import vn.itechcorp.admin.jpa.entity.StatisticsType;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StatisticsTypeDTOGet extends DtoGet<StatisticsType, String> {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private Set<String> schemaParams;

    private Set<String> filterParams;

    private String config;

    public StatisticsTypeDTOGet(StatisticsType object) {
        super(object);
    }

    @Override
    public void parse(StatisticsType object) {
        this.name = object.getName();
        this.description = object.getDescription();
        this.schemaParams = CollectionUtil.toSet(object.getSchemaParams());
        this.filterParams = CollectionUtil.toSet(object.getFilterParams());
        this.config = object.getConfig();
    }
}
