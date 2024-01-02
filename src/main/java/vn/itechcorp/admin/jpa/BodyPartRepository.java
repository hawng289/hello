package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.BodyPart;

@Repository("bodyPartRepository")
public interface BodyPartRepository extends BaseRepository<BodyPart, String> {
}
