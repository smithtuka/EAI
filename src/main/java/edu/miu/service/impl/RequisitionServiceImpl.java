package edu.miu.service.impl;


import edu.miu.aspect.exception.NoDataFoundException;
import edu.miu.aspect.exception.RequisitionNotFoundException;
import edu.miu.dao.RequisitionDao;
import edu.miu.domain.Requisition;
import edu.miu.service.RequisitionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {
    private final RequisitionDao requisitionDao;


    public RequisitionServiceImpl(RequisitionDao requisitionDao) {
        this.requisitionDao = requisitionDao;
    }

    @Override
    public void createRequisition(Requisition requisition) {
        requisitionDao.save(requisition);
    }

    @Override
    public Requisition getRequisition(Long id) {
        return requisitionDao.findById(id)
                .orElseThrow( () -> new RequisitionNotFoundException(id));
    }

    @Override
    public List<Requisition> findAll() {
        List<Requisition> requisitions = requisitionDao.findAll();
        if(requisitions.isEmpty()) throw new NoDataFoundException();
        return requisitions;
    }

    @Override
    public void deleteRequisition(Long id) {
         requisitionDao.deleteById(id);
    }

    @Override
    public Requisition updateRequisition(Requisition requisition, Long id) {
        requisitionDao.deleteById(id);
        return requisitionDao.save(requisition);
    }

}
