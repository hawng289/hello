package vn.itechcorp.admin.service.dto;

import lombok.Getter;
import lombok.Setter;
import vn.com.itechcorp.base.service.dto.Dto;

@Getter
@Setter
public class CredentialDTORequest extends Dto {

    private String username;

    private String password;
}

