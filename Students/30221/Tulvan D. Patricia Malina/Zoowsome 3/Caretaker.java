package javasmmr.zoowsome.models.employees;
import static javasmmr.zoowsome.repositories.AnimalRepository.createNode;

import java.math.BigDecimal;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.services.factories.animals.Constants;

public class Caretaker extends Employees implements Caretaker_I{
	
	private Double workingHours;
	
	public Caretaker(String name, BigDecimal salary,Long id,Double workingHours) {
		super(name,salary,id);
		this.workingHours=workingHours;
	}
	
	public Caretaker(){
		super();
		this.workingHours=0.0;
	}
	
	public void setWorkingHours(Double workingHours){
		this.workingHours=workingHours;
	}
	
	public Double getWorkingHours(){
		return workingHours;
	}

	public String takeCareOf(Animal a) {
		if(a.kill())
			return Constants.Employees.Caretakers.TCO_KILLED;
		if(this.workingHours<a.getMaintenanceCost())
			return Constants.Employees.Caretakers.TCO_NO_TIME;
		a.setTakenCareOf(true);
		workingHours-=a.getMaintenanceCost();
		return Constants.Employees.Caretakers.TCO_SUCCESS;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
 		createNode(eventWriter, "workingHours", String.valueOf(getWorkingHours()));
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Employees.Caretaker);
	}
		 
	public void decodeFromXml(Element element) {
	 	setWorkingHours(Double.valueOf(element.getElementsByTagName("workingHours").item(0).getTextContent()));
	}
}
