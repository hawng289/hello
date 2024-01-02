package vn.itechcorp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.exception.APIAuthenticationException;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.itechcorp.admin.jpa.DomainRepository;
import vn.itechcorp.admin.jpa.entity.Admin;
import vn.itechcorp.admin.jpa.entity.AdminRepository;
import vn.itechcorp.admin.service.dto.CredentialDTORequest;
import vn.itechcorp.admin.security.JwtTokenResponse;
import vn.itechcorp.admin.service.dto.AdminDTOGet;
import vn.itechcorp.admin.util.JwtTokenUtil;
import vn.itechcorp.admin.security.JwtAdminDetails;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl extends BaseDtoJpaServiceImpl<AdminDTOGet, Admin, Long> implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public AdminRepository getRepository() {
        return adminRepository;
    }

    @Override
    public JwtTokenResponse login(CredentialDTORequest credential) {
        List<Admin> admins = adminRepository.findAllByUsername(credential.getUsername());
        if (admins == null || admins.isEmpty()) throw new APIAuthenticationException("Invalid credential");

        for (Admin admin : admins) {
            if (String.valueOf(admin.getPassword()).equals(credential.getPassword()))
                return jwtTokenUtil.generateToken(new JwtAdminDetails(admin));
        }

        throw new APIAuthenticationException("Invalid credential");
    }

    @Override
    public AdminDTOGet convert(Admin admin) {
        return null;
    }
}
