package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.StatutClient;
import ma.zsmart.slinker.bean.history.StatutClientHistory;
import ma.zsmart.slinker.dao.criteria.core.StatutClientCriteria;
import ma.zsmart.slinker.dao.criteria.history.StatutClientHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.StatutClientAdminService;
import ma.zsmart.slinker.ws.converter.StatutClientConverter;
import ma.zsmart.slinker.ws.dto.StatutClientDto;
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

@Api("Manages statutClient services")
@RestController
@RequestMapping("/api/admin/statutClient/")
public class StatutClientRestAdmin  extends AbstractController<StatutClient, StatutClientDto, StatutClientHistory, StatutClientCriteria, StatutClientHistoryCriteria, StatutClientAdminService, StatutClientConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all statutClients")
    @GetMapping("")
    public ResponseEntity<List<StatutClientDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all statutClients")
    @GetMapping("optimized")
    public ResponseEntity<List<StatutClientDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a statutClient by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StatutClientDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  statutClient")
    @PostMapping("")
    public ResponseEntity<StatutClientDto> save(@RequestBody StatutClientDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  statutClient")
    @PutMapping("")
    public ResponseEntity<StatutClientDto> update(@RequestBody StatutClientDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of statutClient")
    @PostMapping("multiple")
    public ResponseEntity<List<StatutClientDto>> delete(@RequestBody List<StatutClientDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified statutClient")
    @DeleteMapping("")
    public ResponseEntity<StatutClientDto> delete(@RequestBody StatutClientDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified statutClient")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple statutClients by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds statutClients by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StatutClientDto>> findByCriteria(@RequestBody StatutClientCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated statutClients by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StatutClientCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statutClients by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StatutClientCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets statutClient data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StatutClientCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets statutClient history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets statutClient paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody StatutClientHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports statutClient history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody StatutClientHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets statutClient history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody StatutClientHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public StatutClientRestAdmin (StatutClientAdminService service, StatutClientConverter converter) {
        super(service, converter);
    }


}