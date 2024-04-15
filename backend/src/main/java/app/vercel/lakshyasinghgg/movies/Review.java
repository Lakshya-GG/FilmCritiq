package app.vercel.lakshyasinghgg.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;

    // Here we have  @AllArgsConstructor @NoArgsConstructor constructor
    // but since IDs are auto generated we cannot pass IDs to this class
    // due to this, we generate a custom Constructor which only takes the BODY

    public Review(String body, LocalDateTime created, LocalDateTime updated) {
        this.body = body;
        this.created = created;
        this.updated = updated;
    }
}


