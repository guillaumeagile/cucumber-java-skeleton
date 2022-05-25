# language: fr
Fonctionnalité: verification des cas des chevauchement des plages de dates

  Scénario: la 1ere plage commence avant le 2e et se fini avant
    Etant donné plusieurs plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2021-12-24 | 2022-01-01 |
    Alors les plages se chevauchent

  Scénario: la 1ere plage commence avant le 2e et se fini après
    Etant donné plusieurs plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2021-12-24 | 2022-01-04 |
    Alors les plages se chevauchent



  Scénario: les plages sont disjointes avant
    Etant donné plusieurs plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2021-12-20 | 2021-12-23 |
    # analyse les 2 lignes qui correspondent, et créer 2 objets plage de date
    Alors les plages ne se chevauchent pas

  Scénario: les plages sont disjointes après
    Etant donné plusieurs plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2022-01-04 | 2022-01-11 |
    # analyse les 2 lignes qui correspondent, et créer 2 objets plage de date
    Alors les plages ne se chevauchent pas