package com.baseService.baseTools;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 通过UrlConnection调用Webservice服务
 *
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //服务的地址
        URL wsUrl = new URL("http://60.205.106.84:8075/ClinicalNutriSystem.asmx");
        HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();
        
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
//        conn.setRequestProperty("SOAPAction", "http://service.joinforwin.com/service");
        OutputStream os = conn.getOutputStream();
        
        //请求体
        String soap = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
+ "<soap:Body>"
+ "<service xmlns=\"http://service.joinforwin.com/\">"
+ "<param>1111</param>"
+ "<data>22222</data>"
+ " </service>"
+ " </soap:Body>"
+ "</soap:Envelope>";
        
        os.write(soap.getBytes());
        
        InputStream is = conn.getInputStream();
        
        byte[] b = new byte[1024];
        int len = 0;
        String s = "";
        while((len = is.read(b)) != -1){
            String ss = new String(b,0,len,"UTF-8");
            s += ss;
        }
        System.out.println(s);
        
        is.close();
        os.close();
        conn.disconnect();
    }
}
