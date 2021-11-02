package paquete_reto3.spring11.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;



//@Getter @Setter @AllArgsConstructor @NoArgsConstructor //estos getter en maquina virtual no hay como llamar la libreria
//@Data

@Entity
@Table(name = "datos_admin") //crea tabla y base de datos(schema)
public class Administradores {

    @Id //  clave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY) // autoincremento
    @Column(length = 4)
    private Integer id_admin;

    @Column(length = 250)
    private String  admin_name;

    @Column(length = 45)
    private String  admin_mail;

    @Column(length = 45)
    private String admin_password;

    // public Administradores() {
    // }

    // public Administradores(Integer id_admin, String admin_name, String admin_mail, String admin_password) {
    //     this.id_admin = id_admin;
    //     this.admin_name = admin_name;
    //     this.admin_mail = admin_mail;
    //     this.admin_password = admin_password;
    // }

    public Integer getId_admin() {
        return id_admin;
    }

    public Administradores(Integer id_admin, String admin_name, String admin_mail, String admin_password) {
        this.id_admin = id_admin;
        this.admin_name = admin_name;
        this.admin_mail = admin_mail;
        this.admin_password = admin_password;
    }

    public Administradores() {
    }

    public void setId_admin(Integer id_admin) {
        this.id_admin = id_admin;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_mail() {
        return admin_mail;
    }

    public void setAdmin_mail(String admin_mail) {
        this.admin_mail = admin_mail;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

}