/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libros.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;

/**
   *Entity class to store our books.
  * <ul>
  * <li><strong>isbn:</strong> Code that identifies the book.</li>
  * <li><strong>titulo:</strong> Name of the book. </li>
  * <li><strong>autor:</strong> Author of the book. </li>
  * <li><strong>editorial:</strong> The editorial of the book. </li>
  * <li><strong>descripcion:</strong> Description of the book. </li>
  * <li><strong>fechaPublicacion:</strong> Book release date </li>
  * <li><strong>precio:</strong> Price of the book. </li>
  * <li><strong>stock:</strong> Number of books available. </li>
  * <li><strong>genero:</strong> {@link Gender } of the book.  </li>
  * </ul>
 * @author Discos S.L Corporation
 */
@Entity
@Table(name="book",schema="LibrosSL")
@NamedQueries({
    @NamedQuery(
        name="findAllLibros",
        query="Select s from Book s"
    ),
    @NamedQuery(
        name="findLibrosContainsIsbn",
         query="Select s from Book s where s.isbn= : isbn" 
    ),
     @NamedQuery(
        name="findLibrosByTitulo",
         query="Select s from Book s where s.titulo= : titulo"
    ),
    @NamedQuery(
        name="findLibrosByAutor",
        query="Select s from Book s where s.autor = : autor"
    )
})

@XmlRootElement

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private String descripcion;
    @Past
    private Date fechaPublicacion;
    private Float precio;
    private Integer stock;
    @ManyToOne
    private Gender genero;


     public String getIsbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libros.entity.Book[ isbn=" + isbn + " ]";
    }
    
}
