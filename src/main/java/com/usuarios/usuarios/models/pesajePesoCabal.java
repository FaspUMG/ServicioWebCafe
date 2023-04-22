
package com.usuarios.usuarios.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pesaje_peso_cabal", schema="public")
public class pesajePesoCabal {
    private Integer id_peso;
    private Integer id_cuenta ;
    private String matricula;
    private String numero_licencia;
    private Integer peso_de_camion;
    private Integer peso_marcado;
    private Integer peso_cargamento;
    private String nit;

    public pesajePesoCabal(Integer id_peso, Integer id_cuenta, String matricula, String numero_licencia, Integer peso_de_camion, Integer peso_marcado, Integer peso_cargamento, String nit) {
        this.id_peso = id_peso;
        this.id_cuenta = id_cuenta;
        this.matricula = matricula;
        this.numero_licencia = numero_licencia;
        this.peso_de_camion = peso_de_camion;
        this.peso_marcado = peso_marcado;
        this.peso_cargamento = peso_cargamento;
        this.nit = nit;
    }

    public pesajePesoCabal() {
    }

   

    @Id
    @Column (name="id_peso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_peso() {
        return id_peso;
    }

    @Column (name="id_cuenta", length=13)
    public Integer getId_cuenta() {
        return id_cuenta;
    }

    @Column (name="peso_marcado")
    public Integer getPeso_marcado() {
        return peso_marcado;
    }

    @Column (name="matricula", length=13)
    public String getMatricula() {
        return matricula;
    }
    
    @Column (name="nit", length=20)
    public String getNit() {
        return nit;
    }

    @Column (name="numero_licencia", length=13)
    public String getNumero_licencia() {
        return numero_licencia;
    }

    @Column (name="peso_de_camion")
    public Integer getPeso_de_camion() {
        return peso_de_camion;
    }

    @Column (name="peso_cargamento")
    public Integer getPeso_cargamento() {
        return peso_cargamento;
    }
    
    public void setId_peso(Integer id_peso) {
        this.id_peso = id_peso;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setPeso_marcado(Integer peso_marcado) {
        this.peso_marcado = peso_marcado;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public void setPeso_de_camion(Integer peso_de_camion) {
        this.peso_de_camion = peso_de_camion;
    }

    public void setPeso_cargamento(Integer peso_cargamento) {
        this.peso_cargamento = peso_cargamento;
    }
    
}
