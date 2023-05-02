package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.Affliate;
import ma.zsmart.slinker.bean.history.AffliateHistory;
import ma.zsmart.slinker.dao.criteria.core.AffliateCriteria;
import ma.zsmart.slinker.dao.criteria.history.AffliateHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.AffliateAdminService;
import ma.zsmart.slinker.ws.converter.AffliateConverter;
import ma.zsmart.slinker.ws.dto.AffliateDto;
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

@Api("Manages affliate services")
@RestController
@RequestMapping("/api/admin/affliate/")
public class AffliateRestAdmin  extends AbstractController<Affliate, AffliateDto, AffliateHistory, AffliateCriteria, AffliateHistoryCriteria, AffliateAdminService, AffliateConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all affliates")
    @GetMapping("")
    public ResponseEntity<List<AffliateDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all affliates")
    @GetMapping("optimized")
    public ResponseEntity<List<AffliateDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a affliate by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AffliateDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  affliate")
    @PostMapping("")
    public ResponseEntity<AffliateDto> save(@RequestBody AffliateDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  affliate")
    @PutMapping("")
    public ResponseEntity<AffliateDto> update(@RequestBody AffliateDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of affliate")
    @PostMapping("multiple")
    public ResponseEntity<List<AffliateDto>> delete(@RequestBody List<AffliateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified affliate")
    @DeleteMapping("")
    public ResponseEntity<AffliateDto> delete(@RequestBody AffliateDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified affliate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple affliates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Affliate> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("Finds affliates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AffliateDto>> findByCriteria(@RequestBody AffliateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated affliates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AffliateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports affliates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AffliateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets affliate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AffliateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets affliate history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets affliate paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody AffliateHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports affliate history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody AffliateHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets affliate history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody AffliateHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public AffliateRestAdmin (AffliateAdminService service, AffliateConverter converter) {
        super(service, converter);
    }


}