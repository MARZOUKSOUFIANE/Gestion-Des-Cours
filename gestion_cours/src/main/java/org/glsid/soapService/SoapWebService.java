package org.glsid.soapService;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.glsid.dao.CourRepository;
import org.glsid.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService(name = "schoolWS")
public class SoapWebService {
	@Autowired
	private CourRepository CourRepository;
	
	@WebMethod
	public List<Cours> getCours(){
		return CourRepository.findAll();
	}
	
	@WebMethod
	public Cours getCour(@WebParam(name = "code") long code){
		return CourRepository.findById(code).get();
	}
	
	@WebMethod
	public void SaveCours(@WebParam(name = "cours") Cours cours){
		 CourRepository.save(cours);
	}
	

}
