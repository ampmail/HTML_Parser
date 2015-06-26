package mail.test2;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailList_POP3 {

    public static void main(String[] args) {

//        String host = "{192.168.0.251:110/pop3/novalidate-cert}INBOX";// change accordingly
//        String username = "xml";// change accordingly
//        String password = "hjNP8x3z";// change accordingly
        String host = "pop.yandex.ru";// change accordingly
        String username = "Ampmail@yandex.ua";// change accordingly
        String password = "12qwaszx";// change accordingly
//        String host = "pop.gmail.com";// change accordingly
//        String username = "service.dclink@gmail.com";// change accordingly
//        String password = "servicedclink";// change accordingly

        check(host, username, password);
    }

    public static void check(String host, String user, String password)
    {
        try {
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.user", user);
            properties.put("mail.pop3.user", password);
            properties.put("mail.pop3.socketFactory", 995);
            properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.put("mail.pop3.port", 995);

            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            System.out.println(host +"\t"+ user +"\t"+ password);
            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}