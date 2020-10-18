package mx.com.proyecti;

import java.rmi.RemoteException;

import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.FaultBean;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapAgeInfo;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapContext;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapContextPropertiesEntry;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapNameField;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapPersonGenderizerProxy;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapPersonGenderizerResult;
import org.nameapi.server.soap.v4_0.services.genderizer.persongenderizer.SoapSimpleNaturalPerson;

public class GenderApiImpl {

	public static void main(String[] args) {
		SoapPersonGenderizerProxy proxy = new SoapPersonGenderizerProxy();
		
		SoapContext context = new SoapContext();
		context.setApiKey("16e8ab8ed4ad7d77dabab6a5760131c9-user1\r\n");
		SoapContextPropertiesEntry[] entry = new SoapContextPropertiesEntry[1];
		context.setProperties(null);
		
		SoapSimpleNaturalPerson person = new SoapSimpleNaturalPerson();
		person.setAgeInfo(new SoapAgeInfo(1, 1, 1990, null));
		
		SoapNameField[] personName = new SoapNameField[1];
		personName[0] = new SoapNameField("FULLNAME", "Jose Maria Perez");
		person.setPersonName(personName);
		
		try {
			SoapPersonGenderizerResult result = proxy.assess(context, person);
			System.out.println("Genero: " + result.getGender() + ", certeza: " + result.getConfidence());
		} catch (FaultBean e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
