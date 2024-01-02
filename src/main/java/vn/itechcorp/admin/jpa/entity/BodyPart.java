package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_body_part")
@Getter
@Setter
public class BodyPart extends MetadataEntry {

    public BodyPart() {
        super();
    }

    public BodyPart(String id) {
        super(id);
    }

}