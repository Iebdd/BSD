package General;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Utils.HibernateSupport;

@Entity
public class Application implements ISaveAndDelete {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appId;
	
	private String appName; 
	
	@OneToMany
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	@Enumerated(EnumType.ORDINAL)
	private AppType applicationType;
	
	@SuppressWarnings("unused")
	private Application() {
	}
	
	public Application(String name, AppType type) {
		this.appName = name;
		this.applicationType = type;
		this.comments = new ArrayList<Comment>();
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public AppType getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(AppType applicationType) {
		this.applicationType = applicationType;
	}

	public int getAppId() {
		return appId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment commentToAdd) {
		if(this.comments == null)
			this.comments = new ArrayList<Comment>();
		
		this.comments.add(commentToAdd);
	}

	@Override
	public boolean save() {
		for(Comment c: this.comments)
			if(!HibernateSupport.commit(c))
				return false;
		
		if(!HibernateSupport.commit(this))
			return false;
		
		return true;
	}

	@Override
	public void delete() {
		for(Comment c: this.comments)
			HibernateSupport.deleteObject(c);
		
		HibernateSupport.deleteObject(this);
	}

}
