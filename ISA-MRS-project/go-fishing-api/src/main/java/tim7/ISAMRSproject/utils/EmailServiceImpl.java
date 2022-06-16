package tim7.ISAMRSproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tim7.ISAMRSproject.dto.ActionDTO;
import tim7.ISAMRSproject.model.Action;
import tim7.ISAMRSproject.model.Reservation;
import tim7.ISAMRSproject.model.User;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;
	
	private String CONFIRMATION_SUBJECT = "Go Fishing Account Verification";

	private String ACTION_SUBJECT = "Go Fishing AKCIJA!!!";

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("gofishingteam7@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
		System.out.println("Email sent successfully!");
	}
	
	public void sendConfirmationMail(User user) {
		String confirmationBody = "Dear " + user.getName() + " " + user.getLastName() + ", \n";
		confirmationBody += "Thank you for joining Go Fishing! In order to activate your account, ";
		confirmationBody += "please visit the following link: http://localhost:8080/reg/activate/" + user.getId().toString();
		sendSimpleMessage(user.getEmail(), CONFIRMATION_SUBJECT, confirmationBody);
	}

	public void sendActionEmail(User user, Reservation action){
		String confirmationBody = "Poštovani, " + user.getName() + " " + user.getLastName() + ", \n";
		confirmationBody += "Imamo novu akciju za Vas!\n";
		confirmationBody += "\nU pitanju je ponuda: " + action.getOffer().getName();
		confirmationBody += "\nPočetak: " + action.getStartDateTime().toString();
		confirmationBody += "\nKraj: " + action.getEndDateTime().toString();
		confirmationBody += "\nCena: " + action.getTotalPrice();

		sendSimpleMessage(user.getEmail(), ACTION_SUBJECT, confirmationBody);
	}
}
