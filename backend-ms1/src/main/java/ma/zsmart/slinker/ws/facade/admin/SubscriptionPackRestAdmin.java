package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.SubscriptionPack;
import ma.zsmart.slinker.bean.history.SubscriptionPackHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionPackCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionPackHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.SubscriptionPackAdminService;
import ma.zsmart.slinker.ws.converter.SubscriptionPackConverter;
import ma.zsmart.slinker.ws.dto.SubscriptionPackDto;
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

@Api("Manages subscriptionPack services")
@RestController
@RequestMapping("/api/admin/subscriptionPack/")
public class SubscriptionPackRestAdmin  extends AbstractController<SubscriptionPack, SubscriptionPackDto, SubscriptionPackHistory, SubscriptionPackCriteria, SubscriptionPackHistoryCriteria, SubscriptionPackAdminService, SubscriptionPackConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all subscriptionPacks")
    @GetMapping("")
    public ResponseEntity<List<SubscriptionPackDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all subscriptionPacks")
    @GetMapping("optimized")
    public ResponseEntity<List<SubscriptionPackDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a subscriptionPack by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubscriptionPackDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  subscriptionPack")
    @PostMapping("")
    public ResponseEntity<SubscriptionPackDto> save(@RequestBody SubscriptionPackDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  subscriptionPack")
    @PutMapping("")
    public ResponseEntity<SubscriptionPackDto> update(@RequestBody SubscriptionPackDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of subscriptionPack")
    @PostMapping("multiple")
    public ResponseEntity<List<SubscriptionPackDto>> delete(@RequestBody List<SubscriptionPackDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified subscriptionPack")
    @DeleteMapping("")
    public ResponseEntity<SubscriptionPackDto> delete(@RequestBody SubscriptionPackDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified subscriptionPack")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple subscriptionPacks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds subscriptionPacks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubscriptionPackDto>> findByCriteria(@RequestBody SubscriptionPackCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated subscriptionPacks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubscriptionPackCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptionPacks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubscriptionPackCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets subscriptionPack data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubscriptionPackCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets subscriptionPack history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets subscriptionPack paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SubscriptionPackHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptionPack history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SubscriptionPackHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets subscriptionPack history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SubscriptionPackHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SubscriptionPackRestAdmin (SubscriptionPackAdminService service, SubscriptionPackConverter converter) {
        super(service, converter);
    }


}