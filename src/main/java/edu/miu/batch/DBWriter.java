package edu.miu.batch;

import edu.miu.dao.RequisitionDao;
import edu.miu.domain.Requisition;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Requisition> {
    @Autowired
    private RequisitionDao requisitionDao;
    @Override
    public void write(List<? extends Requisition> requisitions) throws Exception {

        System.out.println("Data Saved for Requisitions: " + requisitions);
        requisitions.forEach(requistion -> requisitionDao.save(requistion));
//        requisitionDao.saveAll(requisitions);
    }
}
