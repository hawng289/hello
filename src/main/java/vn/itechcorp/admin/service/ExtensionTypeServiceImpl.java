package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.ExtensionTypeRepository;
import vn.itechcorp.admin.jpa.entity.ExtensionType;
import vn.itechcorp.admin.service.dto.ExtensionTypeDTOGet;

@Service("extensionTypeService")
public class ExtensionTypeServiceImpl extends BaseDtoJpaServiceImpl<ExtensionTypeDTOGet, ExtensionType, String> implements ExtensionTypeService {

    private final ExtensionTypeRepository extensionTypeRepository;

    public ExtensionTypeServiceImpl(ExtensionTypeRepository extensionTypeRepository) {
        this.extensionTypeRepository = extensionTypeRepository;
    }

    @Override
    public ExtensionTypeRepository getRepository() {
        return extensionTypeRepository;
    }

    @Override
    public ExtensionTypeDTOGet convert(ExtensionType object) {
        return new ExtensionTypeDTOGet(object);
    }
}
