
public abstract class TypeEmployee {
private String name;
private String employment;

TypeEmployee(){
	name=null;
	employment=null;
}

public abstract String getEmployment();

public void setEmployement(String employment) {
	this.employment = employment;
}

public String toString(){
	return "Name="+this.name+"::employment="+this.employment;
}


}
