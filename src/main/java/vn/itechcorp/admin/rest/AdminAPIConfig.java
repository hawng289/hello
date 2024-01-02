package vn.itechcorp.admin.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.com.itechcorp.base.api.method.AsyncBaseDtoAPIMethod;
import vn.itechcorp.admin.jpa.entity.*;
import vn.itechcorp.admin.service.*;
import vn.itechcorp.admin.service.dto.*;

@Configuration
public class AdminAPIConfig {

    @Bean("hospitalAPIMethod")
    public AsyncBaseDtoAPIMethod<HospitalDTOGet, Hospital, String> getHospitalAPIMethod(HospitalService hospitalService) {
        return new AsyncBaseDtoAPIMethod<>(hospitalService);
    }

    @Bean("domainAPIMethod")
    public AsyncBaseDtoAPIMethod<DomainDTOGet, Domain, String> getDomainAPIMethod(DomainService domainService) {
        return new AsyncBaseDtoAPIMethod<>(domainService);
    }

    @Bean("clientAPIMethod")
    public AsyncBaseDtoAPIMethod<ClientDTOGet, Client, String> getClientAPIMethod(ClientService clientService) {
        return new AsyncBaseDtoAPIMethod<>(clientService);
    }

    @Bean("roleAPIMethod")
    public AsyncBaseDtoAPIMethod<RoleDTOGet, Role, String> getRoleAPIMethod(RoleService roleService) {
        return new AsyncBaseDtoAPIMethod<>(roleService);
    }

    @Bean("bodyPartAPIMethod")
    public AsyncBaseDtoAPIMethod<BodyPartDTOGet, BodyPart, String> getBodyPartAPIMethod(BodyPartService bodyPartService) {
        return new AsyncBaseDtoAPIMethod<>(bodyPartService);
    }

    @Bean("consumableTypeAPIMethod")
    public AsyncBaseDtoAPIMethod<ConsumableTypeDTOGet, ConsumableType, String> getConsumableTypeAPIMethod(ConsumableTypeService consumableTypeService) {
        return new AsyncBaseDtoAPIMethod<>(consumableTypeService);
    }

    @Bean("modalityTypeNameAPIMethod")
    public AsyncBaseDtoAPIMethod<ModalityTypeNameDTOGet, ModalityTypeName, String> getModalityTypeNameAPIMethod(ModalityTypeNameService modalityTypeNameService) {
        return new AsyncBaseDtoAPIMethod<>(modalityTypeNameService);
    }

    @Bean("configAttributeAPIMethod")
    public AsyncBaseDtoAPIMethod<ConfigAttributeDTOGet, ConfigAttribute, String> getConfigAttributeAPIMethod(ConfigAttributeService configAttributeService) {
        return new AsyncBaseDtoAPIMethod<>(configAttributeService);
    }

    @Bean("extensionTypeAPIMethod")
    public AsyncBaseDtoAPIMethod<ExtensionTypeDTOGet, ExtensionType, String> getExtensionTypeAPIMethod(ExtensionTypeService extensionTypeService) {
        return new AsyncBaseDtoAPIMethod<>(extensionTypeService);
    }

    @Bean("statisticsTypeAPIMethod")
    public AsyncBaseDtoAPIMethod<StatisticsTypeDTOGet, StatisticsType, String> getStatisticsTypeAPIMethod(StatisticsTypeService statisticsTypeService) {
        return new AsyncBaseDtoAPIMethod<>(statisticsTypeService);
    }

}
