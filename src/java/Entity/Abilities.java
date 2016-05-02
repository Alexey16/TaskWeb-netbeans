/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Алексей
 */
@Entity
@Table(name = "abilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abilities.findAll", query = "SELECT a FROM Abilities a"),
    @NamedQuery(name = "Abilities.findByIdAbility", query = "SELECT a FROM Abilities a WHERE a.idAbility = :idAbility"),
    @NamedQuery(name = "Abilities.findByName", query = "SELECT a FROM Abilities a WHERE a.name = :name"),
    @NamedQuery(name = "Abilities.findByRestrictions", query = "SELECT a FROM Abilities a WHERE a.restrictions = :restrictions")})
public class Abilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ability")
    private Integer idAbility;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "restrictions")
    private String restrictions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abilities")
    private List<HeroicAbilities> heroicAbilitiesList;

    public Abilities() {
    }

    public Abilities(Integer idAbility) {
        this.idAbility = idAbility;
    }

    public Abilities(Integer idAbility, String name) {
        this.idAbility = idAbility;
        this.name = name;
    }

    public Integer getIdAbility() {
        return idAbility;
    }

    public void setIdAbility(Integer idAbility) {
        this.idAbility = idAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @XmlTransient
    public List<HeroicAbilities> getHeroicAbilitiesList() {
        return heroicAbilitiesList;
    }

    public void setHeroicAbilitiesList(List<HeroicAbilities> heroicAbilitiesList) {
        this.heroicAbilitiesList = heroicAbilitiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbility != null ? idAbility.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abilities)) {
            return false;
        }
        Abilities other = (Abilities) object;
        if ((this.idAbility == null && other.idAbility != null) || (this.idAbility != null && !this.idAbility.equals(other.idAbility))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Abilities[ idAbility=" + idAbility + " ]";
    }
    
}
