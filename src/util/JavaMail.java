package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public static void sendMail(String mailcontent, String mailTo) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", "smtp.qq.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getInstance(prop); // 创建出与指定邮件服务器会话的session
		session.setDebug(true);
		Message message = null;
		message = createMessage(session, mailcontent, mailTo);

		Transport ts;
		ts = session.getTransport();
		ts.connect("1074545235@qq.com", "vxvfbeqpewegicjd");
		ts.sendMessage(message, message.getAllRecipients()); // 向谁发送一封邮件
		ts.close(); // 断开与服务器的连接
	}

	private static Message createMessage(Session session, String mailcontent, String mailTo)
			throws AddressException, MessagingException, UnsupportedEncodingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("1074545235@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
		// message.setRecipient(Message.RecipientType.TO, new
		// InternetAddress("guanyangchun@126.com"));
		message.setSubject("TEST");

		message.setContent(mailcontent, "text/html;charset=utf-8");
		message.saveChanges();
		return message;
	}
}
