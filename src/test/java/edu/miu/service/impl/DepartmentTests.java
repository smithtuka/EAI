package edu.miu.service.impl;

import edu.miu.dao.DepartmentDao;
import edu.miu.domain.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentTests {
    @Autowired
    DepartmentDao departmentDao;
    @Test
    public void testAddDepartment(){
        Department department= new Department("ICT");
        Department savedDepartment = departmentDao.save(department);
        assertNotNull(savedDepartment);

    }

}
