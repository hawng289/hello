package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.ExtensionType;

@Repository("extensionTypeRepository")
public interface ExtensionTypeRepository extends BaseRepository<ExtensionType, String> {
}
