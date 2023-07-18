package cat.dgp.openshift;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "INDIVIDUO")
public class Individuo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_INDIVIDUO;
	private String NOMBRE;
	private String APELLIDO;
	private String TELEFONO;
	private String CORREO;
	private int EDAD;
	
	public Individuo() {
		super();
	}

	public int getID_INDIVIDUO() {
		return ID_INDIVIDUO;
	}

	public void setID_INDIVIDUO(int iD_INDIVIDUO) {
		ID_INDIVIDUO = iD_INDIVIDUO;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	public String getAPELLIDO() {
		return APELLIDO;
	}

	public void setAPELLIDO(String aPELLIDO) {
		APELLIDO = aPELLIDO;
	}

	public String getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}

	public String getCORREO() {
		return CORREO;
	}

	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}

	public int getEDAD() {
		return EDAD;
	}

	public void setEDAD(int eDAD) {
		EDAD = eDAD;
	}

	
	
}
