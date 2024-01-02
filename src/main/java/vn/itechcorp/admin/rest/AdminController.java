package vn.itechcorp.admin.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import vn.com.itechcorp.base.api.method.AsyncBaseDtoAPIMethod;
import vn.com.itechcorp.base.api.response.APIListResponse;
import vn.com.itechcorp.base.api.response.APIResponse;
import vn.com.itechcorp.base.api.response.APIResponseHeader;
import vn.com.itechcorp.base.api.response.APIResponseStatus;
import vn.com.itechcorp.base.service.filter.PaginationInfo;
import vn.itechcorp.admin.jpa.entity.*;
import vn.itechcorp.admin.service.dto.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Api(value = "sysadmin-api", tags = "sysadmin-api")
@RequestMapping("/sysadmin/ws/rest/v1")
public class AdminController {

    private final AsyncBaseDtoAPIMethod<HospitalDTOGet, Hospital, String> hospitalAPIMethod;

    private final AsyncBaseDtoAPIMethod<RoleDTOGet, Role, String> roleAPIMethod;

    private final AsyncBaseDtoAPIMethod<DomainDTOGet, Domain, String> domainAPIMethod;

    private final AsyncBaseDtoAPIMethod<ClientDTOGet, Client, String> clientAPIMethod;

    private final AsyncBaseDtoAPIMethod<BodyPartDTOGet, BodyPart, String> bodyPartAPIMethod;

    private final AsyncBaseDtoAPIMethod<ConsumableTypeDTOGet, ConsumableType, String> consumableTypeAPIMethod;

    private final AsyncBaseDtoAPIMethod<ModalityTypeNameDTOGet, ModalityTypeName, String> modalityTypeNameAPIMethod;

    private final AsyncBaseDtoAPIMethod<ConfigAttributeDTOGet, ConfigAttribute, String> configAttributeAPIMethod;

    private final AsyncBaseDtoAPIMethod<ExtensionTypeDTOGet, ExtensionType, String> extensionTypeAPIMethod;

    private final AsyncBaseDtoAPIMethod<StatisticsTypeDTOGet, StatisticsType, String> statisticsTypeAPIMethod;

    public AdminController(
            AsyncBaseDtoAPIMethod<RoleDTOGet, Role, String> roleAPIMethod,
            AsyncBaseDtoAPIMethod<DomainDTOGet, Domain, String> domainAPIMethod,
            AsyncBaseDtoAPIMethod<ClientDTOGet, Client, String> clientAPIMethod,
            AsyncBaseDtoAPIMethod<BodyPartDTOGet, BodyPart, String> bodyPartAPIMethod,
            AsyncBaseDtoAPIMethod<ConsumableTypeDTOGet, ConsumableType, String> consumableTypeAPIMethod,
            AsyncBaseDtoAPIMethod<ModalityTypeNameDTOGet, ModalityTypeName, String> modalityTypeNameAPIMethod,
            AsyncBaseDtoAPIMethod<ConfigAttributeDTOGet, ConfigAttribute, String> configAttributeAPIMethod,
            AsyncBaseDtoAPIMethod<ExtensionTypeDTOGet, ExtensionType, String> extensionTypeAPIMethod,
            AsyncBaseDtoAPIMethod<StatisticsTypeDTOGet, StatisticsType, String> statisticsTypeAPIMethod,
            AsyncBaseDtoAPIMethod<HospitalDTOGet, Hospital, String> hospitalAPIMethod) {
        this.roleAPIMethod = roleAPIMethod;
        this.domainAPIMethod = domainAPIMethod;
        this.clientAPIMethod = clientAPIMethod;
        this.bodyPartAPIMethod = bodyPartAPIMethod;
        this.consumableTypeAPIMethod = consumableTypeAPIMethod;
        this.modalityTypeNameAPIMethod = modalityTypeNameAPIMethod;
        this.configAttributeAPIMethod = configAttributeAPIMethod;
        this.extensionTypeAPIMethod = extensionTypeAPIMethod;
        this.statisticsTypeAPIMethod = statisticsTypeAPIMethod;
        this.hospitalAPIMethod = hospitalAPIMethod;
    }

    @ApiOperation(value = "View a list of hospitals")
    @GetMapping("/async/hospital")
    public CompletableFuture<ResponseEntity<APIListResponse<List<HospitalDTOGet>>>> getAllHospitals(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return hospitalAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a hospital by ID")
    @GetMapping("/async/hospital/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<HospitalDTOGet>>> getHospitalById(
            @PathVariable("id") String id) {
        return hospitalAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new hospital")
    @PostMapping("/async/hospital")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createHospital(
            @Valid @RequestBody HospitalDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return hospitalAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a hospital")
    @PutMapping("/async/hospital")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateHospital(
            @Valid @RequestBody HospitalDTOUpdate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return hospitalAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a hospital by ID")
    @DeleteMapping("/async/hospital/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteHospitalByID(
            @PathVariable("id") String id) {
        return hospitalAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of clients")
    @GetMapping("/async/client")
    public CompletableFuture<ResponseEntity<APIListResponse<List<ClientDTOGet>>>> getAllClients(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return clientAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a client by ID")
    @GetMapping("/async/client/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<ClientDTOGet>>> getClientById(
            @PathVariable("id") String id) {
        return clientAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new client")
    @PostMapping("/async/client")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createClient(
            @Valid @RequestBody ClientDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return clientAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a client")
    @PutMapping("/async/client")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateClient(
            @Valid @RequestBody ClientDTOUpdate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return clientAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a client by ID")
    @DeleteMapping("/async/client/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteClientByID(
            @PathVariable("id") String id) {
        return clientAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of domains")
    @GetMapping("/async/domain")
    public CompletableFuture<ResponseEntity<APIListResponse<List<DomainDTOGet>>>> getAllDomains(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return domainAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a domain by ID")
    @GetMapping("/async/domain/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<DomainDTOGet>>> getDomainById(
            @PathVariable("id") String id) {
        return domainAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new domain")
    @PostMapping("/async/domain")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createDomain(
            @Valid @RequestBody DomainDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return domainAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Delete a domain by ID")
    @DeleteMapping("/async/domain/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteDomainByID(
            @PathVariable("id") String id) {
        return domainAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of config attributes")
    @GetMapping("/async/configAttribute")
    public CompletableFuture<ResponseEntity<APIListResponse<List<ConfigAttributeDTOGet>>>> getAllConfigAttributes(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return configAttributeAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a config attribute by ID")
    @GetMapping("/async/configAttribute/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<ConfigAttributeDTOGet>>> getConfigAttributeById(
            @PathVariable("id") String id) {
        return configAttributeAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new config attribute")
    @PostMapping("/async/configAttribute")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createConfigAttribute(
            @Valid @RequestBody ConfigAttributeDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return configAttributeAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a config attribute")
    @PutMapping("/async/configAttribute")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateConfigAttribute(
            @Valid @RequestBody ConfigAttributeDTOUpdate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return configAttributeAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a config attribute by ID")
    @DeleteMapping("/async/configAttribute/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteConfigAttributeByID(
            @PathVariable("id") String id) {
        return configAttributeAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of statistics types")
    @GetMapping("/async/statisticsType")
    public CompletableFuture<ResponseEntity<APIListResponse<List<StatisticsTypeDTOGet>>>> getAllStatisticsTypes(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return statisticsTypeAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a statistics type by ID")
    @GetMapping("/async/statisticsType/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<StatisticsTypeDTOGet>>> getStatisticsTypeById(
            @PathVariable("id") String id) {
        return statisticsTypeAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new statistics type")
    @PostMapping("/async/statisticsType")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createStatisticsType(
            @Valid @RequestBody StatisticsTypeDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return statisticsTypeAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a statistics type")
    @PutMapping("/async/statisticsType")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateStatisticsType(
            @Valid @RequestBody StatisticsTypeDTOUpdate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return statisticsTypeAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a statistics type by ID")
    @DeleteMapping("/async/statisticsType/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteStatisticsTypeByID(
            @PathVariable("id") String id) {
        return statisticsTypeAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of body parts")
    @GetMapping("/async/bodyPart")
    public CompletableFuture<ResponseEntity<APIListResponse<List<BodyPartDTOGet>>>> getAllBodyParts(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return bodyPartAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a body part by ID")
    @GetMapping("/async/bodyPart/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<BodyPartDTOGet>>> getBodyPartById(
            @PathVariable("id") String id) {
        return bodyPartAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new body part")
    @PostMapping("/async/bodyPart")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createBodyPart(
            @Valid @RequestBody BodyPartDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return bodyPartAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a body part")
    @PutMapping("/async/bodyPart")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateBodyPart(
            @Valid @RequestBody MetadataDTOUpdate<BodyPart> entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return bodyPartAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a body part by ID")
    @DeleteMapping("/async/bodyPart/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteBodyPartByID(
            @PathVariable("id") String id) {
        return bodyPartAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of modality type names")
    @GetMapping("/async/modalityTypeName")
    public CompletableFuture<ResponseEntity<APIListResponse<List<ModalityTypeNameDTOGet>>>> getAllModalityTypeNames(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return modalityTypeNameAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a modality type name by ID")
    @GetMapping("/async/modalityTypeName/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<ModalityTypeNameDTOGet>>> getModalityTypeNameById(
            @PathVariable("id") String id) {
        return modalityTypeNameAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new modality type name")
    @PostMapping("/async/modalityTypeName")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createModalityTypeName(
            @Valid @RequestBody ModalityTypeNameDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return modalityTypeNameAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a modality type name")
    @PutMapping("/async/modalityTypeName")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateModalityTypeName(
            @Valid @RequestBody MetadataDTOUpdate<ModalityTypeName> entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return modalityTypeNameAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a modality type name by ID")
    @DeleteMapping("/async/modalityTypeName/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteModalityTypeNameByID(
            @PathVariable("id") String id) {
        return modalityTypeNameAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of roles")
    @GetMapping("/async/role")
    public CompletableFuture<ResponseEntity<APIListResponse<List<RoleDTOGet>>>> getAllRoles(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return roleAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a role by ID")
    @GetMapping("/async/role/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<RoleDTOGet>>> getRoleById(
            @PathVariable("id") String id) {
        return roleAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new role")
    @PostMapping("/async/role")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createRole(
            @Valid @RequestBody RoleDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return roleAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a role")
    @PutMapping("/async/role")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateRole(
            @Valid @RequestBody MetadataDTOUpdate<Role> entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return roleAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a role by ID")
    @DeleteMapping("/async/role/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteRoleByID(
            @PathVariable("id") String id) {
        return roleAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of extension types")
    @GetMapping("/async/extensionType")
    public CompletableFuture<ResponseEntity<APIListResponse<List<ExtensionTypeDTOGet>>>> getAllExtensionTypes(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return extensionTypeAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a extension type by ID")
    @GetMapping("/async/extensionType/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<ExtensionTypeDTOGet>>> getExtensionTypeById(
            @PathVariable("id") String id) {
        return extensionTypeAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new extension type")
    @PostMapping("/async/extensionType")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createExtensionType(
            @Valid @RequestBody ExtensionTypeDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return extensionTypeAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a extension type")
    @PutMapping("/async/extensionType")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateExtensionType(
            @Valid @RequestBody MetadataDTOUpdate<ExtensionType> entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return extensionTypeAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a extension type by ID")
    @DeleteMapping("/async/extensionType/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteExtensionTypeByID(
            @PathVariable("id") String id) {
        return extensionTypeAPIMethod.deleteAsync(id);
    }

    @ApiOperation(value = "View a list of consumable types")
    @GetMapping("/async/consumableType")
    public CompletableFuture<ResponseEntity<APIListResponse<List<ConsumableTypeDTOGet>>>> getAllConsumableTypes(
            @RequestParam(required = false, name = "orderBy") String orderBy,
            @RequestParam(required = false, name = "offset", defaultValue = "0") int offset,
            @RequestParam(required = false, name = "limit", defaultValue = "100") int limit) {
        return consumableTypeAPIMethod.getListAsync(new PaginationInfo(offset, limit, orderBy));
    }

    @ApiOperation(value = "View a consumable type by ID")
    @GetMapping("/async/consumableType/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<ConsumableTypeDTOGet>>> getConsumableTypeById(
            @PathVariable("id") String id) {
        return consumableTypeAPIMethod.getByIdAsync(id);
    }

    @ApiOperation(value = "Create a new consumable type")
    @PostMapping("/async/consumableType")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> createConsumableType(
            @Valid @RequestBody ConsumableTypeDTOCreate entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return consumableTypeAPIMethod.createAsync(entity);
    }

    @ApiOperation(value = "Update a consumable type")
    @PutMapping("/async/consumableType")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> updateConsumableType(
            @Valid @RequestBody MetadataDTOUpdate<ConsumableType> entity,
            Errors error) {
        if (error.hasErrors())
            return CompletableFuture.completedFuture(new ResponseEntity<>(new APIResponse<>(new APIResponseHeader(APIResponseStatus.INVALID_PARAMETER, error.toString()), null), HttpStatus.BAD_REQUEST));
        return consumableTypeAPIMethod.updateAsync(entity);
    }

    @ApiOperation(value = "Delete a consumable type by ID")
    @DeleteMapping("/async/consumableType/{id}")
    public CompletableFuture<ResponseEntity<APIResponse<String>>> deleteConsumableTypeByID(
            @PathVariable("id") String id) {
        return consumableTypeAPIMethod.deleteAsync(id);
    }
}
