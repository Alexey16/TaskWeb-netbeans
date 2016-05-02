/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Abilities;
import Entity.HeroicAbilities;
import Entity.Universes;
import Entity.Heroes;
import java.util.List;

/**
 *
 * @author Alexey
 */
public class projectmanager {
    public static void main(String[] args) {
        
       
        
        AbilitiesDAO adao = new AbilitiesDAO();
        HeroesDAO hdao = new HeroesDAO();
        UniversesDAO udao = new UniversesDAO();
        HeroicAbilitiesDAO hadao = new HeroicAbilitiesDAO();
        
       
        
        List<Abilities> as = adao.findAll();
        List<Heroes> hs = hdao.findAll();
        List<Universes> us = udao.findAll();
        List<HeroicAbilities> has = hadao.findAll();
        
    }
}
