package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.ModalityTypeName;

@Repository("modalityTypeNameRepository")
public interface ModalityTypeNameRepository extends BaseRepository<ModalityTypeName, String> {
}
