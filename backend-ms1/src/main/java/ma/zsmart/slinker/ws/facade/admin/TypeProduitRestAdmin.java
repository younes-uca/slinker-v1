package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.TypeProduit;
import ma.zsmart.slinker.bean.history.TypeProduitHistory;
import ma.zsmart.slinker.dao.criteria.core.TypeProduitCriteria;
import ma.zsmart.slinker.dao.criteria.history.TypeProduitHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.TypeProduitAdminService;
import ma.zsmart.slinker.ws.converter.TypeProduitConverter;
import ma.zsmart.slinker.ws.dto.TypeProduitDto;
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

@Api("Manages typeProduit services")
@RestController
@RequestMapping("/api/admin/typeProduit/")
public class TypeProduitRestAdmin  extends AbstractController<TypeProduit, TypeProduitDto, TypeProduitHistory, TypeProduitCriteria, TypeProduitHistoryCriteria, TypeProduitAdminService, TypeProduitConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all typeProduits")
    @GetMapping("")
    public ResponseEntity<List<TypeProduitDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all typeProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeProduitDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a typeProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  typeProduit")
    @PostMapping("")
    public ResponseEntity<TypeProduitDto> save(@RequestBody TypeProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  typeProduit")
    @PutMapping("")
    public ResponseEntity<TypeProduitDto> update(@RequestBody TypeProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of typeProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeProduitDto>> delete(@RequestBody List<TypeProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified typeProduit")
    @DeleteMapping("")
    public ResponseEntity<TypeProduitDto> delete(@RequestBody TypeProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified typeProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple typeProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds typeProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeProduitDto>> findByCriteria(@RequestBody TypeProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated typeProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets typeProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets typeProduit history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets typeProduit paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody TypeProduitHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports typeProduit history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody TypeProduitHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets typeProduit history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody TypeProduitHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public TypeProduitRestAdmin (TypeProduitAdminService service, TypeProduitConverter converter) {
        super(service, converter);
    }


}