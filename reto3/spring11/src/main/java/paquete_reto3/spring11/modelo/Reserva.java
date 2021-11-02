package paquete_reto3.spring11.modelo;

import java.io.Serializable;
import java.sql.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "reservations") //crea tabla y base de datos(schema)
public class Reserva implements Serializable {

    @Id //  clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // autoincremento
    @Column(length = 4)
    private Integer idReservation;

    @Column()
    private Date  startDate; //current_datetimestamp() pone la hora actual

    @Column()
    private Date  devolutionDate;

    @Column(length = 45)
    private String status;

    @ManyToOne
    @JoinColumn(name="id_costume")
    @JsonIgnoreProperties({"reservations","client"})
    private Disfraz costume;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    @JsonIgnoreProperties({"reservations","messages"})//instancia de esta entidad en la otra
    private Cliente client;

    private String score;

    //****** */*************************************************************** */
    // @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "objReserva")
    // @JsonIgnoreProperties("objReserva")//ignoramos la instancia creada con ralacionada
    // public List<CalificaReserva > objCalificaReservas;
//****************************************************************************************** */

    
    public String getScore() {
        return score;
    }

    public Reserva(Integer idReservation, Date startDate, Date devolutionDate, String status, Disfraz costume,
            Cliente client, String score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.costume = costume;
        this.client = client;
        this.score = score;
    }

    public Reserva() {
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Disfraz getCostume() {
        return costume;
    }

    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

   
    

}