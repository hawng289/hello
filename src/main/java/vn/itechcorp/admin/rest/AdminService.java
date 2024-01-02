package vn.itechcorp.admin.rest;

import vn.com.itechcorp.base.service.BaseDtoService;
import vn.itechcorp.admin.jpa.entity.Admin;

public interface AdminService extends BaseDtoService<AdminDTOGet, Admin, Long> {
    JwtTokenResponse login(CredentialDTORequest credential);
}
