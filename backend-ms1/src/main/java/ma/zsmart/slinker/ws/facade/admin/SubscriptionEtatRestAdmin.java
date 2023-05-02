package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.SubscriptionEtat;
import ma.zsmart.slinker.bean.history.SubscriptionEtatHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionEtatCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionEtatHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.SubscriptionEtatAdminService;
import ma.zsmart.slinker.ws.converter.SubscriptionEtatConverter;
import ma.zsmart.slinker.ws.dto.SubscriptionEtatDto;
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

@Api("Manages subscriptionEtat services")
@RestController
@RequestMapping("/api/admin/subscriptionEtat/")
public class SubscriptionEtatRestAdmin  extends AbstractController<SubscriptionEtat, SubscriptionEtatDto, SubscriptionEtatHistory, SubscriptionEtatCriteria, SubscriptionEtatHistoryCriteria, SubscriptionEtatAdminService, SubscriptionEtatConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all subscriptionEtats")
    @GetMapping("")
    public ResponseEntity<List<SubscriptionEtatDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all subscriptionEtats")
    @GetMapping("optimized")
    public ResponseEntity<List<SubscriptionEtatDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a subscriptionEtat by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubscriptionEtatDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  subscriptionEtat")
    @PostMapping("")
    public ResponseEntity<SubscriptionEtatDto> save(@RequestBody SubscriptionEtatDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  subscriptionEtat")
    @PutMapping("")
    public ResponseEntity<SubscriptionEtatDto> update(@RequestBody SubscriptionEtatDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of subscriptionEtat")
    @PostMapping("multiple")
    public ResponseEntity<List<SubscriptionEtatDto>> delete(@RequestBody List<SubscriptionEtatDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified subscriptionEtat")
    @DeleteMapping("")
    public ResponseEntity<SubscriptionEtatDto> delete(@RequestBody SubscriptionEtatDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified subscriptionEtat")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple subscriptionEtats by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds subscriptionEtats by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubscriptionEtatDto>> findByCriteria(@RequestBody SubscriptionEtatCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated subscriptionEtats by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubscriptionEtatCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptionEtats by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubscriptionEtatCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets subscriptionEtat data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubscriptionEtatCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets subscriptionEtat history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets subscriptionEtat paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SubscriptionEtatHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptionEtat history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SubscriptionEtatHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets subscriptionEtat history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SubscriptionEtatHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SubscriptionEtatRestAdmin (SubscriptionEtatAdminService service, SubscriptionEtatConverter converter) {
        super(service, converter);
    }


}