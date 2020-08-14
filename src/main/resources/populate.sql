-- User credentials
INSERT INTO authentication(user,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO authentication(user,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

-- User Authority
INSERT INTO authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');

-- Departments
INSERT INTO `department` (department_id, name) VALUES (1, 'Marketing');
INSERT INTO `department` (department_id, name) VALUES (2, 'Sales');
INSERT INTO `department` (department_id, name) VALUES (3, 'Personnel');

-- Address
INSERT INTO `address` (address_id, city, street, zipcode) VALUES (1, 'Iowa City', 'Iowa', '52240');
INSERT INTO `address` (address_id, city, street, zipcode) VALUES (2, 'Orlando', 'Florida', '32801');

-- Employees
INSERT INTO `employee` (employee_id, is_admin, age, first_name, hire_date, last_name, address_id, department_id, user_credentials_id) VALUES (1, TRUE, 31, 'Curious', '1980-09-11', 'George', 1, 1, 'admin');

INSERT INTO `employee` (employee_id, is_admin, age, first_name, hire_date, last_name, address_id, department_id, user_credentials_id) VALUES (2, FALSE, 28, 'Allen', '1990-05-05', 'Rench', 2, 2, 'guest');

-- Projects
INSERT INTO `project` (project_id, name, department_id, created_by) VALUES (1, 'Project 1', 1, 1);

-- Requisitions
INSERT INTO `requisition` (requisition_id, description, approval_status, title, employee_id, project_id) VALUES (1, 'Description', 'PENDING', 'Requisition 1', 1, 1);

-- Groups
