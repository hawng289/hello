package vn.itechcorp.admin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.com.itechcorp.base.exception.APIException;
import vn.com.itechcorp.base.exception.InvalidOperationOnObjectException;
import vn.com.itechcorp.base.service.impl.BaseDtoJpaServiceImpl;
import vn.com.itechcorp.pacs.cloud.base.security.UserPasswordEncoder;
import vn.itechcorp.admin.jpa.ClientRepository;
import vn.itechcorp.admin.jpa.entity.Client;
import vn.itechcorp.admin.service.dto.ClientAuthority;
import vn.itechcorp.admin.service.dto.ClientDTOGet;
import vn.itechcorp.admin.service.dto.ClientType;

import java.util.Collections;

@Service("clientService")
public class ClientServiceImpl extends BaseDtoJpaServiceImpl<ClientDTOGet, Client, String> implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientRepository getRepository() {
        return clientRepository;
    }

    @Override
    public ClientDTOGet convert(Client object) {
        return new ClientDTOGet(object);
    }

    @Value("${sysadmin.user:sysadmin}")
    private String adminUser;

    @Value("${sysadmin.password:itrp142536}")
    private String adminSecret;

    @Override
    public ClientDTOGet getAdmin(String id, String secret) {
        Client client = getRepository().findFirstByIdAndType(id, ClientType.sysadmin);
        if (client != null) {
            if (UserPasswordEncoder.getInstance().matches(secret, client.getSecret())) return convert(client);
            return null;
        }
        if (!id.equals(adminUser) || !secret.equals(adminSecret)) return null;

        ClientDTOGet object = new ClientDTOGet();
        object.setId(adminUser);
        object.setType(ClientType.sysadmin);
        object.setSecret(UserPasswordEncoder.getInstance().encode(adminSecret));
        object.setAuthorities(Collections.singleton(ClientAuthority.admin.name()));

        return object;
    }

    @Override
    public ClientDTOGet get(String id, String secret, ClientType type) {
        Client client = getRepository().findFirstByIdAndType(id, type);
        if (client != null) {
            if (UserPasswordEncoder.getInstance().matches(secret, client.getSecret())) return convert(client);
            return null;
        }
        return null;
    }

    @Override
    public void deleteByID(String id) throws APIException {
        if (!id.equals(adminUser)) throw new InvalidOperationOnObjectException("Cannot delete sysadmin");
        super.deleteByID(id);
    }

    @Override
    public ClientDTOGet deleteAndGet(String id) throws APIException {
        if (!id.equals(adminUser)) throw new InvalidOperationOnObjectException("Cannot delete sysadmin");
        return super.deleteAndGet(id);
    }
}
