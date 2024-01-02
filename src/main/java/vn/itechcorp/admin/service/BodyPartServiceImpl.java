package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.BodyPartRepository;
import vn.itechcorp.admin.jpa.entity.BodyPart;
import vn.itechcorp.admin.service.dto.BodyPartDTOGet;

@Service("bodyPartService")
public class BodyPartServiceImpl extends BaseDtoJpaServiceImpl<BodyPartDTOGet, BodyPart, String> implements BodyPartService {

    private final BodyPartRepository bodyPartRepository;

    @Override
    public BodyPartRepository getRepository() {
        return bodyPartRepository;
    }

    public BodyPartServiceImpl(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    @Override
    public BodyPartDTOGet convert(BodyPart object) {
        return new BodyPartDTOGet(object);
    }
}
