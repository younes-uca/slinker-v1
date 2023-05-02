package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.Article;
import ma.zsmart.slinker.bean.history.ArticleHistory;
import ma.zsmart.slinker.dao.criteria.core.ArticleCriteria;
import ma.zsmart.slinker.dao.criteria.history.ArticleHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.ArticleAdminService;
import ma.zsmart.slinker.ws.converter.ArticleConverter;
import ma.zsmart.slinker.ws.dto.ArticleDto;
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

@Api("Manages article services")
@RestController
@RequestMapping("/api/admin/article/")
public class ArticleRestAdmin  extends AbstractController<Article, ArticleDto, ArticleHistory, ArticleCriteria, ArticleHistoryCriteria, ArticleAdminService, ArticleConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all articles")
    @GetMapping("")
    public ResponseEntity<List<ArticleDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a article by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ArticleDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  article")
    @PostMapping("")
    public ResponseEntity<ArticleDto> save(@RequestBody ArticleDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  article")
    @PutMapping("")
    public ResponseEntity<ArticleDto> update(@RequestBody ArticleDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of article")
    @PostMapping("multiple")
    public ResponseEntity<List<ArticleDto>> delete(@RequestBody List<ArticleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified article")
    @DeleteMapping("")
    public ResponseEntity<ArticleDto> delete(@RequestBody ArticleDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified article")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple articles by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds a article and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ArticleDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds articles by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ArticleDto>> findByCriteria(@RequestBody ArticleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated articles by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ArticleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports articles by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ArticleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets article data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ArticleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets article history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets article paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ArticleHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports article history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ArticleHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets article history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ArticleHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ArticleRestAdmin (ArticleAdminService service, ArticleConverter converter) {
        super(service, converter);
    }


}