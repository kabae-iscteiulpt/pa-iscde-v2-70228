
public class Pessoa{
	
	private int nif_;
	private String name;
	private short age;
	
	
	public Pessoa(String name, int nif_, short age){
		this.setName(name);
		this.setNif_(nif_);
		this.setAge(age);
	}
	
	
	public int getNif_(){
		return this.nif_;
	}
	
	public void setNif_(int nif_){
		
		this.nif_=nif_;
	}
	
	public String getName(){
	//TODO estudar SWT	
		return this.name;
	}
	
	public void setAge(short age){
		this.age=age;
	}
	
	
	public void setName(String name){
		
		this.name = name;
	}
	
	
	
	
}