package Utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import General.Application;
import General.Comment;
import User.PremiumUser;
import User.User;

/**
 * Class for creating the database
 * @author Stettinger
 *
 */

public class DatabaseConstruction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start DB Construction");
		
		Configuration configuration = new Configuration();
		
		//TODO add classes
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(PremiumUser.class);
		configuration.addAnnotatedClass(Application.class);
		configuration.addAnnotatedClass(Comment.class);
		
		configuration.configure("hibernate.cfg.xml");

		new SchemaExport(configuration).create(true, true);

		System.out.println("Finished");
	}
	
}
