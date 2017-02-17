package pk.apteka.jo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SamochodDao {
	//
	
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		//jdbcTemplate.update("CREATE TABLE IF NOT EXISTS samochody(id INTEGER PRIMARY KEY AUTOINCREMENT, marka varchar, model varchar)");
	}
	
	public List<Samochod> query() {
		System.out.println("krokodyl query");
		return jdbcTemplate.query("SELECT id,marka, model From samochody", new RowMapper<Samochod>() {

			@Override
			public Samochod mapRow(ResultSet arg0, int arg1) throws SQLException {
				Samochod s = new Samochod();
				s.setId(arg0.getInt("id"));
				s.setMarka(arg0.getString("marka"));
				s.setModel(arg0.getString("model"));
				return s;
			}
			
		});
	}
	
	public void insert(Samochod s) {
		jdbcTemplate.update("INSERT INTO samochody(marka,model) VALUES(?,?)", new Object[]{s.getMarka(),s.getModel()});
	}

	public List<Samochod> showAll() {
		String query = "select * from samochody";
		
		List<Samochod> samochody = jdbcTemplate.query(query,  new SamochodMapper());
		
		return samochody;
	}
	
	private static class SamochodMapper implements RowMapper<Samochod> {
		public Samochod mapRow(ResultSet rs, int rowNum) throws SQLException {
			Samochod samochod = new Samochod();
			samochod.setId(rs.getInt("id"));
			samochod.setMarka(rs.getString("marka"));
			samochod.setModel(rs.getString("model"));
		      return samochod;
		}
	}
	
	
}
