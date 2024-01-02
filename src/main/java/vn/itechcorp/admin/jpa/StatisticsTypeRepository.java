package vn.itechcorp.admin.jpa;

import org.springframework.stereotype.Repository;
import vn.com.itechcorp.base.persistence.repository.BaseRepository;
import vn.itechcorp.admin.jpa.entity.StatisticsType;

@Repository("statisticsTypeRepository")
public interface StatisticsTypeRepository extends BaseRepository<StatisticsType, String> {
}
