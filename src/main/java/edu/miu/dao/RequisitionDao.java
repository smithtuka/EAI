package edu.miu.dao;

import edu.miu.domain.Requisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionDao extends JpaRepository<Requisition, Long> {
}
