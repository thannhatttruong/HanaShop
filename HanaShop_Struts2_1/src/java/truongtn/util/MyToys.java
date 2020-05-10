/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truongtn.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author truongtn
 */
public class MyToys {

    public HashMap<String, String> getResourceBundleHashMap(String path) throws MissingResourceException, NullPointerException {
        HashMap<String, String> servletMap = new HashMap<>();
        ResourceBundle rb = ResourceBundle.getBundle(path);
        Enumeration<String> key = rb.getKeys();
        while (key.hasMoreElements()) {
            String servletKey = key.nextElement();
            String servletVaue = rb.getString(servletKey);
            servletMap.put(servletKey, servletVaue);
        }

        return servletMap;
    }

    public List<String> getResourceBundleList(String path) {
        List<String> list = new ArrayList<>();
        ResourceBundle rb = ResourceBundle.getBundle(path);
        Enumeration<String> key = rb.getKeys();
        while (key.hasMoreElements()) {            
            list.add(key.nextElement());
        }
        return  list;
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) throws Exception {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        try {
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
        } catch (Exception e) {
            return null;
        }
        return hexString.toString();
    }

    public static boolean sendEmail(String from, String password, String to, String host, String messageStr) throws MessagingException {
        try {
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.store.protocol", "pop3");
            props.put("mail.transport.protocol", "smtp");

            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("ping");
            message.setText(messageStr);

            Transport.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Date getCurrentDate(String format) throws Exception {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String dateStr = sdf.format(date);
            date = sdf.parse(dateStr);

            return date;
        } catch (Exception e) {
            return null;
        }
    }
    
//    public static void main(String[] args){
//        MyToys mt = new MyToys();
//        List<String> list = mt.getResourceBundleList("truongtn.authority.Admin");
//        
//        for (String list1 : list) {
//            System.out.println("VALUE: " + list1);
//        }
//    }
}
