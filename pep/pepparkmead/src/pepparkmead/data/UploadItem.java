package pepparkmead.data;


import org.gmr.web.multipart.GMultipartFile;

import com.google.appengine.api.datastore.Blob;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UploadItem
{
	private GMultipartFile fileData;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long ID;

	@Persistent
    private String name;
	@Persistent
	private Blob data;

	public UploadItem() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public GMultipartFile getFileData()
	{
	  return fileData;
	}

	public void setFileData(GMultipartFile fileData)
	{
	  this.fileData = fileData;
	}
}