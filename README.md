### User Manual

#### Prerequisites
- Ensure you have Docker and Docker Compose installed on your machine. You can download and install them from the following links:
  - [Docker](https://www.docker.com/products/docker-desktop)
  - [Docker Compose](https://docs.docker.com/compose/install/)

#### Directory Structure
Ensure your project directory has the following structure:

```
/your-project
  /frontend
    /users
      Dockerfile
    /carRental
      Dockerfile
    /CombinedFrontend
      Dockerfile
    /hotel
      Dockerfile
    /flights2
      Dockerfile
  /criteria-based-search-service
    /src/main/resources/travellingassitant-a7fd18972b0b.json
  /user-management-service
    /src/main/resources/travellingassitant-a7fd18972b0b.json
  /hotel-search-service
    /src/main/resources/travellingassitant-a7fd18972b0b.json
  docker-compose.yml
```

### Steps to Run the Application

#### Step 1: Prepare and Build the Backend Services

1. **Navigate to Project Directory**

   Open your terminal or command prompt and navigate to your project directory:

   ```bash
   cd /path/to/your-project
   ```

2. **Build Docker Images for Backend Services**

For each of the backend services you have to go to their rot directory and run the following command.

   ```bash
   mvn spring-boot:build-image
   ```

   This will create Docker images for your backend services.

#### Step 2: Create and Mount Volumes

Before running the services, you need to ensure the volumes are created and, if necessary, populated with data.

1. **Create Docker Volumes**

   Run the following commands to create Docker volumes:

   ```bash
   docker volume create mongodb-data
   docker volume create mongodb-data2
   ```

2. **(Optional) Populate Volumes with Data**

  You need to run the following commands to get the volumes.

   ```bash
   docker run -d --rm --name temp_container -v mongodb-data:/volume_data alpine
   docker cp ./local_dir temp_container:/volume_data
   docker stop temp_container
   ```
 docker run -d --rm --name temp_container -v mongodb-data:/volume_data alpine
   docker cp ./local_dir temp_container:/volume_data_1
   docker stop temp_container



#### Step 3: Run the Application with Docker Compose

1. **Start All Services**

   Use Docker Compose to start all services defined in the `docker-compose.yml` file:

   ```bash
   docker-compose up
   ```


2. **Verify Services are Running**

   You can check the status of your running containers with:

   ```bash
   docker ps
   ```

   This command lists all running containers and their respective ports.

#### Step 4: Access the Services

Each frontend service is accessible via the port mappings defined in the `docker-compose.yml` file. Open your web browser and navigate to the following URLs:

- User Frontend: `http://localhost:3002`
- Car Rental Frontend: `http://localhost:3009`
- Combined Frontend: `http://localhost:3008`
- Hotel Frontend: `http://localhost:3007`
- Flight Frontend: `http://localhost:3010`

The backend services can be accessed via their respective ports as well:

- Filtering Sorting Service: `http://localhost:8084`
- Criteria Based Search Service: `http://localhost:8080`
- API Gateway: `http://localhost:8765`
- User Management Service: `http://localhost:8083`
- Hotel Search Service: `http://localhost:8081`
- Naming Server: `http://localhost:8761`

### Stopping the Services

To stop all running services, use the following command:

```bash
docker-compose down
```

This command stops and removes all containers, networks, and volumes defined in your `docker-compose.yml` file.
