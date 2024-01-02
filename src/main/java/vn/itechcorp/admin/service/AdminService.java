package vn.itechcorp.admin.service;

import vn.com.itechcorp.base.service.BaseDtoService;
import vn.itechcorp.admin.jpa.entity.Admin;
import vn.itechcorp.admin.service.dto.CredentialDTORequest;
import vn.itechcorp.admin.security.JwtTokenResponse;
import vn.itechcorp.admin.service.dto.AdminDTOGet;

public interface AdminService extends BaseDtoService<AdminDTOGet, Admin, Long> {
    JwtTokenResponse login(CredentialDTORequest credential);
}
