import java.util.List;
import java.util.LinkedList;

public class Directory extends FileSystemElement{
	
protected List<FileSystemElement> children;

public Directory(String name,FileSystemElement parent) {
	super(name, parent);
	children=new LinkedList<>();
}

public void addElement(FileSystemElement element) {
	children.add(element);
}
public void removeElement(FileSystemElement element) {
	children.remove(element);
} 
@Override
public void print(String prefix) {
	// TODO Auto-generated method stub
	System.out.println(prefix+"Directory "+getname());
	for(FileSystemElement elem:children) {
	elem.print(prefix+" ");
	}
}
}
