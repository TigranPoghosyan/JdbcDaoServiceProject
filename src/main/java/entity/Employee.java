package entity;

import java.sql.Date;
import java.util.Objects;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Long addresId;

    public Employee(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(birthday, employee.birthday) &&
                Objects.equals(addresId, employee.addresId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, addresId);
    }

    public Employee(Long id, String firstName, String lastName, Date birthday, Long addresId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.addresId = addresId;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", addresId=" + addresId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getAddresId() {
        return addresId;
    }

    public void setAddresId(Long addresId) {
        this.addresId = addresId;
    }
}
