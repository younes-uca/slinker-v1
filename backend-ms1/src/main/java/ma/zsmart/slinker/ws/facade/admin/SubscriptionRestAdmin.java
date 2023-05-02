package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.Subscription;
import ma.zsmart.slinker.bean.history.SubscriptionHistory;
import ma.zsmart.slinker.dao.criteria.core.SubscriptionCriteria;
import ma.zsmart.slinker.dao.criteria.history.SubscriptionHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.SubscriptionAdminService;
import ma.zsmart.slinker.ws.converter.SubscriptionConverter;
import ma.zsmart.slinker.ws.dto.SubscriptionDto;
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

@Api("Manages subscription services")
@RestController
@RequestMapping("/api/admin/subscription/")
public class SubscriptionRestAdmin  extends AbstractController<Subscription, SubscriptionDto, SubscriptionHistory, SubscriptionCriteria, SubscriptionHistoryCriteria, SubscriptionAdminService, SubscriptionConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all subscriptions")
    @GetMapping("")
    public ResponseEntity<List<SubscriptionDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a subscription by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SubscriptionDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  subscription")
    @PostMapping("")
    public ResponseEntity<SubscriptionDto> save(@RequestBody SubscriptionDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  subscription")
    @PutMapping("")
    public ResponseEntity<SubscriptionDto> update(@RequestBody SubscriptionDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of subscription")
    @PostMapping("multiple")
    public ResponseEntity<List<SubscriptionDto>> delete(@RequestBody List<SubscriptionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified subscription")
    @DeleteMapping("")
    public ResponseEntity<SubscriptionDto> delete(@RequestBody SubscriptionDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified subscription")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple subscriptions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by subscriptionType id")
    @GetMapping("subscriptionType/id/{id}")
    public List<Subscription> findBySubscriptionTypeId(@PathVariable Long id){
        return service.findBySubscriptionTypeId(id);
    }
    @ApiOperation("delete by subscriptionType id")
    @DeleteMapping("subscriptionType/id/{id}")
    public int deleteBySubscriptionTypeId(@PathVariable Long id){
        return service.deleteBySubscriptionTypeId(id);
    }
    @ApiOperation("find by subscriptionPack id")
    @GetMapping("subscriptionPack/id/{id}")
    public List<Subscription> findBySubscriptionPackId(@PathVariable Long id){
        return service.findBySubscriptionPackId(id);
    }
    @ApiOperation("delete by subscriptionPack id")
    @DeleteMapping("subscriptionPack/id/{id}")
    public int deleteBySubscriptionPackId(@PathVariable Long id){
        return service.deleteBySubscriptionPackId(id);
    }
    @ApiOperation("find by subscriptionEtat id")
    @GetMapping("subscriptionEtat/id/{id}")
    public List<Subscription> findBySubscriptionEtatId(@PathVariable Long id){
        return service.findBySubscriptionEtatId(id);
    }
    @ApiOperation("delete by subscriptionEtat id")
    @DeleteMapping("subscriptionEtat/id/{id}")
    public int deleteBySubscriptionEtatId(@PathVariable Long id){
        return service.deleteBySubscriptionEtatId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Subscription> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("find by typePaiement id")
    @GetMapping("typePaiement/id/{id}")
    public List<Subscription> findByTypePaiementId(@PathVariable Long id){
        return service.findByTypePaiementId(id);
    }
    @ApiOperation("delete by typePaiement id")
    @DeleteMapping("typePaiement/id/{id}")
    public int deleteByTypePaiementId(@PathVariable Long id){
        return service.deleteByTypePaiementId(id);
    }
    @ApiOperation("Finds subscriptions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SubscriptionDto>> findByCriteria(@RequestBody SubscriptionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated subscriptions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SubscriptionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscriptions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SubscriptionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets subscription data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SubscriptionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets subscription history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets subscription paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody SubscriptionHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports subscription history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody SubscriptionHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets subscription history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody SubscriptionHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public SubscriptionRestAdmin (SubscriptionAdminService service, SubscriptionConverter converter) {
        super(service, converter);
    }


}