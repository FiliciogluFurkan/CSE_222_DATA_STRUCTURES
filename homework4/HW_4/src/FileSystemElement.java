import java.sql.Timestamp;

public abstract class FileSystemElement {
	protected String name;
	protected Timestamp  dataCreated;
	protected FileSystemElement parent;

public FileSystemElement(String name,FileSystemElement parent) {
	this.name=name;
	this.dataCreated=new Timestamp(System.currentTimeMillis());
	this.parent=parent;
}

public String getname() {
	return name;
}
public FileSystemElement getparent() {
	return parent;
}
public Timestamp gettime() {
	return dataCreated;
}
public void setparent(FileSystemElement parent) {
	this.parent=parent;
}
public abstract void print(String prefix);

}

