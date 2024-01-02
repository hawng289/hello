package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.persistence.model.BaseDbEntry;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class MetadataEntry extends BaseDbEntry<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public MetadataEntry() {
        super();
    }

    public MetadataEntry(String id) {
        super(id);
    }
}
