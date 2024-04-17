# Backend


### Overview of Components

1. **Domain Models (`Movie` and `Review` classes)**
2. **Data Access Layer (`MovieRepository` and `ReviewRepository` interfaces)**
3. **Service Layer (`MovieService` and `ReviewService` classes)**
4. **Controller Layer (`MovieController` and `ReviewController` classes)**
5. **Main Application Class (`MoviesApplication`)**
6. **Unit Tests (`MoviesApplicationTests`)**

### Domain Models

#### `Movie.java`
- **Purpose**: Represents the movie entity with attributes like ID, title, release date, and associated reviews.
- **Key Features**:
  - Annotated with `@Document`, indicating it's a MongoDB collection.
  - Uses Lombok annotations (`@Data`, `@AllArgsConstructor`, `@NoArgsConstructor`) to simplify boilerplate code like getters, setters, and constructors.
  - Links to the `Review` model via a list of reviews, illustrating an embedded relationship in MongoDB.

#### `Review.java`
- **Purpose**: Represents the review entity associated with movies.
- **Key Features**:
  - Similar annotations for MongoDB and Lombok usage.
  - Contains attributes such as the review text and timestamps for creation and updates.

### Data Access Layer

#### `MovieRepository` and `ReviewRepository`
- **Functionality**: Interface extending `MongoRepository`, providing CRUD operations and custom queries like finding a movie by its IMDb ID.
- **Integration**: These repositories abstract the database interactions, making it easier to perform data operations without needing to manage MongoDB queries directly.

### Service Layer

#### `MovieService` and `ReviewService`
- **Role**: Contains business logic and interacts with the repositories to fetch, manipulate, or store data.
- **Examples**:
  - `MovieService` fetches all movies or a specific movie by IMDb ID.
  - `ReviewService` handles the creation of reviews and updates the movie information to include the new review, demonstrating a typical use case of transactional operations and database interaction.

### Controller Layer

#### `MovieController` and `ReviewController`
- **Purpose**: Handle HTTP requests and responses, bridging the HTTP interface with the service layer.
- **Functionality**:
  - `MovieController` maps routes like GET requests for fetching movies and provides endpoints to interact with movie data.
  - `ReviewController` deals with POST requests for submitting new reviews, showcasing how data received from the front end (in JSON format) is processed and stored.

### Main Application Class

#### `MoviesApplication.java`
- **Function**: The entry point for the Spring Boot application, responsible for bootstrapping the application setup, including configuration and server start-up.

### Unit Tests

#### `MoviesApplicationTests`
- **Purpose**: Provides a basic structure for writing tests to ensure the application context loads correctly and can be extended to include more comprehensive tests covering business logic and integrations.

### How the Components Interact

- **Flow of Control**:
  1. **HTTP Request Handling**: Requests come into the system through controllers (`MovieController` and `ReviewController`).
  2. **Service Layer Interaction**: Controllers delegate business operations to the services (`MovieService` and `ReviewService`), which contain the core logic.
  3. **Data Access**: Services use repositories (`MovieRepository` and `ReviewRepository`) to interact with the database.
  4. **Response Generation**: Services return data back to controllers, which then format and send HTTP responses to the client.

- **Data Management**: The `Movie` and `Review` classes represent the data structure. Repositories manage these entities in the database, services orchestrate the logic and transactions, and controllers handle client-server communication.

This architecture ensures separation of concerns, modular development, ease of maintenance, and scalability. Each layer has a specific role, making the system robust yet flexible enough to handle changes or enhancements.
