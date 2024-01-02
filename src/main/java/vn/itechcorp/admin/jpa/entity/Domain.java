package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.persistence.model.BaseDbEntry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gb_domain")
@Getter
@Setter
public class Domain extends BaseDbEntry<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "public_address")
    private boolean publicAddress = true;

    @Column(name = "preferred")
    private boolean preferred = true;

    @Column(name = "hospital_id", nullable = false)
    private String hospitalID;

    public Domain() {
        super();
    }

    public Domain(String id) {
        super(id);
    }
}
