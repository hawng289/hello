package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.Client;
import vn.itechcorp.admin.service.dto.ClientType;


@Repository("clientRepository")
public interface ClientRepository extends BaseRepository<Client, String> {
    Client findFirstByIdAndType(String id, ClientType type);
}
