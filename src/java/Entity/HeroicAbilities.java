/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Алексей
 */
@Entity
@Table(name = "heroic_abilities")
public class HeroicAbilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hab")
    private Integer idHab;
    @Column(name = "specific_features")
    private String specificFeatures;
    @JoinColumn(name = "id_hero", referencedColumnName = "id_hero")
    @ManyToOne(optional = false)
    private Heroes heroes;
    @JoinColumn(name = "id_ability", referencedColumnName = "id_ability")
    @ManyToOne(optional = false)
    private Abilities abilities;

    public HeroicAbilities() {
    }
    
    public HeroicAbilities(Integer idHab){
        this.idHab = idHab;
    }
    
    public Integer getIdHab() {
        return idHab;
    }

    public void setIdHab(Integer idHero) {
        this.idHab = idHab;
    }

    public String getSpecificFeatures() {
        return specificFeatures;
    }

    public void setSpecificFeatures(String specificFeatures) {
        this.specificFeatures = specificFeatures;
    }

    public Heroes getHeroes() {
        return heroes;
    }

    public void setHeroes(Heroes heroes) {
        this.heroes = heroes;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }
    
}
