package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.ScrappingOperation;
import ma.zsmart.slinker.bean.history.ScrappingOperationHistory;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.ScrappingOperationAdminService;
import ma.zsmart.slinker.ws.converter.ScrappingOperationConverter;
import ma.zsmart.slinker.ws.dto.ScrappingOperationDto;
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

@Api("Manages scrappingOperation services")
@RestController
@RequestMapping("/api/admin/scrappingOperation/")
public class ScrappingOperationRestAdmin  extends AbstractController<ScrappingOperation, ScrappingOperationDto, ScrappingOperationHistory, ScrappingOperationCriteria, ScrappingOperationHistoryCriteria, ScrappingOperationAdminService, ScrappingOperationConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all scrappingOperations")
    @GetMapping("")
    public ResponseEntity<List<ScrappingOperationDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a scrappingOperation by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ScrappingOperationDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  scrappingOperation")
    @PostMapping("")
    public ResponseEntity<ScrappingOperationDto> save(@RequestBody ScrappingOperationDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  scrappingOperation")
    @PutMapping("")
    public ResponseEntity<ScrappingOperationDto> update(@RequestBody ScrappingOperationDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of scrappingOperation")
    @PostMapping("multiple")
    public ResponseEntity<List<ScrappingOperationDto>> delete(@RequestBody List<ScrappingOperationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified scrappingOperation")
    @DeleteMapping("")
    public ResponseEntity<ScrappingOperationDto> delete(@RequestBody ScrappingOperationDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified scrappingOperation")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple scrappingOperations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by affliate id")
    @GetMapping("affliate/id/{id}")
    public List<ScrappingOperation> findByAffliateId(@PathVariable Long id){
        return service.findByAffliateId(id);
    }
    @ApiOperation("delete by affliate id")
    @DeleteMapping("affliate/id/{id}")
    public int deleteByAffliateId(@PathVariable Long id){
        return service.deleteByAffliateId(id);
    }
    @ApiOperation("find by webSite id")
    @GetMapping("webSite/id/{id}")
    public List<ScrappingOperation> findByWebSiteId(@PathVariable Long id){
        return service.findByWebSiteId(id);
    }
    @ApiOperation("delete by webSite id")
    @DeleteMapping("webSite/id/{id}")
    public int deleteByWebSiteId(@PathVariable Long id){
        return service.deleteByWebSiteId(id);
    }
    @ApiOperation("Finds a scrappingOperation and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ScrappingOperationDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds scrappingOperations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ScrappingOperationDto>> findByCriteria(@RequestBody ScrappingOperationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated scrappingOperations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ScrappingOperationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports scrappingOperations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ScrappingOperationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets scrappingOperation data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ScrappingOperationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets scrappingOperation history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets scrappingOperation paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ScrappingOperationHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports scrappingOperation history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ScrappingOperationHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets scrappingOperation history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ScrappingOperationHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ScrappingOperationRestAdmin (ScrappingOperationAdminService service, ScrappingOperationConverter converter) {
        super(service, converter);
    }


}