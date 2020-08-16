package edu.miu.batch;

import edu.miu.domain.Requisition;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<Requisition, Requisition> {

    private static final Map<String, String> EMPLOYEE_TITLE =
            new HashMap<>();

    public Processor() {
        EMPLOYEE_TITLE.put("001", "Accountant");
        EMPLOYEE_TITLE.put("002", "Senior Engineer");
        EMPLOYEE_TITLE.put("003", "Principal Engineer");
        EMPLOYEE_TITLE.put("004", "CEO");
        EMPLOYEE_TITLE.put("005", "Manager");
        EMPLOYEE_TITLE.put("006", "Chief of Staff");
    }

    @Override
    public Requisition process(Requisition requisition) throws Exception {
        Long empId = requisition.getEmployee().getId();
        String title = EMPLOYEE_TITLE.get(empId);
        requisition.setTitle(title);
        System.out.println(String.format("Converted from [%s] to [%s]", empId, title));
        return requisition;
    }
}
