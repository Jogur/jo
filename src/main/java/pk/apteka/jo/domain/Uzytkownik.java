package pk.apteka.jo.domain;

public class Uzytkownik {
	private int idUzytkownika;
	private String login;
	private String haslo;
	private String imie;
	private String nazwisko;
	private String email;
	private String rola;
	
	
	public int getIdUzytkownika() {
		return idUzytkownika;
	}
	public void setIdUzytkownika(int idUzytkownika) {
		this.idUzytkownika = idUzytkownika;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRola() {
		return rola;
	}
	public void setRola(String rola) {
		this.rola = rola;
	}
	
	
}
