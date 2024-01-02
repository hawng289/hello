package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.ModalityTypeNameRepository;
import vn.itechcorp.admin.jpa.entity.ModalityTypeName;
import vn.itechcorp.admin.service.dto.ModalityTypeNameDTOGet;


@Service("modalityTypeNameService")
public class ModalityTypeNameServiceImpl extends BaseDtoJpaServiceImpl<ModalityTypeNameDTOGet, ModalityTypeName, String> implements ModalityTypeNameService {

    private final ModalityTypeNameRepository modalityTypeNameRepository;

    public ModalityTypeNameServiceImpl(ModalityTypeNameRepository modalityTypeNameRepository) {
        this.modalityTypeNameRepository = modalityTypeNameRepository;
    }

    @Override
    public ModalityTypeNameRepository getRepository() {
        return modalityTypeNameRepository;
    }

    @Override
    public ModalityTypeNameDTOGet convert(ModalityTypeName object) {
        return new ModalityTypeNameDTOGet(object);
    }
}
