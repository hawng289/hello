package vn.itechcorp.admin.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.itechcorp.base.api.method.AsyncBaseDtoAPIMethod;
import vn.com.itechcorp.base.api.response.APIResponse;

import java.util.concurrent.CompletableFuture;
@RestController("loginController")
@RequestMapping("/ws/rest/v1")
public class LoginController {
    @Autowired
    AdminAPIMethod adminAPIMethod;

    @ApiOperation(value = "Login to the system")
    @PostMapping(path = "/login")
    public CompletableFuture<ResponseEntity<APIResponse<JwtTokenResponse>>> login(
            @RequestBody CredentialDTORequest credentialDTO) {
        return adminAPIMethod.loginAsync(credentialDTO);
    }
}
