package chapter9.question4;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Question4 {	
	public static void main(String[] args) throws IOException {
		// multi-catchにより記述が簡潔になった例:
		// OLD STYLE
		try {
			var factory = DocumentBuilderFactory.newInstance();
			var builder = factory.newDocumentBuilder();
			var document = builder.parse("sample.xml");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		// NEW STYLE
		try {
			var factory = DocumentBuilderFactory.newInstance();
			var builder = factory.newDocumentBuilder();
			var document = builder.parse("sample.xml");
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		
		// 共通例外の導入により記述が簡潔になった例:
		// OLD STYLE
		try {
			Question4.class.getMethod("main").invoke(null, new String[] {});
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		// NEW STYLE 1
		try {
			Question4.class.getMethod("main").invoke(null, new String[] {});
		} catch (IllegalAccessException 
					| IllegalArgumentException 
					| InvocationTargetException 
					| NoSuchMethodException
					| SecurityException e) {
			e.printStackTrace();
		}
		
		// NEW STYLE 2
		try {
			Question4.class.getMethod("main").invoke(null, new String[] {});
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

}
