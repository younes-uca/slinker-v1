package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.Commentaire;
import ma.zsmart.slinker.bean.history.CommentaireHistory;
import ma.zsmart.slinker.dao.criteria.core.CommentaireCriteria;
import ma.zsmart.slinker.dao.criteria.history.CommentaireHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.CommentaireAdminService;
import ma.zsmart.slinker.ws.converter.CommentaireConverter;
import ma.zsmart.slinker.ws.dto.CommentaireDto;
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

@Api("Manages commentaire services")
@RestController
@RequestMapping("/api/admin/commentaire/")
public class CommentaireRestAdmin  extends AbstractController<Commentaire, CommentaireDto, CommentaireHistory, CommentaireCriteria, CommentaireHistoryCriteria, CommentaireAdminService, CommentaireConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all commentaires")
    @GetMapping("")
    public ResponseEntity<List<CommentaireDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a commentaire by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CommentaireDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  commentaire")
    @PostMapping("")
    public ResponseEntity<CommentaireDto> save(@RequestBody CommentaireDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  commentaire")
    @PutMapping("")
    public ResponseEntity<CommentaireDto> update(@RequestBody CommentaireDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of commentaire")
    @PostMapping("multiple")
    public ResponseEntity<List<CommentaireDto>> delete(@RequestBody List<CommentaireDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified commentaire")
    @DeleteMapping("")
    public ResponseEntity<CommentaireDto> delete(@RequestBody CommentaireDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified commentaire")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple commentaires by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by article id")
    @GetMapping("article/id/{id}")
    public List<Commentaire> findByArticleId(@PathVariable Long id){
        return service.findByArticleId(id);
    }
    @ApiOperation("delete by article id")
    @DeleteMapping("article/id/{id}")
    public int deleteByArticleId(@PathVariable Long id){
        return service.deleteByArticleId(id);
    }
    @ApiOperation("Finds commentaires by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CommentaireDto>> findByCriteria(@RequestBody CommentaireCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated commentaires by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CommentaireCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports commentaires by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CommentaireCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets commentaire data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CommentaireCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets commentaire history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets commentaire paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody CommentaireHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports commentaire history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody CommentaireHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets commentaire history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody CommentaireHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public CommentaireRestAdmin (CommentaireAdminService service, CommentaireConverter converter) {
        super(service, converter);
    }


}