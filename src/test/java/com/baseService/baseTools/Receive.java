package com.baseService.baseTools;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.w3c.dom.Document;

public class Receive {

    /**
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        String ns = "http://service.joinforwin.com/";
        String wsdlUrl = "http://60.205.106.84:8075/ClinicalNutriSystem.asmx?wsdl";
        //1����������(Service)
        URL url = new URL(wsdlUrl);
        QName sname = new QName(ns,"NutritionSystemService");
        Service service = Service.create(url,sname);
                    
        //2������Dispatch
        Dispatch<SOAPMessage> dispatch = service.createDispatch(new QName(ns,"NutritionSystemServiceSoap12"),SOAPMessage.class,Service.Mode.MESSAGE);
                    
        //3������SOAPMessage
        SOAPMessage msg = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
        SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
        SOAPBody body = envelope.getBody();
        //4������QName��ָ����Ϣ�д�������
        QName ename = new QName(ns,"service ");//<nn:add xmlns="xx"/>
        SOAPBodyElement ele = body.addBodyElement(ename);
        // ���ݲ���
        SOAPElement element1 = ele.addChildElement("param","");
        element1.setValue("soapParam");
        element1.setAttribute("xmlns", "");
        SOAPElement element2 = ele.addChildElement("data","");  
        element2.setValue("soapData");
        element2.setAttribute("xmlns", "");
       
        msg.writeTo(System.out);
        System.out.println("\n invoking.....");
        //5��ͨ��Dispatch������Ϣ,�᷵����Ӧ��Ϣ
        SOAPMessage response = dispatch.invoke(msg);
        response.writeTo(System.out);
        System.out.println();
                    
        //6����Ӧ��Ϣ����,����Ӧ����Ϣת��Ϊdom����
        Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();
        String str = doc.getElementsByTagName("serviceResponse").item(0).getNodeValue();
        System.out.println(str);

    }

}