public class EmployeeService {

    public void saveEmployee(Employee employee) {
        // Business logic for saving an employee
        // This method also includes data access logic

        // Data access logic - Saving employee to the database
        EntityManager entityManager = Persistence.createEntityManagerFactory("EmployeePU").createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Employee getEmployeeById(int id) {
        // Business logic for fetching an employee
        // This method also includes data access logic

        // Data access logic - Fetching employee from the database
        EntityManager entityManager = Persistence.createEntityManagerFactory("EmployeePU").createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }

    // Other methods for employee management (e.g., updateEmployee, deleteEmployee) may also be included here
}
