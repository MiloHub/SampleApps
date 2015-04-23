package com.spring.restful.TestREST;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
public class HelloWorld
{
	VelocityContext context = new VelocityContext();
	Template t =null;
	
	public HelloWorld()  {
		// TODO Auto-generated constructor stub
		Velocity.addProperty("file.resource.loader.path", "C:/Dhanaraj/1");
    	Velocity.addProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
    	Velocity.addProperty("resource.loader", "file");
    	try {
			Velocity.init();
			 t= Velocity.getTemplate(  "hh.vm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
        /*  next, get the Template  */
        
        /*  create a context and add data */
        
	}
    public static void main( String[] args )
        throws Exception
    {
        /*  first, get and initialize an engine  */
    	Velocity.addProperty("file.resource.loader.path", "C:/Dhanaraj/1");
    	Velocity.addProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
    	Velocity.addProperty("resource.loader", "file");
    	Velocity.init();
    	
    	
        /*  next, get the Template  */
        Template t = Velocity.getTemplate(  "hh.vm");
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
       
    }
    
    public void createClass(String key , Map value) throws ResourceNotFoundException, ParseErrorException, MethodInvocationException, IOException{
    	 context.put("name", value);
         /* now render the template into a StringWriter */
         StringWriter writer = new StringWriter();
         t.merge( context, writer );
         /* show the World */
         System.out.println( writer.toString() );     
    }
}