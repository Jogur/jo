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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import pk.apteka.jo.domain.Towar;


@Repository
public class TowarDao {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Towar> showAll() {
		String query = "select * from towar";
		
		List<Towar> towary = jdbcTemplate.query(query,  new TowarMapper());

		return towary;
	}
	
	private static class TowarMapper implements RowMapper<Towar> {
		public Towar mapRow(ResultSet rs, int rowNum) throws SQLException {
			Towar towar = new Towar();
			towar.setId(rs.getInt("idTowaru"));
			towar.setNazwa(rs.getString("nazwa"));
			towar.setOpis(rs.getString("opis"));
			towar.setCena(rs.getDouble("cena"));
			towar.setTyp(rs.getString("typ"));
			towar.setPojemnosc(rs.getInt("pojemnosc"));
			towar.setDostepnosc(rs.getBoolean("dostepnosc"));
		      return towar;
		}
	}

	public void usun(int id) {
		String sql = "DELETE FROM towar_transakcja WHERE idTowaru=?";
		jdbcTemplate.update(sql, id);
		
		sql = "DELETE FROM towar WHERE idTowaru=?";
		jdbcTemplate.update(sql, id);
	}

	public void dodaj(final Towar towar) {
		final String sql = "insert into towar(opis, cena,typ, pojemnosc,dostepnosc,nazwa) values (?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, towar.getOpis());
				ps.setDouble(2, towar.getCena());
				ps.setString(3, towar.getTyp());
				ps.setInt(4, towar.getPojemnosc());
				ps.setBoolean(5, true);
				ps.setString(6, towar.getNazwa());
				
				return ps;
			}
		}, keyHolder);
	}
}
