# TP2_SIR_JPA

TP portant sur l'utilisation de JPA avec le framework Hibernate.
<br/>Il s'agit :
- De créer des Beans.
- De gérer la persistance des classes en utilisant des annotations adéquates (@Id, @GeneratedValue, @OneToMany, @ManyToMany, @ManyToOne, ...)
- De comprendre comment les annotations sur le mapping changent la structure de la base de données créée.
- D'utiliser hibernate avec une base de donnée HSQLDB puis une base MySQL pour se convaincre que le framework permet de travailler avec différents types de bases de données.

## Exécuter le TP sur une base de données HSQLDB
1. Exécuter run-hsqldb-server.sh
2. Exécuter run.sh
3. Exécuter show-hsqldb.sh -> Dans l'interface graphique qui apparaît, remplacer la valeur du champ URL par "jdbc:hsqldb:hsql://localhost/" sans les guillemets.
