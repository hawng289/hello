package vn.itechcorp.admin.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.api.method.AsyncBaseDtoAPIMethod;
import vn.com.itechcorp.base.api.response.APIResponse;
import vn.com.itechcorp.base.api.response.APIResponseHeader;
import vn.com.itechcorp.base.api.response.APIResponseStatus;
import vn.com.itechcorp.base.exception.APIAuthenticationException;
import vn.com.itechcorp.base.service.BaseDtoService;
import vn.itechcorp.admin.security.JwtTokenResponse;
import vn.itechcorp.admin.jpa.entity.Admin;
import vn.itechcorp.admin.service.AdminService;
import vn.itechcorp.admin.service.dto.AdminDTOGet;
import vn.itechcorp.admin.service.dto.CredentialDTORequest;

import java.util.concurrent.CompletableFuture;

@Service("adminAPIMethod")
public class AdminAPIMethod extends AsyncBaseDtoAPIMethod<AdminDTOGet, Admin, Long> {
    @Autowired
    public AdminAPIMethod(AdminService service) {
        super(service);
    }

    @Override
    public AdminService getService() {
        return (AdminService)super.getService();
    }
    public AdminAPIMethod(BaseDtoService<AdminDTOGet, Admin, Long> service) {
        super(service);
    }
    public ResponseEntity<APIResponse<JwtTokenResponse>> login(CredentialDTORequest credential) {
        try {
            JwtTokenResponse getDto = getService().login(credential);
            getLogger().info("User information returned: " + getDto.toString());
            return new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.OK, "Logged in"), getDto), HttpStatus.OK);
        } catch (APIAuthenticationException ex) {
            getLogger().error(ex.getMessage());
            return new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.UNAUTHORIZED, ex.getMessage()), null), HttpStatus.FORBIDDEN);
        } catch (Exception ex) {
            getLogger().error(ex.getMessage());
            return new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INTERNAL_SERVER_ERROR, ex.getMessage()), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public CompletableFuture<ResponseEntity<APIResponse<JwtTokenResponse>>> loginAsync(CredentialDTORequest credentialDTO) {
        return CompletableFuture.completedFuture(this.login(credentialDTO));
    }
}
