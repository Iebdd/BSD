import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import General.AppType;
import General.Application;
import General.Comment;
import User.PremiumUser;
import User.User;
import Utils.HibernateSupport;

public class TestFramework {

	public static void main(String[] args) {
		System.out.println("Start Test");
		
//		User user = new User("maxi", "123456");
//		
//		HibernateSupport.beginTransaction();
//		user.save();
//		HibernateSupport.commitTransaction();
		
//		User userFromDB = HibernateSupport.readOneObjectByID(User.class, 1);
//		
//		System.out.println("User loaded from DB: " + userFromDB.getUsername());
		
//		PremiumUser premiumUser = new PremiumUser("Premium User", "123456", "0316 / 123456", "test@test.de");
//		
//		HibernateSupport.beginTransaction();
//		premiumUser.save();
//		HibernateSupport.commitTransaction();
		
//		Application firstApp = new Application("My fancy first App", AppType.ADVANCED);
//		
//		HibernateSupport.beginTransaction();
//		firstApp.save();
//		HibernateSupport.commitTransaction();
		
//		Comment c = new Comment("My first Comment :-)", premiumUser);
//		Comment c1 = new Comment("My second Comment :-)", premiumUser);
//		Comment c2 = new Comment("My third Comment :-)", premiumUser);
//		Comment c3 = new Comment("My last Comment :-)", premiumUser);
		
//		HibernateSupport.beginTransaction();
//		c.save();
//		HibernateSupport.commitTransaction();
		
//		List<Comment> commentList = new ArrayList<Comment>();
//		commentList.add(c);
//		commentList.add(c1);
//		commentList.add(c2);
//		commentList.add(c3);
//	
//		Application fancyApp = new Application("My perfect App", AppType.ADVANCED);
//		fancyApp.setComments(commentList);
//		
//		HibernateSupport.beginTransaction();
//		fancyApp.save();
//		HibernateSupport.commitTransaction();
		
		User userFromDB = HibernateSupport.readOneObjectByID(User.class, 1);
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("originator", userFromDB));
		
		List<Comment> commentsFromDB = HibernateSupport.readMoreObjects(Comment.class, criterions);
		
		if(commentsFromDB != null && commentsFromDB.size()>0) {
			for(Comment c: commentsFromDB)
				System.out.println("Comment from DB: " + c.getComment());
		}
		
		System.out.println("End Test");
	}

}
