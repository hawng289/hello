package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.Domain;


@Repository("domainRepository")
public interface DomainRepository extends BaseRepository<Domain, String> {
}
