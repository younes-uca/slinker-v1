package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.ScrappingLink;
import ma.zsmart.slinker.bean.history.ScrappingLinkHistory;
import ma.zsmart.slinker.dao.criteria.core.ScrappingLinkCriteria;
import ma.zsmart.slinker.dao.criteria.history.ScrappingLinkHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.ScrappingLinkAdminService;
import ma.zsmart.slinker.ws.converter.ScrappingLinkConverter;
import ma.zsmart.slinker.ws.dto.ScrappingLinkDto;
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

@Api("Manages scrappingLink services")
@RestController
@RequestMapping("/api/admin/scrappingLink/")
public class ScrappingLinkRestAdmin  extends AbstractController<ScrappingLink, ScrappingLinkDto, ScrappingLinkHistory, ScrappingLinkCriteria, ScrappingLinkHistoryCriteria, ScrappingLinkAdminService, ScrappingLinkConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all scrappingLinks")
    @GetMapping("")
    public ResponseEntity<List<ScrappingLinkDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all scrappingLinks")
    @GetMapping("optimized")
    public ResponseEntity<List<ScrappingLinkDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a scrappingLink by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ScrappingLinkDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  scrappingLink")
    @PostMapping("")
    public ResponseEntity<ScrappingLinkDto> save(@RequestBody ScrappingLinkDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  scrappingLink")
    @PutMapping("")
    public ResponseEntity<ScrappingLinkDto> update(@RequestBody ScrappingLinkDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of scrappingLink")
    @PostMapping("multiple")
    public ResponseEntity<List<ScrappingLinkDto>> delete(@RequestBody List<ScrappingLinkDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified scrappingLink")
    @DeleteMapping("")
    public ResponseEntity<ScrappingLinkDto> delete(@RequestBody ScrappingLinkDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified scrappingLink")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple scrappingLinks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by webSite id")
    @GetMapping("webSite/id/{id}")
    public List<ScrappingLink> findByWebSiteId(@PathVariable Long id){
        return service.findByWebSiteId(id);
    }
    @ApiOperation("delete by webSite id")
    @DeleteMapping("webSite/id/{id}")
    public int deleteByWebSiteId(@PathVariable Long id){
        return service.deleteByWebSiteId(id);
    }
    @ApiOperation("Finds scrappingLinks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ScrappingLinkDto>> findByCriteria(@RequestBody ScrappingLinkCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated scrappingLinks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ScrappingLinkCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports scrappingLinks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ScrappingLinkCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets scrappingLink data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ScrappingLinkCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets scrappingLink history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets scrappingLink paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ScrappingLinkHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports scrappingLink history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ScrappingLinkHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets scrappingLink history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ScrappingLinkHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ScrappingLinkRestAdmin (ScrappingLinkAdminService service, ScrappingLinkConverter converter) {
        super(service, converter);
    }


}