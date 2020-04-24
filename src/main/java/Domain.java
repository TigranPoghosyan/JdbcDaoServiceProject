import Buisnesslogic.Utill;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;

public class Domain {
    public static void main(String[] args) {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjService emplProjService = new EmplProjService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("USA");
        address.setCity("California");
        address.setStreet("Arcax");
        address.setPost_code("12345");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Adam");
        employee.setLastName("Traore");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1994,Calendar.APRIL,1);

        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));
        employee.setAddresId(address.getId());

        Project project = new Project();

        project.setId(1L);
        project.setTitle("Es verjapes areci saaa u es sharjvumem araaajjj!!!!");

        EmplProj emplProj = new EmplProj();

        emplProj.setEmployeeId(employee.getId());
        emplProj.setProjectId(employee.getId());

        try {
            addressService.add(address);
            employeeService.add(employee);
            projectService.add(project);
            emplProjService.add(emplProj);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
