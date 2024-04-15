package app.vercel.lakshyasinghgg.movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;
@RestController
@RequestMapping("/api/v1/reviews")

public class ReviewController {
    // As Review form will be inside the movies details page
    // So we can make the request to the movies ENDPOINT instead of creating a new endpoint
    @Autowired
    private ReviewService service;

    @PostMapping()

    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        // what we are saying to the framework here is that what info we get as the requestBody
        // we would like to convert it to a map of the key string and value string
        // and name this map as payload

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);

    }

}
