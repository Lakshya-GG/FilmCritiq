package app.vercel.lakshyasinghgg.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


//
//@Service
//public class ReviewService {
//
//    private ReviewRepository reviewRepository;
//
//    // Templates can also talk to the database just like Repositories
//    // there are times when the repository fails - when using complex query operations
//    // i.e. why  we are using template here
//    // which forms up a new dynamic query and do the job inside the DB without using the repository
//    private MongoTemplate mongoTemplate;
//    public Review createReview(String reviewBody, String imdbId) {
//        Review review = reviewRepository.insert(new Review(reviewBody));
//
//
//        // Using template to perform update call on the Movie Class
//        // As each movie in our collection contains an empty array of review ids
//        // So we need to update this array and push the new reviewIDs into this
//        mongoTemplate.update(Movie.class)
//                .matching(Criteria.where("imdbId").is(imdbId)) // matches the imdbId in the DATABASE with the one given by the USER
//                .apply(new Update().push("reviewIds").value(review)) // Updates the reviewIds -> push it into the reviewIDs array
//                .first();  // make sure that we are getting a single movie, and updating it.
//
//        return review;
//
//    };
//}

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    // Using template to perform update call on the Movie Class
    // As each movie in our collection contains an empty array of review ids
    // So we need to update this array and push the new reviewIDs into this

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId)) // matches the imdbId in the DATABASE with the one given by the USER
                    .apply(new Update().push("reviewIds").value(review)) // Updates the reviewIds -> push it into the reviewIDs array
                    .first(); // make sure that we are getting a single movie, and updating it.
        return review;
    }
}
