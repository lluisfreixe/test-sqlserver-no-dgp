package cat.dgp.openshift;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IndividuoRowMapper implements RowMapper<Individuo> {

	@Override
	public Individuo mapRow(ResultSet rs, int arg1) throws SQLException {
		Individuo emp = new Individuo();
		emp.setID_INDIVIDUO(rs.getInt("ID_INDIVIDUO"));
		emp.setNOMBRE(rs.getString("NOMBRE"));
		emp.setAPELLIDO(rs.getString("APELLIDO"));
		emp.setTELEFONO(rs.getString("TELEFONO"));
		emp.setCORREO(rs.getString("CORREO"));
		emp.setEDAD(rs.getInt("EDAD"));
		return emp;
	}

}
