package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.persistence.model.BaseDbEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_statistics_type")
@Getter
@Setter
public class StatisticsType extends BaseDbEntry<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "schema_params")
    private String schemaParams;

    @Column(name = "filter_params")
    private String filterParams;

    @Column(name = "config")
    private String config;

    public StatisticsType() {
        super();
    }

    public StatisticsType(String id) {
        super(id);
    }
}
