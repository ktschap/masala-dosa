package pepparkmead;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender implements ISender {

	IAdminSender adminSender;
	
	public void setAdminSender(IAdminSender s) {
		adminSender = s;
	}
	
	private static final Logger log = Logger.getLogger(EmailSender.class.getName());
	@Override
	public void send(String toAddr, Set<String> ccEmails, String fromAddr, String subject, String msgBody) {
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromAddr, fromAddr));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(toAddr, toAddr));
            log.info("Mailing " + toAddr + ". Msg: "+ msgBody.substring(140, 450));
            if (ccEmails != null) {
            	for (String n : ccEmails) {
            		msg.addRecipient(Message.RecipientType.CC, 
            				new InternetAddress(n, n));
            		log.info("CC on email: " + n);
            	}
            }
            msg.setSubject(subject);
            msg.setText(msgBody);
            Transport.send(msg);
            
            adminSender.send(fromAddr, subject, msgBody);

        } catch (AddressException e) {
            log.severe(e.toString());
        } catch (MessagingException e) {
            log.severe(e.toString());
	    } catch (UnsupportedEncodingException e) {
	        // ...
	    }	
	}
}
