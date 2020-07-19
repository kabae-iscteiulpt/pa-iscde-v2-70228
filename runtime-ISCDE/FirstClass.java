
public class Pessoa{
	
	private int nif_;
	private String name;
	private short age;
	
	
	public Pessoa(String name, int nif_, short age){
		this.setName(name);
		this.setNif_(nif_);
		this.setAge(age);
	}
	
	//TODO high alter this getter.
	public int getNif_(){
		return this.nif_;
	}
	
	public void setNif_(int nif_){
		
		this.nif_=nif_;
	}
	
	//TODO change the name of the method below.
	public String getName(){
		return this.name;
	}
	
	public void setAge(short age){
		this.age=age;
	}
	
	//TODO HIGH cenas
	public void setName(String name){
		
		this.name = name;
	}
}