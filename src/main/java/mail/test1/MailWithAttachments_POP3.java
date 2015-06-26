package mail.test1;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MailWithAttachments_POP3 {
    static final String ENCODING = "UTF-8";

    public static void main(String args[]) throws MessagingException, IOException {

//        String login = "service.dclink@gmail.com";
//        String password = "servicedclink";
//        String pop3Host = "pop.gmail.com";
        String pop3Host = "pop.yandex.ru";// change accordingly
        String login = "Ampmail@yandex.ua";// change accordingly
        String password = "12qwaszx";// change accordingly

        receiveMessage(login, password, pop3Host);
    }

    public static void receiveMessage(final String user, final String password, String host) throws MessagingException, IOException {
        //create properties field
        Properties properties = new Properties();

        properties.put("mail.store.protocol", "pop3s");
//        properties.put("mail.pop3.host", "pop.gmail.com");
        properties.put("mail.pop3.user", user);
        properties.put("mail.pop3.user", password);
        properties.put("mail.pop3.socketFactory", 995);
        properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.pop3.port", 995);

        Session emailSession = Session.getDefaultInstance(properties);

        //create the POP3 store object and connect with the pop server
        Store store = emailSession.getStore("pop3s");
        store.connect(host, user, password);

        Folder inbox = store.getFolder("INBOX");
//        inbox.open(Folder.READ_WRITE);
        inbox.open(Folder.READ_ONLY);

//        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        Message[] messages = inbox.getMessages();
        System.out.println("messages.length = " + messages.length);

        ArrayList<String> attachments = new ArrayList<String>();
//        LinkedList<MessageBean> listMessages = getPart(messages, attachments);

        for (Message ms : messages) {
            if (ms != null) {
                System.out.println("=========================================");
                System.out.println(ms.getMessageNumber());
                System.out.println(MimeUtility.decodeText(ms.getFrom()[0].toString()));
                System.out.println(MimeUtility.decodeText(ms.getSubject()));
                System.out.println(ms.getFlags().toString());
                System.out.println(ms.getSentDate());
                System.out.println(ms.getSize());
            }
        }
        inbox.setFlags(messages, new Flags(Flags.Flag.SEEN), false);
        inbox.close(false);
        store.close();
    }

    private static LinkedList<MessageBean> getPart(Message[] messages, ArrayList<String> attachments) throws MessagingException, IOException {
        LinkedList<MessageBean> listMessages = new LinkedList<MessageBean>();
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (Message inMessage : messages) {
            System.out.println("=======================================================");
            System.out.println(inMessage.getFrom()[0].toString());
            attachments.clear();
            if (inMessage.isMimeType("text/plain")) {
          System.out.println("text/plain");
                MessageBean message = new MessageBean(inMessage.getMessageNumber(), MimeUtility.decodeText(inMessage.getSubject()), inMessage.getFrom()[0].toString(), null, f.format(inMessage.getSentDate()), (String) inMessage.getContent(), false, null);
                listMessages.add(message);
            } else if (inMessage.isMimeType("multipart/*")) {
                Multipart mp = (Multipart) inMessage.getContent();
                MessageBean message = null;
                for (int i = 0; i < mp.getCount(); i++) {
          System.out.println("multipart/"+i);
                    Part part = mp.getBodyPart(i);
                    if ((part.getFileName() == null || part.getFileName() == "") && part.isMimeType("text/plain")) {
          System.out.println("text/plain");
                        String sentDate = "unknown";
                        if (inMessage.getSentDate() != null) {
                            sentDate = f.format(inMessage.getSentDate());
                        }
                        message = new MessageBean(inMessage.getMessageNumber(), inMessage.getSubject(), inMessage.getFrom()[0].toString(), null, sentDate, (String) part.getContent(), false, null);
                    } else if (part.getFileName() != null || part.getFileName() != "") {
                        System.out.println(part.getFileName() + "!");
                        if ((part.getDisposition() != null) && (part.getDisposition().equals(Part.ATTACHMENT))) {
                            System.out.println("ATTACHMENT");
                            attachments.add(saveFile(MimeUtility.decodeText(part.getFileName()), part.getInputStream()));
                            if (message != null) message.setAttachments(attachments);
                        }
                    }
                }
                listMessages.add(message);
            }
        }
        return listMessages;
    }

    private static String saveFile(String filename, InputStream input) {
        String path = "d:\\Temp\\mail\\downloaded_attachments\\" + filename;
        try {
            byte[] attachment = new byte[input.available()];
            input.read(attachment);
            File file = new File(path);
            FileOutputStream out = new FileOutputStream(file);
            out.write(attachment);
            input.close();
            out.close();
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}