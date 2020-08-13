package edu.miu.controller;

import edu.miu.domain.Employee;
import edu.miu.domain.Requisition;
import edu.miu.service.EmployeeService;
import edu.miu.service.RequisitionService;
import edu.miu.util.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RequisitionController {
    @Autowired
    private RequisitionService requisitionService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("employees/{id}/requisitions")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createRequisition(@PathVariable("id") Long id, @Valid @RequestBody Requisition requisition){
        Employee emp = employeeService.findById(id);
        requisition.setEmployee(emp);
        requisitionService.createRequisition(requisition);
        UtilityClass.sendingNotification(requisition);
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
