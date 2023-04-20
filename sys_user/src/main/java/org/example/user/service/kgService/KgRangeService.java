package org.example.user.service.kgService;
/*
author : Kigooo
verson : 0.0.3
update date : 2022-02-14
*/

import org.example.user.component.kgResponseJson.KgResponseJson;
import org.example.user.kgDomain.KgRange;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KgRangeService {
    KgResponseJson createRange(KgRange kgRange);
    KgResponseJson deleteRange(List<String> rangeOIDList);
    KgResponseJson updateRange(KgRange kgRange);
    KgResponseJson updateRangeStatus(String rangeOID,int status);
    KgResponseJson getRangeList(int page,int pageSize,String condition,String dataMode,String rangeID);
    KgResponseJson getRangeListByRangeId(String rangeId,String sortBy);
    KgResponseJson getRangeListNotByRoleOID(int page,int pageSize,String condition,String roleOID);
    KgResponseJson getRangeIds();
    KgResponseJson getRangeIdsByDataMode(String dataMode);
    KgResponseJson getRangeDataModes();
    ResponseEntity exportRangeList(String condition,String dataMode,String rangeID);
}