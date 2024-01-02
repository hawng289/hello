package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.ConsumableTypeRepository;
import vn.itechcorp.admin.jpa.entity.ConsumableType;
import vn.itechcorp.admin.service.dto.ConsumableTypeDTOGet;

@Service("consumableTypeService")
public class ConsumableTypeServiceImpl extends BaseDtoJpaServiceImpl<ConsumableTypeDTOGet, ConsumableType, String> implements ConsumableTypeService {

    private final ConsumableTypeRepository consumableTypeRepository;

    public ConsumableTypeServiceImpl(ConsumableTypeRepository consumableTypeRepository) {
        this.consumableTypeRepository = consumableTypeRepository;
    }

    @Override
    public ConsumableTypeRepository getRepository() {
        return consumableTypeRepository;
    }

    @Override
    public ConsumableTypeDTOGet convert(ConsumableType object) {
        return new ConsumableTypeDTOGet(object);
    }
}
