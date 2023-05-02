package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.StatutWebSite;
import ma.zsmart.slinker.bean.history.StatutWebSiteHistory;
import ma.zsmart.slinker.dao.criteria.core.StatutWebSiteCriteria;
import ma.zsmart.slinker.dao.criteria.history.StatutWebSiteHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.StatutWebSiteAdminService;
import ma.zsmart.slinker.ws.converter.StatutWebSiteConverter;
import ma.zsmart.slinker.ws.dto.StatutWebSiteDto;
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

@Api("Manages statutWebSite services")
@RestController
@RequestMapping("/api/admin/statutWebSite/")
public class StatutWebSiteRestAdmin  extends AbstractController<StatutWebSite, StatutWebSiteDto, StatutWebSiteHistory, StatutWebSiteCriteria, StatutWebSiteHistoryCriteria, StatutWebSiteAdminService, StatutWebSiteConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all statutWebSites")
    @GetMapping("")
    public ResponseEntity<List<StatutWebSiteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all statutWebSites")
    @GetMapping("optimized")
    public ResponseEntity<List<StatutWebSiteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a statutWebSite by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StatutWebSiteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  statutWebSite")
    @PostMapping("")
    public ResponseEntity<StatutWebSiteDto> save(@RequestBody StatutWebSiteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  statutWebSite")
    @PutMapping("")
    public ResponseEntity<StatutWebSiteDto> update(@RequestBody StatutWebSiteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of statutWebSite")
    @PostMapping("multiple")
    public ResponseEntity<List<StatutWebSiteDto>> delete(@RequestBody List<StatutWebSiteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified statutWebSite")
    @DeleteMapping("")
    public ResponseEntity<StatutWebSiteDto> delete(@RequestBody StatutWebSiteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified statutWebSite")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple statutWebSites by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds statutWebSites by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StatutWebSiteDto>> findByCriteria(@RequestBody StatutWebSiteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated statutWebSites by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StatutWebSiteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statutWebSites by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StatutWebSiteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets statutWebSite data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StatutWebSiteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets statutWebSite history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets statutWebSite paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StatutWebSiteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statutWebSite history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StatutWebSiteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets statutWebSite history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StatutWebSiteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StatutWebSiteRestAdmin (StatutWebSiteAdminService service, StatutWebSiteConverter converter) {
        super(service, converter);
    }


}