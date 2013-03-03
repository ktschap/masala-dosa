package pepparkmead.google;

import java.io.IOException;
import java.util.logging.Logger;

import pepparkmead.EmailSender;
import pepparkmead.IAdminSender;

import com.google.appengine.api.mail.MailService;
import com.google.appengine.api.mail.MailServiceFactory;

public class GoogleAdminSender implements IAdminSender {
	
	private static final Logger log = Logger.getLogger(EmailSender.class.getName());
	
	@Override
	public void send(String fromAddr, String subject, String msgBody) {
		MailService svc = MailServiceFactory.getMailService(); 
		MailService.Message msg = new MailService.Message(
			fromAddr, "admins", subject, msgBody);
		try {
			svc.send(msg);
			log.info("Sent msg to admins");
		} catch (IOException e) {
			log.severe("unable to email admins!" + e.toString());
			e.printStackTrace();
		}		
	}
}
