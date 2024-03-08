package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import user.bean.UserDTO;

/*
public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate;

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql,
							userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return jdbcTemplate.query(sql, 
								  new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
}
*/

//--------------------------------------
/*
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql,
							userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, 
								  new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
}
*/

//--------------------------------------

@Repository //DB와 연동
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

//	NamedParameterJdbcDaoSupport가 final 이기 때문에 override 사용 불가
//	public void setDataSource(DataSource dataSource) {}

	//따라서 생성자 or 변수명 바꿔주기
	@Autowired
	public void setDS(DataSource dataSource) {  //== <property(Set) name="dataSource" ref="dataSource" />
		setDataSource(dataSource);				//jdbcDaoSupport의 setDataSource 호출
	}
	
	@Override
	public void write(UserDTO userDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		String sql = "insert into usertable values(:name, :id, :pwd)";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, 
								  	   new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public UserDTO idCheck(String id) {
		String sql ="select * from usertable where id=?";
		
		try{
			return getJdbcTemplate().queryForObject(
					sql,
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
					id);
			
			/* 이동우 것
			Map<String,String> map = new HashMap<String,String>();
			map.put("id",id);
			
			return getNamedParameterJdbcTemplate().queryForObject(
						sql,
						map,
						new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
			*/
			
	    }catch(EmptyResultDataAccessException e) {
	    	return null;
	    }

	}

	@Override
	public void update(Map<String, String> map) {
		String sql="update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);		
	}

	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=?";
		getJdbcTemplate().update(sql, id);
	}
	
}




















