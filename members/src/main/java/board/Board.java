package board;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int bno;
	private String title;
	private String content;
	private Timestamp createdate;
	private Timestamp modifydate;
	private int hit;
	private String filename; 
	private String memid;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public Timestamp getModifydate() {
		return modifydate;
	}
	public void setModifydate(Timestamp modifydate) {
		this.modifydate = modifydate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	} 

}
