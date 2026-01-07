# Bibliothek

In der Datei myLibrary.dat sind Bücher gespeichert, welche binär geschrieben wurden

**Machen Sie ein Backup von der Original Datei, bevor Sie die Datei verändern!**

**Machen Sie nach jeder erfolgreichen Implementierung eines Features einen Kommit.**
> Bsp.:
> 
> commit "Read binary data into Book Collection"
> 
> commit "Writing book to binary file"
> 
> commit ...

1. **Aufgabe:** Lesen der Datei

    Im Verzeichnis Resources liegt die zu lesende Datei "myLibrary.dat".
    Der genau Aufbau der Datei wird in der Datei "books-db-format.txt" beschrieben.
    Die binäre Datei beinhaltet den Namen der Datenbank, die Anzahl der enthaltenen Bücher und natürlich die Bücher. Ein Buch hat folgende Eigenschaften:

    ```
   "Title;Publisher;ISBN10;PublishedYear;Price;Own;AuthorsCount;Authors[]"
   ```
   
    Beachten Sie, dass ein Buch mehrere Autoren haben kann!
    Speichern Sie die Informationen mittels einer vollständig gekapselten Klasse <Buch> in einer geigneten Liste.
    Die Klasse Buch ist im Projekt schon vorhanden!
    Die Klasse soll eine weitere Variable namens "age" besitzten. Hier soll das alter des Buches errechnet werden.

2. **Aufgabe:** Nur Unikate dürfen gespeichert werden

    Es sollen keine Bücher mit derselben ISBN-10 Nummer gespeichert werden und die Daten sollen nach Preis sortiert und gespeichert werden.
    Schreiben Sie dafür eine CompareTo und überdenken Sie die Liste von Punkt 1, in der Sie die Bücher gespeichert haben.

3. **Aufgabe:** Schreiben Sie in die Datei

    Am Ende der Datei soll ein Datensatzt angehängt werden. Die Anzahl der Datensätze muss sich auch ändern!!

4. **Aufgabe:** Formatierte Ausgabe
    
    Schreiben Sie eine Methode, welche die Liste der Bücher in folgendem Format ausgibt:

    ```
    Title: Things to make and do in the fourth dimension
    Publisher: Penguin
    ISBN-10: 9780141975
    Authors: [Matt Parker]
    Price: 20.0€
    Own: Yes
    Published 7 years ago.
    ----------------------------------
   ```

5. **Bonus:**
    
    Schreiben Sie eine Methode, welche die Position des Necronomicon's zurückgibt und ändern Sie den "Own"-Status auf "True".
