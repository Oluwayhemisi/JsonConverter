package com.interswitch.customer.convertToJson;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.io.StringWriter;
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Employee {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "phone-number")
    private PhoneNumber phoneNumber;

    @XmlElement(name = "address")
    private Address address;

    @XmlElement(name = "department")
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static void main(String[] args) throws JAXBException {
        Employee employee = new Employee();
        employee.setName("Oluwayemisi Ismail");

        Address address1 = new Address();
        address1.setCity("Kaduna");
        address1.setHouseNo("eb2 ungwan shanu");
        address1.setPostalCode("656786");
        address1.setState("Kaduna");


        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setHome("070324564455");
        phoneNumber1.setWork("09076543456");


        Manager manager = new Manager();
        manager.setName("Daniel");
        manager.setPhoneNumber(phoneNumber1);

        Department department1 = new Department();
        department1.setName("IT");
        department1.setManager(manager);

        employee.setDepartment(department1);
        employee.setPhoneNumber(phoneNumber1);
        employee.setAddress(address1);



        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.marshal(employee, writer);


        System.out.println(writer.toString());

        Unmarshaller unmarshaller = context.createUnmarshaller();
        File file = new File("employee.xml");
        Employee emp = (Employee) unmarshaller.unmarshal(file);
        System.out.println(emp.toString());


    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", department=" + department +
                '}';
    }
}



