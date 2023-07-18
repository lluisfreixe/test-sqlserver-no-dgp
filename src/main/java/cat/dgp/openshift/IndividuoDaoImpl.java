package cat.dgp.openshift;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class IndividuoDaoImpl implements IndividuoDao {

	public IndividuoDaoImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;

	@Override
	public List<Individuo> findAll() {
		return template.query("select * from INDIVIDUO where ID_INDIVIDUO > 0", new IndividuoRowMapper());
	}

	@Override
	public void insertIndividuo(Individuo emp) {
		final String sql = "insert into INDIVIDUO(ID_INDIVIDUO, NOMBRE, APELLIDO, TELEFONO, CORREO, EDAD) values(:ID_INDIVIDUO, :NOMBRE, :APELLIDO, :TELEFONO, :CORREO, :EDAD)";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("ID_INDIVIDUO", emp.getID_INDIVIDUO())
				.addValue("NOMBRE", emp.getNOMBRE())
				.addValue("APELLIDO", emp.getAPELLIDO())
				.addValue("TELEFONO", emp.getTELEFONO())
				.addValue("CORREO", emp.getCORREO())
				.addValue("EDAD", emp.getEDAD());
		template.update(sql, param, holder);

	}

	@Override
	public void updateIndividuo(Individuo emp) {
		final String sql = "update INDIVIDUO set ID_INDIVIDUO=:ID_INDIVIDUO, NOMBRE=:NOMBRE, APELLIDO=:APELLIDO, TELEFONO=:TELEFONO, CORREO=:CORREO, EDAD=:EDAD, where ID_INDIVIDUO=:ID_INDIVIDUO";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("ID_INDIVIDUO", emp.getID_INDIVIDUO())
				.addValue("NOMBRE", emp.getNOMBRE())
				.addValue("APELLIDO", emp.getAPELLIDO())
				.addValue("TELEFONO", emp.getTELEFONO())
				.addValue("CORREO", emp.getCORREO())
				.addValue("EDAD", emp.getEDAD());
		template.update(sql, param, holder);

	}

	@Override
	public void executeUpdateIndividuo(Individuo emp) {
		final String sql = "update INDIVIDUO set ID_INDIVIDUO=:ID_INDIVIDUO, NOMBRE=:NOMBRE, APELLIDO=:APELLIDO, TELEFONO=:TELEFONO, CORREO=:CORREO, EDAD=:EDAD where ID_INDIVIDUO=:ID_INDIVIDUO";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID_INDIVIDUO", emp.getID_INDIVIDUO());
		map.put("NOMBRE", emp.getNOMBRE());
		map.put("APELLIDO", emp.getAPELLIDO());
		map.put("TELEFONO", emp.getTELEFONO());
		map.put("CORREO", emp.getCORREO());
		map.put("EDAD", emp.getEDAD());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void deleteIndividuo(Individuo emp) {
		final String sql = "delete from INDIVIDUO where ID_INDIVIDUO=:ID_INDIVIDUO";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ID_INDIVIDUO", emp.getID_INDIVIDUO());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void deleteIndividuoAll() {
		final String sql = "delete from INDIVIDUO where ID_INDIVIDUO > 0";

		Map<String, Object> map = new HashMap<String, Object>();

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

}
