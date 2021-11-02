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
import javax.persistence.OneToMany;


@Entity
@Table(name = "category") //crea tabla y base de datos(schema)
public class Categoria implements Serializable {

    @Id //  clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // autoincremento
    @Column(length = 4)
    private Integer id;

    @Column(length = 45)
    private String  name;

    @Column(length = 250)
    private String  description;
    //***************************************************************************************************** */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")//ignoramos la instancia creada con ralacionada
    private List<Disfraz> costumes;
    //************************************************************************************************ */
    
    
    public Integer getId() {
        return id;
    }
    public Categoria(Integer id, String name, String description, List<Disfraz> costumes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.costumes = costumes;
    }
    public Categoria() {
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Disfraz> getCostumes() {
        return costumes;
    }
    public void setCostumes(List<Disfraz> costumes) {
        this.costumes = costumes;
    }
    

}