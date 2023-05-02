package  ma.zsmart.slinker.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zsmart.slinker.bean.core.Client;
import ma.zsmart.slinker.bean.history.ClientHistory;
import ma.zsmart.slinker.dao.criteria.core.ClientCriteria;
import ma.zsmart.slinker.dao.criteria.history.ClientHistoryCriteria;
import ma.zsmart.slinker.service.facade.admin.ClientAdminService;
import ma.zsmart.slinker.ws.converter.ClientConverter;
import ma.zsmart.slinker.ws.dto.ClientDto;
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

@Api("Manages client services")
@RestController
@RequestMapping("/api/admin/client/")
public class ClientRestAdmin  extends AbstractController<Client, ClientDto, ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientAdminService, ClientConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all clients")
    @GetMapping("")
    public ResponseEntity<List<ClientDto>> findAll() throws Exception {
        return super.findAll();
    }


    @ApiOperation("Finds a client by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  client")
    @PostMapping("")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  client")
    @PutMapping("")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of client")
    @PostMapping("multiple")
    public ResponseEntity<List<ClientDto>> delete(@RequestBody List<ClientDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified client")
    @DeleteMapping("")
    public ResponseEntity<ClientDto> delete(@RequestBody ClientDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified client")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple clients by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by statutClient id")
    @GetMapping("statutClient/id/{id}")
    public List<Client> findByStatutClientId(@PathVariable Long id){
        return service.findByStatutClientId(id);
    }
    @ApiOperation("delete by statutClient id")
    @DeleteMapping("statutClient/id/{id}")
    public int deleteByStatutClientId(@PathVariable Long id){
        return service.deleteByStatutClientId(id);
    }
    @ApiOperation("Finds a client and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<ClientDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds clients by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClientDto>> findByCriteria(@RequestBody ClientCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated clients by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClientCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports clients by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClientCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets client data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClientCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets client history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets client paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody ClientHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports client history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody ClientHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets client history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody ClientHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public ClientRestAdmin (ClientAdminService service, ClientConverter converter) {
        super(service, converter);
    }


}