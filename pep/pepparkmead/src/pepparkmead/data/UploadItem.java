package pepparkmead.data;


import org.gmr.web.multipart.GMultipartFile;

public class UploadItem
{
  private String name;
  private GMultipartFile fileData;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
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