package vn.itechcorp.admin.service;

import vn.com.itechcorp.base.service.BaseDtoService;
import vn.itechcorp.admin.jpa.RoleRepository;
import vn.itechcorp.admin.jpa.entity.Role;
import vn.itechcorp.admin.service.dto.RoleDTOGet;

public interface RoleService extends BaseDtoService<RoleDTOGet, Role, String> {

    RoleRepository getRepository();
}
