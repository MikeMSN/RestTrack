package mike.msn.resttac.model;


import lombok.Data;

import javax.persistence.*;

@Data()
@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRACK_ID")
    private Long id;

    private String name;

    private String description;

    private Track(){}


    public Track(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
