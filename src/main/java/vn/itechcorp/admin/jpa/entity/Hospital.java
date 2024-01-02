package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import vn.com.itechcorp.base.persistence.model.BaseDbEntry;

import javax.persistence.*;

@Entity
@Table(name = "gb_hospital")
@Getter
@Setter
public class Hospital extends BaseDbEntry<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    @Column(name = "name_search")
    private String nameSearch;

    @Column(name = "description")
    private String description;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.hibernate.type.BinaryType")
    @Lob
    @Column(name = "logo", columnDefinition = "BLOB")
    private byte[] logo;

    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.hibernate.type.BinaryType")
    @Lob
    @Column(name = "logo_full", columnDefinition = "BLOB")
    private byte[] logoFull;

    @Column(name = "enabled")
    private boolean enabled = true;

    public Hospital() {
        super();
    }

    public Hospital(String id) {
        super(id);
    }

}
