package entities;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
@Component
public class User {

	private int id;
	@NotEmpty(message="Name is required.")
	@Pattern(regexp="[A-Z, a-z]{3}[a-z, A-Z, ]*",
	message="Name can contain only alphabets ans spaces. Min size 3.")
	private String name;
	@NotEmpty(message="MailId is required.")
	@Email(message="MailId should be proper format.")
	private String mailId;
	@Length(min=4,message="Password must have at least 4 chars.")
	@NotEmpty(message="Password is required.")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
