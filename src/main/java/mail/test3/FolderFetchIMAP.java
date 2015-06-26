package mail.test3;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;


public class FolderFetchIMAP {

    public static void main(String[] args) throws MessagingException, IOException {
        IMAPFolder folder = null;
        Store store = null;
        Flag flag = null;

        try {
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");

//            String host = "192.168.0.251:110/pop3";// change accordingly
//            String username = "xml";// change accordingly
//            String password = "hjNP8x3z";// change accordingly

//            String host = "imap.yandex.ru";                  // change accordingly
//            String username = "Ampmail@yandex.ua";           // change accordingly
//            String password = "12qwaszx";                    // change accordingly

            String host = "imap.googlemail.com";            // change accordingly
            String username = "service.dclink@gmail.com";   // change accordingly
            String password = "servicedclink";              // change accordingly

            store.connect(host, username, password);

//            folder = (IMAPFolder) store.getFolder("[Gmail]/Spam");  // This doesn't work for other email account
            folder = (IMAPFolder) store.getFolder("inbox");         //This works for both email account

            if (!folder.isOpen()) {
                folder.open(Folder.READ_WRITE);
            }
            Message[] messages = folder.getMessages();
            System.out.println("No of Messages : " + folder.getMessageCount());
            System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
            System.out.println(messages.length);
            for (int i = 0; i < messages.length; i++) {

                System.out.println("*****************************************************************************");
                System.out.println("MESSAGE " + (i + 1) + ":");
                Message msg = messages[i];
                //System.out.println(msg.getMessageNumber());
                //Object String;
                //System.out.println(folder.getUID(msg)

                String subject = "";
                String from = "";
                String recipient = "";
                Object content = "";

                if (msg != null) {
                    if (msg.getSubject() != null) subject = MimeUtility.decodeText(msg.getSubject());
                    if (msg.getFrom() != null) from = MimeUtility.decodeText(msg.getFrom()[0].toString());
                    if (msg.getAllRecipients() != null)
                        recipient = MimeUtility.decodeText(msg.getAllRecipients()[0].toString());
//                    if (msg.isMimeType("text/plain")) {
//                        if (msg.getContentType().toString().startsWith("multipart/alternative;")) {
//                            content = msg.getContent();
//                        }
//                    }

                    System.out.println("Subject: " + subject);
                    System.out.println("From: " + from);
                    System.out.println("To: " + recipient);
                    System.out.println("Date: " + msg.getReceivedDate());
                    System.out.println("Size: " + msg.getSize());
                    System.out.println(msg.getFlags());
//                    System.out.println(msg.getContentType());
                    System.out.println("Body: \n" + content);
                }
            }
        } finally {
            if (folder != null && folder.isOpen()) {
                folder.close(true);
            }
            if (store != null) {
                store.close();
            }
        }
    }
}