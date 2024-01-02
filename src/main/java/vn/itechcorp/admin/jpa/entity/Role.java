package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_role")
@Getter
@Setter
public class Role extends MetadataEntry {

    public Role() {
        super();
    }

    public Role(String id) {
        super(id);
    }
}
