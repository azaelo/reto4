package paquete_reto3.spring11.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Table(name = "costumes") //crea tabla y base de datos(schema)
public class Disfraz implements Serializable {

    @Id //  clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // autoincremento
    @Column(length = 4)
    private Integer id;

    @Column(length = 45)
    private String  name;

    @Column(length = 45)
    private String  brand;

    @Column(length = 4)
    private Integer year;

    @Column(length = 250)
    private String  description;
    //columna foranea categoria (en disfraz)
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("costumes")//ignoramos todas las instancias de la clase 
    private Categoria category; //instanciamos la entidad relacionada
    //compartimos nuestras columnas 
//**************************************************++ */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "costume") //
    @JsonIgnoreProperties({"costume", "client"})//ignoramos la instancia creada con ralacionada
    public List<Mensaje> messages; //me trae

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "costume")//mapeams con la instancia que tenemos en el otro
    @JsonIgnoreProperties("costume")//ignoramos la instancia creada con ralacionada
    public List<Reserva> reservations; //me trae

//******************************************************************************************* */
    
   public Disfraz() {
    }

public Disfraz(Integer id, String name, String brand, Integer year, String description, Categoria category,
        List<Mensaje> messages, List<Reserva> reservations) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.year = year;
    this.description = description;
    this.category = category;
    this.messages = messages;
    this.reservations = reservations;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getBrand() {
    return brand;
}

public void setBrand(String brand) {
    this.brand = brand;
}

public Integer getYear() {
    return year;
}

public void setYear(Integer year) {
    this.year = year;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public Categoria getCategory() {
    return category;
}

public void setCategory(Categoria category) {
    this.category = category;
}

public List<Mensaje> getMessages() {
    return messages;
}

public void setMessages(List<Mensaje> messages) {
    this.messages = messages;
}

public List<Reserva> getReservations() {
    return reservations;
}

public void setReservations(List<Reserva> reservations) {
    this.reservations = reservations;
}

    
}