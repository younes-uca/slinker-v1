package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.StatutNotification;
import ma.zsmart.slinker.bean.history.StatutNotificationHistory;
import ma.zsmart.slinker.dao.criteria.core.StatutNotificationCriteria;
import ma.zsmart.slinker.dao.criteria.history.StatutNotificationHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.StatutNotificationAdminService;
import ma.zsmart.slinker.ws.converter.StatutNotificationConverter;
import ma.zsmart.slinker.ws.dto.StatutNotificationDto;
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

@Api("Manages statutNotification services")
@RestController
@RequestMapping("/api/admin/statutNotification/")
public class StatutNotificationRestAdmin  extends AbstractController<StatutNotification, StatutNotificationDto, StatutNotificationHistory, StatutNotificationCriteria, StatutNotificationHistoryCriteria, StatutNotificationAdminService, StatutNotificationConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all statutNotifications")
    @GetMapping("")
    public ResponseEntity<List<StatutNotificationDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all statutNotifications")
    @GetMapping("optimized")
    public ResponseEntity<List<StatutNotificationDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a statutNotification by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StatutNotificationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  statutNotification")
    @PostMapping("")
    public ResponseEntity<StatutNotificationDto> save(@RequestBody StatutNotificationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  statutNotification")
    @PutMapping("")
    public ResponseEntity<StatutNotificationDto> update(@RequestBody StatutNotificationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of statutNotification")
    @PostMapping("multiple")
    public ResponseEntity<List<StatutNotificationDto>> delete(@RequestBody List<StatutNotificationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified statutNotification")
    @DeleteMapping("")
    public ResponseEntity<StatutNotificationDto> delete(@RequestBody StatutNotificationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified statutNotification")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple statutNotifications by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds statutNotifications by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StatutNotificationDto>> findByCriteria(@RequestBody StatutNotificationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated statutNotifications by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StatutNotificationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statutNotifications by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StatutNotificationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets statutNotification data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StatutNotificationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets statutNotification history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets statutNotification paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StatutNotificationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statutNotification history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StatutNotificationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets statutNotification history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StatutNotificationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StatutNotificationRestAdmin (StatutNotificationAdminService service, StatutNotificationConverter converter) {
        super(service, converter);
    }


}