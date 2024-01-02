package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.DomainRepository;
import vn.itechcorp.admin.jpa.entity.Domain;
import vn.itechcorp.admin.service.dto.DomainDTOGet;
import vn.itechcorp.admin.service.dto.HospitalDTOGet;

@Service("domainService")
public class DomainServiceImpl extends BaseDtoJpaServiceImpl<DomainDTOGet, Domain, String> implements DomainService {

    private final DomainRepository domainRepository;

    private final HospitalService hospitalService;

    public DomainServiceImpl(DomainRepository domainRepository, HospitalService hospitalService) {
        this.domainRepository = domainRepository;
        this.hospitalService = hospitalService;
    }

    @Override
    public DomainRepository getRepository() {
        return domainRepository;
    }

    @Override
    public DomainDTOGet convert(Domain object) {
        return new DomainDTOGet(object);
    }

    @Override
    public void fetchLazyInformation(DomainDTOGet out, Domain object) {
        HospitalDTOGet hospital = hospitalService.getById(object.getHospitalID());
        if (hospital != null) {
            out.setLogo(hospital.getLogo());
            out.setLogoFull(hospital.getLogoFull());
        }
    }
}
