package edu.miu.reporting;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import edu.miu.domain.Department;
import edu.miu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/export-departments")
public class Reporting {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public void exportCSV(HttpServletResponse response) throws  Exception{

        String filename = "departments.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");


        StatefulBeanToCsv<Department> writer = new StatefulBeanToCsvBuilder<Department>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();


        writer.write(departmentService.getAllDepartments());
    }
}
