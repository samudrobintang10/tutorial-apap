package apap.tutorial.cineplux.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "film")
public class FilmModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noFilm;

    @NotNull
    @Size(max = 30)
    @Column(nullable = false)
    private String namaFilm;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String deskripsiFilm;

    @NotNull
    @Column(nullable = false)
    private Boolean isDisplaying;

    //Relasi dengan BioskopModel
    @ManyToMany(mappedBy = "listFilm")
    List<BioskopModel> listBioskop;

    public Long getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(Long noFilm) {
        this.noFilm = noFilm;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public String getDeskripsiFilm() {
        return deskripsiFilm;
    }

    public void setDeskripsiFilm(String deskripsiFilm) {
        this.deskripsiFilm = deskripsiFilm;
    }

    public Boolean getDisplaying() {
        return isDisplaying;
    }

    public void setDisplaying(Boolean displaying) {
        isDisplaying = displaying;
    }

    public List<BioskopModel> getListBioskop() {
        return listBioskop;
    }

    public void setListBioskop(List<BioskopModel> listBioskop) {
        this.listBioskop = listBioskop;
    }
}
