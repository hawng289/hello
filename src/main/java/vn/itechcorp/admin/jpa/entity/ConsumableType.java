package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_consumable_type")
@Getter
@Setter
public class ConsumableType extends MetadataEntry {

    public ConsumableType() {
        super();
    }

    public ConsumableType(String id) {
        super(id);
    }
}
