package apap.tutorial.cineplux.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "penjaga")
@JsonIgnoreProperties(value = {"bioskop"}, allowSetters = true)
public class PenjagaModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noPenjaga;

    @NotNull
    @Size(max = 30)
    @Column(nullable = false)
    private String namaPenjaga;

    @NotNull
    @Column(nullable = false)
    private Integer jenisKelamin;

    private String umur;

    public Long getNoPenjaga() {
        return noPenjaga;
    }

    public void setNoPenjaga(Long noPenjaga) {
        this.noPenjaga = noPenjaga;
    }

    public String getNamaPenjaga() {
        return namaPenjaga;
    }

    public void setNamaPenjaga(String namaPenjaga) {
        this.namaPenjaga = namaPenjaga;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public BioskopModel getBioskop() {
        return bioskop;
    }

    public void setBioskop(BioskopModel bioskop) {
        this.bioskop = bioskop;
    }

    //Relasi dengan BioskopModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "no_bioskop", referencedColumnName = "noBioskop", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BioskopModel bioskop;
}
