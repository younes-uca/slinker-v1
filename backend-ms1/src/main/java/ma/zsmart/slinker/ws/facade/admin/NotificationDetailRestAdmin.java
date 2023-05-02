package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.NotificationDetail;
import ma.zsmart.slinker.bean.history.NotificationDetailHistory;
import ma.zsmart.slinker.dao.criteria.core.NotificationDetailCriteria;
import ma.zsmart.slinker.dao.criteria.history.NotificationDetailHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.NotificationDetailAdminService;
import ma.zsmart.slinker.ws.converter.NotificationDetailConverter;
import ma.zsmart.slinker.ws.dto.NotificationDetailDto;
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

@Api("Manages notificationDetail services")
@RestController
@RequestMapping("/api/admin/notificationDetail/")
public class NotificationDetailRestAdmin  extends AbstractController<NotificationDetail, NotificationDetailDto, NotificationDetailHistory, NotificationDetailCriteria, NotificationDetailHistoryCriteria, NotificationDetailAdminService, NotificationDetailConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all notificationDetails")
    @GetMapping("")
    public ResponseEntity<List<NotificationDetailDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a notificationDetail by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NotificationDetailDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  notificationDetail")
    @PostMapping("")
    public ResponseEntity<NotificationDetailDto> save(@RequestBody NotificationDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  notificationDetail")
    @PutMapping("")
    public ResponseEntity<NotificationDetailDto> update(@RequestBody NotificationDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of notificationDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<NotificationDetailDto>> delete(@RequestBody List<NotificationDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified notificationDetail")
    @DeleteMapping("")
    public ResponseEntity<NotificationDetailDto> delete(@RequestBody NotificationDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified notificationDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple notificationDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<NotificationDetail> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by notification id")
    @GetMapping("notification/id/{id}")
    public List<NotificationDetail> findByNotificationId(@PathVariable Long id){
        return service.findByNotificationId(id);
    }
    @ApiOperation("delete by notification id")
    @DeleteMapping("notification/id/{id}")
    public int deleteByNotificationId(@PathVariable Long id){
        return service.deleteByNotificationId(id);
    }
    @ApiOperation("Finds notificationDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NotificationDetailDto>> findByCriteria(@RequestBody NotificationDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated notificationDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NotificationDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports notificationDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NotificationDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets notificationDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NotificationDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets notificationDetail history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets notificationDetail paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody NotificationDetailHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports notificationDetail history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody NotificationDetailHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets notificationDetail history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody NotificationDetailHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public NotificationDetailRestAdmin (NotificationDetailAdminService service, NotificationDetailConverter converter) {
        super(service, converter);
    }


}