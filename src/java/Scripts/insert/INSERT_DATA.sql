INSERT INTO UNIVERSES (id_universe,title,foundation_year,type) VALUES(0,'DC',1934,'Comics')  ;

INSERT INTO UNIVERSES (id_universe,title,foundation_year,type) VALUES(1,'MARVEL',1939,'Comics');



INSERT INTO HEROES (id_hero,id_universe,age,name,gender,body_type,location) VALUES(0,0,34,'Batman','male','muscular','Gotham City');

INSERT INTO HEROES (id_hero,id_universe,age,name,gender,body_type,location) VALUES(1,1,99,'Captain America','male','muscular','New York City');

INSERT INTO HEROES (id_hero,id_universe,age,name,gender,body_type,location) VALUES(2,0,38,'Bane','male','muscular','Gotham City');

INSERT INTO HEROES (id_hero,id_universe,age,name,gender,body_type,location) VALUES(3,0,24,'Flash','male','muscular','Central City');

INSERT INTO HEROES (id_hero,id_universe,age,name,gender,body_type,location) VALUES(4,1,30,'Black Widow','female','slim','SSSR');

INSERT INTO HEROES (id_hero,id_universe,age,name,gender,body_type,location) VALUES(5,1,43,'Doctor Strange','male','muscular','New York City');



INSERT INTO ABILITIES (id_ability,name,restrictions) VALUES(0,'Money', 'So much money');

INSERT INTO ABILITIES (id_ability,name,restrictions) VALUES(1,'The limit of human','Radiation');

INSERT INTO ABILITIES (id_ability,name,restrictions) VALUES(2,'Venom','Only Bane');

INSERT INTO ABILITIES (id_ability,name,restrictions) VALUES(3,'Speed','Is close to the speed of light');

INSERT INTO ABILITIES (id_ability,name,restrictions) VALUES(4,'Long life and youth','This is Russia');

INSERT INTO ABILITIES (id_ability,name,restrictions) VALUES(5,'Magic','This is magic');







INSERT INTO HEROIC_ABILITIES (id_hab, id_hero,id_ability,specific_features) VALUES(0,0,0,'Had inherited a multi billion company') ;

INSERT INTO HEROIC_ABILITIES (id_hab, id_hero,id_ability,specific_features) VALUES(1,1,1,'Strength, agility, speed, reflexes and healing are at the zenith of natural human potential') ;

INSERT INTO HEROIC_ABILITIES (id_hab, id_hero,id_ability,specific_features) VALUES(2,2,2,'It increases his enormous physical strength steroids') ;

INSERT INTO HEROIC_ABILITIES (id_hab, id_hero,id_ability,specific_features) VALUES(3,3,3,'Speed comes after lightning strike') ;

INSERT INTO HEROIC_ABILITIES (id_hab, id_hero,id_ability,specific_features) VALUES(4,4,4,'Bio - and the psychological impact') ;

INSERT INTO HEROIC_ABILITIES (id_hab, id_hero,id_ability,specific_features) VALUES(5,5,5,'even years studying magic') ;