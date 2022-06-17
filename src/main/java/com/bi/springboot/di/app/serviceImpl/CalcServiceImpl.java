package com.bi.springboot.di.app.serviceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bi.springboot.di.app.service.CalcService;
import com.google.gson.Gson;

public class CalcServiceImpl implements CalcService{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{n01}/{n02}/{operador}")
    public String operar(@PathParam("n01") String n01,
    		@PathParam("n02") String n02,
    		@PathParam("operador") String operador){
    	
    	int n1 = Integer.parseInt(n01);
    	int n2 = Integer.parseInt(n02);        
        int result = 0;
        if(operador.equals("+")) {
        	result = n1+n2;
        } else if (operador.equals("-")) {
        	result = n1-n2;
        } else if (operador.equals("*")) {
        	result = n1*n2;
        } else if (operador.equals("/")) {
        	result = n1/n2;
        } else {
        	return "Operación inválida";
        }

        Gson converter = new Gson();
        String json = converter.toJson(result);
        return json;
    }
}
