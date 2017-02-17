package pk.apteka.jo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pk.apteka.jo.domain.TowarTransakcja;

@Repository
public class TowarTransakcjaDao {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<TowarTransakcja> showAll(){
		
		return null;
	}
}
