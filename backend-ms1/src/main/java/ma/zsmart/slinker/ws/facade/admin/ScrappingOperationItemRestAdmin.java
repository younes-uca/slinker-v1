package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.ScrappingOperationItem;
import ma.zsmart.slinker.bean.history.ScrappingOperationItemHistory;
import ma.zsmart.slinker.dao.criteria.core.ScrappingOperationItemCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingOperationItemHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.ScrappingOperationItemAdminService;
import ma.zsmart.slinker.ws.converter.ScrappingOperationItemConverter;
import ma.zsmart.slinker.ws.dto.ScrappingOperationItemDto;
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

@Api("Manages scrappingOperationItem services")
@RestController
@RequestMapping("/api/admin/scrappingOperationItem/")
public class ScrappingOperationItemRestAdmin  extends AbstractController<ScrappingOperationItem, ScrappingOperationItemDto, ScrappingOperationItemHistory, ScrappingOperationItemCriteria, ScrappingOperationItemHistoryCriteria, ScrappingOperationItemAdminService, ScrappingOperationItemConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all scrappingOperationItems")
    @GetMapping("")
    public ResponseEntity<List<ScrappingOperationItemDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a scrappingOperationItem by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ScrappingOperationItemDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  scrappingOperationItem")
    @PostMapping("")
    public ResponseEntity<ScrappingOperationItemDto> save(@RequestBody ScrappingOperationItemDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  scrappingOperationItem")
    @PutMapping("")
    public ResponseEntity<ScrappingOperationItemDto> update(@RequestBody ScrappingOperationItemDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of scrappingOperationItem")
    @PostMapping("multiple")
    public ResponseEntity<List<ScrappingOperationItemDto>> delete(@RequestBody List<ScrappingOperationItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified scrappingOperationItem")
    @DeleteMapping("")
    public ResponseEntity<ScrappingOperationItemDto> delete(@RequestBody ScrappingOperationItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified scrappingOperationItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple scrappingOperationItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by scrappingLink id")
    @GetMapping("scrappingLink/id/{id}")
    public List<ScrappingOperationItem> findByScrappingLinkId(@PathVariable Long id){
        return service.findByScrappingLinkId(id);
    }
    @ApiOperation("delete by scrappingLink id")
    @DeleteMapping("scrappingLink/id/{id}")
    public int deleteByScrappingLinkId(@PathVariable Long id){
        return service.deleteByScrappingLinkId(id);
    }
    @ApiOperation("find by typeProduit id")
    @GetMapping("typeProduit/id/{id}")
    public List<ScrappingOperationItem> findByTypeProduitId(@PathVariable Long id){
        return service.findByTypeProduitId(id);
    }
    @ApiOperation("delete by typeProduit id")
    @DeleteMapping("typeProduit/id/{id}")
    public int deleteByTypeProduitId(@PathVariable Long id){
        return service.deleteByTypeProduitId(id);
    }
    @ApiOperation("find by scrappingOperation id")
    @GetMapping("scrappingOperation/id/{id}")
    public List<ScrappingOperationItem> findByScrappingOperationId(@PathVariable Long id){
        return service.findByScrappingOperationId(id);
    }
    @ApiOperation("delete by scrappingOperation id")
    @DeleteMapping("scrappingOperation/id/{id}")
    public int deleteByScrappingOperationId(@PathVariable Long id){
        return service.deleteByScrappingOperationId(id);
    }
    @ApiOperation("Finds scrappingOperationItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ScrappingOperationItemDto>> findByCriteria(@RequestBody ScrappingOperationItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated scrappingOperationItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ScrappingOperationItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports scrappingOperationItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ScrappingOperationItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets scrappingOperationItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ScrappingOperationItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets scrappingOperationItem history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets scrappingOperationItem paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ScrappingOperationItemHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports scrappingOperationItem history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ScrappingOperationItemHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets scrappingOperationItem history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ScrappingOperationItemHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ScrappingOperationItemRestAdmin (ScrappingOperationItemAdminService service, ScrappingOperationItemConverter converter) {
        super(service, converter);
    }


}