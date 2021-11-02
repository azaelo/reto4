package paquete_reto3.spring11.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Table(name = "messages") //crea tabla y base de datos(schema)
public class Mensaje implements Serializable {    //implements Serializable

    @Id //  clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // autoincremento
    @Column(length = 4)
    private Integer idmessage;

    @Column(length = 250)
    private String  messagetext;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    @JsonIgnoreProperties({"messages","reservations","client"})//ignoramos todas las instancias de la clase 
    private Cliente client;
    // @Column(length = 4)
    // private Integer  id_cliente;

    @ManyToOne
    @JoinColumn(name="id_costume")
    @JsonIgnoreProperties({"messages","reservations"})//ignoramos todas las instancias de la clase 
    private Disfraz costume;
    
    //**************************************************************************************************** */
    
    public Integer getIdmessage() {
        return idmessage;
    }

    public Mensaje(Integer idmessage, String messagetext, Cliente client, Disfraz costume) {
        this.idmessage = idmessage;
        this.messagetext = messagetext;
        this.client = client;
        this.costume = costume;
    }

    public Mensaje() {
    }

    public void setIdmessage(Integer idmessage) {
        this.idmessage = idmessage;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Disfraz getCostume() {
        return costume;
    }

    public void setCostume(Disfraz costume) {
        this.costume = costume;
    }

        

}