package pk.apteka.jo.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import pk.apteka.jo.domain.Transakcja;
import pk.apteka.jo.domain.Uzytkownik;
import pk.apteka.jo.service.UzytkownikService;

@Repository
public class TransakcjaDao {

	@Autowired
	private UzytkownikService uzytkownikService;
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Transakcja> towaryTransakcji(int id){
		//final String query = "SELECT * FROM `uzytkownik` INNER JOIN `transakcja` ON uzytkownik.idUzytkownika=transakcja.idTransakcji INNER JOIN `towar_transakcja` ON transakcja.idTransakcji=towar_transakcja.idTransakcji INNER JOIN `towar` ON towar_transakcja.idTowaru=towar.idTowaru";
		final String query = "SELECT * FROM `uzytkownik` INNER JOIN `transakcja` ON "
				+ "uzytkownik.idUzytkownika=transakcja.idTransakcji";
		
		List<Transakcja> transakcje = jdbcTemplate.query(query,  new TransakcjaMapper()); 
		return transakcje;
	}
	
	private static class TransakcjaMapper implements RowMapper<Transakcja> {
		public Transakcja mapRow(ResultSet rs, int rowNum) throws SQLException {
			Transakcja transakcja = new Transakcja();
			
		    return null;
		}
	}

	public void kup(final int idTowaru, String loginUzytkownika) {
		final Uzytkownik uzytkownik = uzytkownikService.find(loginUzytkownika);
		System.out.println("KROKODYL "+uzytkownik.getIdUzytkownika());
		
		final String sql = "insert into transakcja(idUzytkownika, data) values (?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		

		final java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());	
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, uzytkownik.getIdUzytkownika());
				ps.setDate(2, date);
				
				
				return ps;
			}
		}, keyHolder);
		
		final int id = keyHolder.getKey().intValue();
		System.out.println("konie "+keyHolder.getKey());
		final String sql2 = "insert into towar_transakcja(idTransakcji, idTowaru, ilosc) values (?,?,?)";
		KeyHolder keyHolder2 = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, id);
				ps.setInt(2, idTowaru);
				ps.setInt(3, 2);
				
				return ps;
			}
		}, keyHolder2);
		
	}
}
