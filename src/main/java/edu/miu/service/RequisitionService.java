package edu.miu.service;

import edu.miu.domain.Requisition;

import java.util.List;

public interface RequisitionService {
    public Requisition createRequisition(Requisition requisition);
    public Requisition getRequisition(long id);
    public  List<Requisition> findAll();
    public void deleteRequisition(long id);
    public Requisition updateRequisition(Requisition requisition, Long id);

}