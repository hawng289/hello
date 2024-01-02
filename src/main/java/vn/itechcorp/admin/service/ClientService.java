package vn.itechcorp.admin.service;

import vn.com.itechcorp.base.service.BaseDtoService;
import vn.itechcorp.admin.jpa.entity.Client;
import vn.itechcorp.admin.service.dto.ClientDTOGet;
import vn.itechcorp.admin.service.dto.ClientType;

public interface ClientService extends BaseDtoService<ClientDTOGet, Client, String> {

    ClientDTOGet getAdmin(String id, String secret);

    ClientDTOGet get(String id, String secret, ClientType type);
}
