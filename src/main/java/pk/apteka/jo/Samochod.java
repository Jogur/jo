package pk.apteka.jo;

public class Samochod {
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	//private Silnik silnik;
	private int id;
	private String marka;
	private String model;
	
	public void uruchomSamochod()
	{
		System.out.println("Uruchomiono samochod marki:"+marka+", modelu:"+model+", id:"+id);
		//silnik.uruchom();
	}
}
