/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.util;

import org.apache.http.client.fluent.Request;
/**
 *
 * @author truongtn
 */
public class NetUtil {
    
    public static String GetResult(String url){
        try {
            return Request.Get(url).setHeader("Accept-Charset", "utf-8").execute().returnContent().asString();
        } catch (Exception e) {
            System.out.println("Error at GetResult method in NetUtil class: " + e.getMessage());
        }
        return null;
    }
}
