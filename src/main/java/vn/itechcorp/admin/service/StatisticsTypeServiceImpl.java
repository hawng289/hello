package vn.itechcorp.admin.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.exception.APIException;
import vn.com.itechcorp.base.service.dto.DtoUpdate;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.StatisticsTypeRepository;
import vn.itechcorp.admin.jpa.entity.StatisticsType;
import vn.itechcorp.admin.service.dto.StatisticsTypeDTOGet;

@Service("statisticsTypeService")
public class StatisticsTypeServiceImpl extends BaseDtoJpaServiceImpl<StatisticsTypeDTOGet, StatisticsType, String> implements StatisticsTypeService {

    private final StatisticsTypeRepository statisticsTypeRepository;

    public StatisticsTypeServiceImpl(StatisticsTypeRepository statisticsTypeRepository) {
        this.statisticsTypeRepository = statisticsTypeRepository;
    }

    @Override
    public StatisticsTypeRepository getRepository() {
        return statisticsTypeRepository;
    }

    @Override
    public StatisticsTypeDTOGet convert(StatisticsType object) {
        return new StatisticsTypeDTOGet(object);
    }

    @Override
    @CachePut(value = "statisticsType", key = "#entity.id")
    public StatisticsTypeDTOGet updateAndGet(DtoUpdate<StatisticsType, String> entity) throws APIException {
        return super.updateAndGet(entity);
    }

    @Override
    @CacheEvict(value = "statisticsType", key = "#entity.id")
    public String update(DtoUpdate<StatisticsType, String> entity) throws APIException {
        return super.update(entity);
    }

    @Override
    @CacheEvict(value = "statisticsType", key = "#id")
    public void deleteByID(String id) throws APIException {
        super.deleteByID(id);
    }

    @Override
    @CacheEvict(value = "statisticsType", key = "#id")
    public StatisticsTypeDTOGet deleteAndGet(String id) throws APIException {
        return super.deleteAndGet(id);
    }

    @Override
    @Cacheable(value = "statisticsType", key = "#id", unless = "#result == null")
    public StatisticsTypeDTOGet getById(String id) throws APIException {
        return super.getById(id);
    }

}
