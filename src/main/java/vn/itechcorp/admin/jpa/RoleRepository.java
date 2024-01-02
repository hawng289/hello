package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.Role;

@Repository("roleRepository")
public interface RoleRepository extends BaseRepository<Role, String> {
}
