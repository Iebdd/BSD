package General;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import User.User;
import Utils.HibernateSupport;

@Entity
public class Comment implements ISaveAndDelete {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentID;
	
	@ManyToOne
	private User originator;
	
	private String comment;
	
	@SuppressWarnings("unused")
	private Comment() {
	}
	
	public Comment(String comment, User originator) {
		this.comment = comment;
		this.originator = originator;
	}
	
	public User getOriginator() {
		return originator;
	}

	public void setOriginator(User originator) {
		this.originator = originator;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCommentID() {
		return commentID;
	}

	@Override
	public boolean save() {
		if (!HibernateSupport.commit(this))
			return false;
		return true;
	}

	@Override
	public void delete() {
		HibernateSupport.deleteObject(this);
	}

}
