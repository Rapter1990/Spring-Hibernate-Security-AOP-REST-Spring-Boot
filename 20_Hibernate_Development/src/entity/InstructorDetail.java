package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INSTRUCTORDETAIL",catalog = "SPRINGDATABASE")
public class InstructorDetail {

	@Id
	@SequenceGenerator(name="INSTRUCTORDETAIL_SEQ", sequenceName="INSTRUCTORDETAIL_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTORDETAIL_SEQ")
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="YOUTUBECHANNEL")
	private String youtubeChannel;
	
	@Column(name="HOBBY")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail",cascade=CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstructorDetail(int id) {
		super();
		this.id = id;
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + id;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((youtubeChannel == null) ? 0 : youtubeChannel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstructorDetail other = (InstructorDetail) obj;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (id != other.id)
			return false;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (youtubeChannel == null) {
			if (other.youtubeChannel != null)
				return false;
		} else if (!youtubeChannel.equals(other.youtubeChannel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby
				+ ", instructor=" + instructor + "]";
	}
	
	
}
