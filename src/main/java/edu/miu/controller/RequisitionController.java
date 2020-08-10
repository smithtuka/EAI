package edu.miu.controller;

import edu.miu.domain.Requisition;
import edu.miu.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/requisitions")
public class RequisitionController {
    @Autowired
    private RequisitionService requisitionService;

    @PostMapping("/add")
    public String createRequisition(@Valid @RequestBody Requisition requisition){
        return requisitionService.createRequisition(requisition).getId() +" added successfully";
    }

    @GetMapping("/{id}")
    public Requisition getRequisition(@PathVariable("id") Long id){
        // error handling - bindingResult or @ControllerService
        return requisitionService.getRequisition(id);
    }

    @GetMapping("")
    public List<Requisition> getRequisitions(){
        return requisitionService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Requisition updateRequisition(@Valid @PathVariable("id") Long id, @RequestBody Requisition requisition ){
        return requisitionService.updateRequisition(requisition, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRequisition(@PathVariable("id") Long id){
        requisitionService.deleteRequisition(id);
    }


}
