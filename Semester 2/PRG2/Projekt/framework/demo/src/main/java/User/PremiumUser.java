package User;

import javax.persistence.Entity;

@Entity
public class PremiumUser extends User {
	
	private String phoneNr;
	
	private String mailAddress;
	
	@SuppressWarnings("unused")
	private PremiumUser() {
		super();
	}

	public PremiumUser(String username, String password, String phoneNr, String mailAddress) {
		super(username, password);
		this.phoneNr = phoneNr;
		this.mailAddress = mailAddress;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

}
