package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.WebSite;
import ma.zsmart.slinker.bean.history.WebSiteHistory;
import ma.zsmart.slinker.dao.criteria.core.WebSiteCriteria;
import ma.zsmart.slinker.dao.criteria.history.WebSiteHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.WebSiteAdminService;
import ma.zsmart.slinker.ws.converter.WebSiteConverter;
import ma.zsmart.slinker.ws.dto.WebSiteDto;
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

@Api("Manages webSite services")
@RestController
@RequestMapping("/api/admin/webSite/")
public class WebSiteRestAdmin  extends AbstractController<WebSite, WebSiteDto, WebSiteHistory, WebSiteCriteria, WebSiteHistoryCriteria, WebSiteAdminService, WebSiteConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all webSites")
    @GetMapping("")
    public ResponseEntity<List<WebSiteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all webSites")
    @GetMapping("optimized")
    public ResponseEntity<List<WebSiteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a webSite by id")
    @GetMapping("id/{id}")
    public ResponseEntity<WebSiteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  webSite")
    @PostMapping("")
    public ResponseEntity<WebSiteDto> save(@RequestBody WebSiteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  webSite")
    @PutMapping("")
    public ResponseEntity<WebSiteDto> update(@RequestBody WebSiteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of webSite")
    @PostMapping("multiple")
    public ResponseEntity<List<WebSiteDto>> delete(@RequestBody List<WebSiteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified webSite")
    @DeleteMapping("")
    public ResponseEntity<WebSiteDto> delete(@RequestBody WebSiteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified webSite")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple webSites by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by statutWebSite id")
    @GetMapping("statutWebSite/id/{id}")
    public List<WebSite> findByStatutWebSiteId(@PathVariable Long id){
        return service.findByStatutWebSiteId(id);
    }
    @ApiOperation("delete by statutWebSite id")
    @DeleteMapping("statutWebSite/id/{id}")
    public int deleteByStatutWebSiteId(@PathVariable Long id){
        return service.deleteByStatutWebSiteId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<WebSite> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("Finds a webSite and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<WebSiteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds webSites by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<WebSiteDto>> findByCriteria(@RequestBody WebSiteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated webSites by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody WebSiteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports webSites by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody WebSiteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets webSite data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody WebSiteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets webSite history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets webSite paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody WebSiteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports webSite history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody WebSiteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets webSite history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody WebSiteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public WebSiteRestAdmin (WebSiteAdminService service, WebSiteConverter converter) {
        super(service, converter);
    }


}