package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void getId() {
        Employee employee = new Employee("Frodo", "Baggins", "Lord of the Rings", 30, "rakshablackbird@hotmail.com");
        long idExpected = 123;
        employee.setId(idExpected);
        assertEquals(idExpected, employee.getId());
    }

    @Test
    void setId() {
        Employee employee = new Employee("Frodo", "Baggins", "Lord of the Rings", 30, "rakshablackbird@hotmail.com");
        long idExpected = 15;
        employee.setId(idExpected);
        assertEquals(idExpected, employee.getId());
    }

    @Test
    void getFirstName() {
        Employee employee = new Employee("Sirius", "Black", "Slytherin", 18, "rakshablackbird@hotmail.com");
        String nameExpected = "Sirius";
        assertEquals(nameExpected, employee.getFirstName());
    }

    @Test
    void setFirstName() {
        Employee employee = new Employee("Sirius", "Black", "Slytherin", 18, "rakshablackbird@hotmail.com");
        String nameExpected = "Padfoot";
        employee.setFirstName(nameExpected);
        assertEquals(nameExpected, employee.getFirstName());
    }

    @Test
    void getLastName() {
        Employee employee = new Employee("Legolas", "Greenleaf", "Prince of the Woodland Realm", 1000000, "rakshablackbird@hotmail.com");
        String nameExpected = "Greenleaf";
        assertEquals(nameExpected, employee.getLastName());
    }

    @Test
    void setLastName() {
        Employee employee = new Employee("Legolas", " Greenleaf", "Prince of the Woodland Realm", 1000000, "rakshablackbird@hotmail.com");
        String nameExpected = "Sindar Elf";
        employee.setLastName(nameExpected);
        assertEquals(nameExpected, employee.getLastName());
    }

    @Test
    void getDescription() {
        Employee employee = new Employee("Severus", "Snape", "Slytherin", 18, "rakshablackbird@hotmail.com");
        String descriptionExpected = "Slytherin";
        assertEquals(descriptionExpected, employee.getDescription());
    }

    @Test
    void setDescription() {
        Employee employee = new Employee("Severus", "Snape", "Slytherin", 18, "rakshablackbird@hotmail.com");
        String descriptionExpected = "Gryffindor";
        employee.setDescription(descriptionExpected);
        assertEquals(descriptionExpected, employee.getDescription());
    }

    @Test
    void getJobYears() {
        Employee employee = new Employee("Gimli", "son of Glóin", "Member of the Fellowship of the Ring.", 120, "rakshablackbird@hotmail.com");
        int jobYearsExpected = 120;
        assertEquals(jobYearsExpected, employee.getJobYears());
    }

    @Test
    void setJobYears() {
        Employee employee = new Employee("Gimli", "son of Glóin", "Member of the Fellowship of the Ring.", 120, "rakshablackbird@hotmail.com");
        int jobYearsExpected = 500;
        employee.setJobYears(jobYearsExpected);
        assertEquals(jobYearsExpected, employee.getJobYears());
    }

    @Test
    void getEmail() {
        Employee employee = new Employee("Raksha", "Jungle", "Mogli's mother", 120, "rakshablackbird@hotmail.com");
        String descriptionExpected = "rakshablackbird@hotmail.com";
        assertEquals(descriptionExpected, employee.getEmail());
    }

    @Test
    void setEmail() {
        Employee employee = new Employee("Raksha", "Jungle", "Mogli's mother", 120, "rakshablackbird@hotmail.com");
        String descriptionExpected = "AkelaBagera_Balu@hotmail.com";
        employee.setEmail("AkelaBagera_Balu@hotmail.com");
        assertEquals(descriptionExpected, employee.getEmail());
    }

    @Test
    void testToString() {
        Employee employee = new Employee("Jack", "Sparrow", "Captain", 33, "rakshablackbird@hotmail.com");
        long idExpected = 13;
        employee.setId(idExpected);
        String expected = "Employee{id=13, firstName='Jack', lastName='Sparrow', description='Captain', jobYears='33', email='rakshablackbird@hotmail.com'}";
        String result = employee.toString();
        assertEquals(expected, result);
    }

    @Test
    void testEquals() {
        Employee employee1 = new Employee("Fitzwilliam", "Darcy", "Novel", 30, "rakshablackbird@hotmail.com");
        Employee employee2 = new Employee("Elizabeth", "Bennet", "Novel", 20, "rakshablackbird@hotmail.com");
        Employee employee3 = new Employee("Fitzwilliam", "Darcy", "Novel", 30, "rakshablackbird@hotmail.com");

        assertEquals(employee1, employee3);
        assertNotEquals(employee1, employee2);
    }

    @Test
    void testHash() {
        Employee employee1 = new Employee("Fitzwilliam", "Darcy", "Novel", 30, "rakshablackbird@hotmail.com");
        Employee employee2 = new Employee("Elizabeth", "Bennet", "Novel", 20, "rakshablackbird@hotmail.com");
        Employee employee3 = new Employee("Fitzwilliam", "Darcy", "Novel", 30, "rakshablackbird@hotmail.com");

        assertEquals(employee1.hashCode(), employee3.hashCode());
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void firstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Targaryen", "Khaleesi", 10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void firstNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Targaryen", "Khaleesi", 10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void lastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Daenerys", null, "Khaleesi", 10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void lastNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Daenerys", "", "Khaleesi", 10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void descriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Daenerys", "Targaryen", null, 10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void descriptionEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Daenerys", "Targaryen", "", 10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void jobYearsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Daenerys", "Targaryen", "Khaleesi", -10, "rakshablackbird@hotmail.com"));
    }

    @Test
    void emailEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Peter", "Pan", "Neverland", 10, ""));
    }

    @Test
    void emailNull() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Mary", "Poppins", "Supercalifragilisticexpialidocious", 1000, null));
    }
    @Test
    void emailInvalid () {
        assertThrows(IllegalArgumentException.class, () -> new Employee("Mary", "Poppins", "Supercalifragilisticexpialidocious", 1000, "marypoppins.com"));
    }
}
