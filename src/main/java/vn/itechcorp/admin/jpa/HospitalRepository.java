package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.Hospital;

import java.util.Optional;

@Repository("hospitalRepository")
public interface HospitalRepository extends BaseRepository<Hospital, String> {

    @Override
    Optional<Hospital> findById(String id);

}
