package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.HospitalRepository;
import vn.itechcorp.admin.jpa.entity.Hospital;
import vn.itechcorp.admin.service.dto.HospitalDTOGet;

@Service("hospitalService")
public class HospitalServiceImpl extends BaseDtoJpaServiceImpl<HospitalDTOGet, Hospital, String> implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public HospitalRepository getRepository() {
        return hospitalRepository;
    }

    @Override
    public HospitalDTOGet convert(Hospital object) {
        return new HospitalDTOGet(object);
    }

    @Override
    public void fetchLazyInformation(HospitalDTOGet out, Hospital object) {
        out.setLogo(object.getLogo());
        out.setLogoFull(object.getLogoFull());
    }
}
