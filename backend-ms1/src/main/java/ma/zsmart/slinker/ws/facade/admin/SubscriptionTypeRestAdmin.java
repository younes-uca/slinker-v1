package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.SubscriptionType;
import ma.zsmart.slinker.bean.history.SubscriptionTypeHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionTypeCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionTypeHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.SubscriptionTypeAdminService;
import ma.zsmart.slinker.ws.converter.SubscriptionTypeConverter;
import ma.zsmart.slinker.ws.dto.SubscriptionTypeDto;
import ma.zsmart.slinker.zynerator.controller.AbstractController;
import ma.zsmart.slinker.zynerator.dto.AuditEntityDto;
import ma.zsmart.slinker.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zsmart.slinker.zynerator.process.Result;

import org.springframework.web.multipart.MultipartFile;
import ma.zsmart.slinker.zynerator.dto.FileTempDto;

@Api("Manages subscriptionType services")
@RestController
@RequestMapping("/api/admin/subscriptionType/")
public class SubscriptionTypeRestAdmin  extends AbstractController<SubscriptionType, SubscriptionTypeDto, SubscriptionTypeHistory, SubscriptionTypeCriteria, SubscriptionTypeHistoryCriteria, SubscriptionTypeAdminService, SubscriptionTypeConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all subscriptionTypes")
    @GetMapping("")
    public ResponseEntity<List<SubscriptionTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all subscriptionTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<SubscriptionTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a subscriptionType by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubscriptionTypeDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  subscriptionType")
    @PostMapping("")
    public ResponseEntity<SubscriptionTypeDto> save(@RequestBody SubscriptionTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  subscriptionType")
    @PutMapping("")
    public ResponseEntity<SubscriptionTypeDto> update(@RequestBody SubscriptionTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of subscriptionType")
    @PostMapping("multiple")
    public ResponseEntity<List<SubscriptionTypeDto>> delete(@RequestBody List<SubscriptionTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified subscriptionType")
    @DeleteMapping("")
    public ResponseEntity<SubscriptionTypeDto> delete(@RequestBody SubscriptionTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified subscriptionType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple subscriptionTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds subscriptionTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubscriptionTypeDto>> findByCriteria(@RequestBody SubscriptionTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated subscriptionTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubscriptionTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptionTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubscriptionTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets subscriptionType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubscriptionTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets subscriptionType history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets subscriptionType paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SubscriptionTypeHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptionType history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SubscriptionTypeHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets subscriptionType history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SubscriptionTypeHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SubscriptionTypeRestAdmin (SubscriptionTypeAdminService service, SubscriptionTypeConverter converter) {
        super(service, converter);
    }


}