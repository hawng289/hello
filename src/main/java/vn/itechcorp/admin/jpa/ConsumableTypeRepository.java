package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.ConsumableType;

@Repository("consumableTypeRepository")
public interface ConsumableTypeRepository extends BaseRepository<ConsumableType, String> {
}
