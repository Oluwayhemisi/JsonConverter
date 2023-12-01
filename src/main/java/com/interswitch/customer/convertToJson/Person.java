package com.interswitch.customer.convertToJson;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.io.StringWriter;

@XmlRootElement
public class Person {

    private String name;

    @XmlElement
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public static void main(String[] args) throws JAXBException {
        Person person = new Person();
        person.setName("John Doe");

        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();

        StringWriter writer = new StringWriter();
        marshaller.marshal(person, writer);


        System.out.println(writer.toString());

        Unmarshaller unmarshaller = context.createUnmarshaller();
        File file = new File("person.xml");
        Person per = (Person) unmarshaller.unmarshal(file);
        System.out.println(per.toString());


    }
    @Override
    public String toString(){
        return getName();
    }

}