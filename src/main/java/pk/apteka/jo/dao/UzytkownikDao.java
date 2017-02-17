package pk.apteka.jo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import pk.apteka.jo.domain.Uzytkownik;



@Repository
public class UzytkownikDao {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Uzytkownik> showAll(){
		final String query = "select * from uzytkownik";
		List<Uzytkownik> uzytkownicy = jdbcTemplate.query(query,  new UzytkownikMapper());
		return uzytkownicy;
	}
	
	private static class UzytkownikMapper implements RowMapper<Uzytkownik>{
		public Uzytkownik mapRow(ResultSet rs, int rowNum) throws SQLException {
			Uzytkownik uzytkownik = new Uzytkownik();
			uzytkownik.setIdUzytkownika(rs.getInt("idUzytkownika"));
			uzytkownik.setLogin(rs.getString("login"));
			uzytkownik.setHaslo(rs.getString("haslo"));
			uzytkownik.setImie(rs.getString("imie"));
			uzytkownik.setNazwisko(rs.getString("nazwisko"));
			uzytkownik.setEmail(rs.getString("email"));
			uzytkownik.setRola(rs.getString("rola"));
			return uzytkownik;
		}
	}

	public void add(final Uzytkownik uzytkownik, int rola) {
		final String sql = "insert into uzytkownik(login, haslo, imie, nazwisko, email, rola) values (?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String rolaString;
		if(rola==2){
			rolaString = "ROLE_DEALER";
		}else if(rola==1){
			rolaString="ROLE_USER";
		}else{
			rolaString="ROLE_USER";
		}
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, uzytkownik.getLogin());
				ps.setString(2, uzytkownik.getHaslo());
				ps.setString(3, uzytkownik.getImie());
				ps.setString(4, uzytkownik.getNazwisko());
				ps.setString(5, uzytkownik.getEmail());
				ps.setString(6, rolaString);
				return ps;
			}
		}, keyHolder);
		
		final String sql2 = "insert into users(username, password, enabled) values (?,?,?)";
		KeyHolder keyHolder2 = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, uzytkownik.getLogin());
				ps.setString(2, uzytkownik.getHaslo());
				ps.setString(3, "1");
				return ps;
			}
		}, keyHolder2);
		
		final String sql3 = "insert into user_roles(username, role) values (?,?)";
		KeyHolder keyHolder3 = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, uzytkownik.getLogin());
				ps.setString(2, "ROLE_USER");
				return ps;
			}
		}, keyHolder3);
	}

	public List<Uzytkownik> showSprzedawcy() {
		final String query = "select * from uzytkownik where rola = 'ROLE_DEALER'";
		List<Uzytkownik> sprzedawcy = jdbcTemplate.query(query,  new UzytkownikMapper()); 
		
		return sprzedawcy;
	}

	public List<Uzytkownik> showUzytkownicy() {
		final String query = "select * from uzytkownik where rola = 'ROLE_USER'";
		List<Uzytkownik> uzytkownicy = jdbcTemplate.query(query,  new UzytkownikMapper()); 
		
		return uzytkownicy;
	}

	public void usun(String login) {
		String sql = "DELETE FROM uzytkownik WHERE login=?";
		jdbcTemplate.update(sql, login);
		
		sql = "DELETE FROM user_roles WHERE username=?";
		jdbcTemplate.update(sql, login);
		
		sql = "DELETE FROM users WHERE username=?";
		jdbcTemplate.update(sql, login);
	}

	public Uzytkownik find(String login){
		final String query = "select * from uzytkownik WHERE login=?";
		Uzytkownik uzytkownik = (Uzytkownik) jdbcTemplate.queryForObject(query,  new Object[] { login }, new UzytkownikMapper());
		
		return uzytkownik;
	}
}
