package paquete_reto3.spring11.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

// import lombok.AllArgsConstructor;
// //import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;



//@Getter @Setter @AllArgsConstructor @NoArgsConstructor //estos getter en maquina virtual no hay como llamar la libreria
//@Data

@Entity
@Table(name = "client") //crea tabla y base de datos(schema)
public class Cliente implements Serializable {

    @Id //  clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // autoincremento
    @Column(length = 4)
    private Integer idclient;

    @Column(length = 250)
    private String  name;

    @Column(length = 45)
    private String  email;

    @Column(length = 45)
    private String password;

    @Column(length = 4)
    private Integer  age;

//**************************************************************** */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")//mapeams con la instancia que tenemos en el otro
    @JsonIgnoreProperties("client")//ignoramos la instancia creada con ralacionada
    public List<Mensaje> messages; //me trae

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")//mapeams con la instancia que tenemos en el otro
    @JsonIgnoreProperties("client")//ignoramos la instancia creada con ralacionada
    public List<Reserva> reservations; //me trae
    //*********************************************************************************** */

    public Cliente() {
    }

    public Cliente(Integer idclient, String name, String email, String password, Integer age, List<Mensaje> messages,
            List<Reserva> reservations) {
        this.idclient = idclient;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }

   
}