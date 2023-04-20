package org.example.user.service.kgService;
/*
author : Kigooo
verson : 0.0.3
update date : 2022-02-14
*/

import org.example.user.component.kgResponseJson.KgResponseJson;
import org.example.user.kgDomain.KgRole;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
public interface KgRoleService {
    KgResponseJson createRole(String name, String description, List<String> menuOIDList, List<String> operateOIDList, List<String>userOIDList);
    KgResponseJson deleteRole(String roleOID);
    KgResponseJson updateRole(KgRole kgRole,List<String> commandOIDList,List<String> operateOIDList);
    KgResponseJson updateRoleStatus(String roleOID,int status);
    KgResponseJson getRoleDetail(String roleOID);
    List<String> getRoleOIDs(@Valid @Positive int status);
    List<String> getRoleOIDsInRealByApiOID(@Valid @NotBlank String apiOID,@Valid @Positive int status);
    KgResponseJson getRoleList(int page,int pageSize,String condition,int init);
    List<KgRole> getRoleListByUserOID(@Valid @NotBlank String userOID);
    List<KgRole> getRoleListByCommandOIDs(@Valid @NotEmpty List<String> commandOIDList);
    List<KgRole> getRoleListByOperateOIDs(@Valid @NotEmpty List<String> operateOIDList);
    List<KgRole> getRoleListByApi(@Valid @NotBlank String api);
    Boolean checkRoleExist(String oid,int init);
    ResponseEntity exportRoleList(String condition);
}
