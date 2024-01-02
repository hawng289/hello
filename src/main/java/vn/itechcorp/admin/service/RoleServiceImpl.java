package vn.itechcorp.admin.service;

import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.RoleRepository;
import vn.itechcorp.admin.jpa.entity.Role;
import vn.itechcorp.admin.service.dto.RoleDTOGet;

@Service("roleService")
public class RoleServiceImpl extends BaseDtoJpaServiceImpl<RoleDTOGet, Role, String> implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleRepository getRepository() {
        return roleRepository;
    }

    @Override
    public RoleDTOGet convert(Role object) {
        return new RoleDTOGet(object);
    }
}
