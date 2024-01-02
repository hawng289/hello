package vn.itechcorp.admin.jpa.entity;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;

import java.util.List;

@Repository("AdminRepository")
public interface AdminRepository extends BaseRepository<Admin, Long> {

    List<Admin> findAllByUsername(String username);
}
