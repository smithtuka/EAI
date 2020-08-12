package edu.miu.aspect.exception;

public class RequisitionNotFoundException extends RuntimeException {
    public RequisitionNotFoundException(Long  id) {
        super(String.format("Requisition with Id %d not found", id));
    }
}

