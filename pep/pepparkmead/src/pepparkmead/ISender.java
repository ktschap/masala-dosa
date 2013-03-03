package pepparkmead;

import java.util.Set;

public interface ISender {

	public void send(String toAddr, Set<String> ccEmails, String fromAddr, String sender, String msg);		
}
