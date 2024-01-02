package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_modality_type_name")
@Getter
@Setter
public class ModalityTypeName extends MetadataEntry {

    public ModalityTypeName() {
        super();
    }

    public ModalityTypeName(String id) {
        super(id);
    }
}
