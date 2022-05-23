SERIALIZARE, HASH-MAP


Aceasta aplicatie a avut ca scop crearea unui proiect tip java care sa simuleze un sistem al unui restaurant, cu optiunea de a plasa comenzi online de catre un client.
Aplicatia are un meniu (initial importat din fila "Products.csv") din care clientul poate alege, dar adminul poate modifica, sterge sau adauga produse in meniu,
poate crea produse compuse, asa numitele Daily Menu(Un produs alcatuit din mai multe produse deja exiztente), importa produsele din fila "Products.csv" sau poate genera
raporturi, cu diferite teme, acestea au ca scop o analiza introspectiva asupra restaurantului si poate include clientii cei mai fidele, produsele cele mai comandate, etc.
intr-o anumita data si cu interval orar specificat.
Aplicatia consolideaza 2 use-caseuri
  * Admin -> acest user type dupa logare poate adauga, modifica sau sterge produsele din meniu
          -> poate genera raporturi pe diferite criterii specificate in sectiunea respectiva
          -> poate importa produse din fila "Products.csv"
          -> gestionarea produselor compuse( daily menus). Poate crea daiy menus cu maxim 4 produse intr-un meniu sau poate sterge din produsele deja existente
  * Client -> se poate loga, sau daca nu exista deja cont pentru acesta, isi poate crea un cont nou
           -> poate adauga in cosul sau produse simple sau compuse (daily menu)
           -> poate sterge produse din cos
           -> poate plasa comenzi
           -> poate filtra produsele simple in functie de diverse criterii (nume, rating, pret, sodiu, grasimi, etc...)

Acest proiect a folosit serializarea pentru crearea conturilor si nu numai. In pachetul "data", clasa Serializator se ocupa cu serializarea cat si deserealizarea tuturor obiectelor necesare.
Pachetul "business" contine toate clasele care se ocupa de produse si actiunile acestora (BaseProduct,MenuItem, Order etc...).
Cele doua pachete cu terminatia .view contin toate clasele necesare celor 2 tipuri specifice de GUI.
Pachetul "model" contine 2 clase care specifica caracteristicele celor 2 obiecte de tip user, client si admin.
PAchetul "gui_pack" contine clasele de tip GUI care nu se incadreaza in specificul celor de tip .view cum ar fi clasa StartGui sau FailWindow
Pachetul "default_pack" contine MainClass-ul clasa care initializeaza toata actiunea aplicatiei dupa crearea a doua conturi, unul de tip admin, altul de tip client. 