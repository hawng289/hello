package vn.itechcorp.admin.jpa.entity;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.persistence.model.BaseDbEntry;
import vn.itechcorp.admin.service.dto.ClientAuthority;
import vn.itechcorp.admin.service.dto.ClientType;

import javax.persistence.*;

@Entity
@Table(name = "gb_client")
@Getter
@Setter
public class Client extends BaseDbEntry<String> {

    private static final long serialVersionUID = 1L;

    @Column(name = "secret")
    private String secret;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ClientType type = ClientType.connector;

    @Column(name = "authorities", nullable = false)
    private String authorities = ClientAuthority.query.name();

    @Column(name = "ip_allowed")
    private String ipAllowed;

    @Column(name = "hospital_id", nullable = false)
    private String hospitalID;

    public Client() {
        super();
    }

    public Client(String id) {
        super(id);
    }
}
