package edu.miu.service.impl;

import edu.miu.domain.Requisition;
import edu.miu.dao.RequisitionDao;
import edu.miu.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitionServiceImpl implements RequisitionService {
    @Autowired
    private RequisitionDao requisitionDao;

    @Override
    public Requisition createRequisition(Requisition requisition) {
        return requisitionDao.save(requisition);
    }

    @Override
    public Requisition getRequisition(long id) {
        return requisitionDao.getOne(id);
    }

    @Override
    public List<Requisition> findAll() {
        return requisitionDao.findAll();
    }

    @Override
    public void deleteRequisition(long id) {
         requisitionDao.deleteById(id);
    }

    @Override
    public Requisition updateRequisition(Requisition requisition, Long id) {
        requisitionDao.deleteById(id);
        return requisitionDao.save(requisition);
    }
}
