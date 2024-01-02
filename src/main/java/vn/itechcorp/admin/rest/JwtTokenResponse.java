package vn.itechcorp.admin.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class JwtTokenResponse implements Serializable {

        private String access_token;

        private String token_type;

        private long expires_in;


}
