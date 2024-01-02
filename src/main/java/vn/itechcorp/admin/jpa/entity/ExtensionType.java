package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_extension_type")
@Getter
@Setter
public class ExtensionType extends MetadataEntry {

    public ExtensionType() {
        super();
    }

    public ExtensionType(String id) {
        super(id);
    }
}
