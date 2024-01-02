package vn.itechcorp.admin.rest;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.Admin;

import java.util.List;

@Repository("AdminRepository")

public interface AdminRepository extends BaseRepository<Admin, Long> {

    List<Admin> findAllByUsername(String username);
}
