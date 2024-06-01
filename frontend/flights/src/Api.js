const BACKEND_URL =
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8080";

// returns a Promise
function transformToJsonOrTextPromise(response) {
  const contentLength = response.headers.get("Content-Length");
  const contentType = response.headers.get("Content-Type");
  if (
    contentLength !== "0" &&
    contentType &&
    contentType.includes("application/json")
  ) {
    return response.json();
  } else {
    return response.text();
  }
}

async function sendRequest(url, { method = "GET", body, headers = {} }) {
  const options = {
    method,
    headers: new Headers({ "content-type": "application/json", ...headers }),
    body: body ? JSON.stringify(body) : null,
  };

  return fetch(url, options).then((res) => {
    const jsonOrTextPromise = transformToJsonOrTextPromise(res);

    if (res.ok) {
      return jsonOrTextPromise;
    } else {
      return jsonOrTextPromise.then(function (response) {
        const responseObject = {
          status: res.status,
          ok: false,
          message: typeof response === "string" ? response : response.message,
        };

        return Promise.reject(responseObject);
      });
    }
  });
  
}

export async function fetchAirports() {
    return sendRequest(BACKEND_URL + `/getAirports`, {
    }).then((response) => response);
  }
  
 export async function addFlight(flight, userId) {
    return sendRequest(BACKEND_URL + `/flights/publish`, {
      method: "POST",
      body: {
        ...flight,
        userId,
      },
      
    }).then((response) => response);
}

export async function addHotel(hotel, userId) {
  return sendRequest( `http://localhost:8082`+`/publish`, {
    method: "POST",
    body: {
      ...hotel,
      userId,
    },
  }).then((response) => response.data);
}

export async function addCarRental(carRental, userId) {
  return sendRequest( BACKEND_URL + `/carRentals/publish`, {
    method: "POST",
    body: {
      ...carRental,
      userId,
    },
  }).then((response) => response.data);
}

export async function fetchSavedFlights(id) {
  return sendRequest(`http://localhost:8083/users/${id}/flights`, {}) 
    .then((response) => response);
}

export async function fetchSavedHotels(id) {
  return sendRequest(`http://localhost:8083/users/${id}/hotels`, {}) 
    .then((response) => response);
}

export async function fetchSavedCarRentals(id) {
  return sendRequest(`http://localhost:8083/users/${id}/carRentals`, {}) 
    .then((response) => response);
}

export async function fetchSavedRecentSearches(id) {
  return sendRequest(`http://localhost:8083/users/${id}/recentSearches`, {}) 
    .then((response) => response);
}

export async function filterHotels(hotels, minPrice, starRating, reviewRating) {
  const url = new URL('http://localhost:8084/filtering');

  // Add query parameters to the URL
  if (minPrice !== undefined) url.searchParams.append('minPrice', minPrice);
  if (starRating !== undefined) url.searchParams.append('starRating', starRating);
  if (reviewRating !== undefined) url.searchParams.append('reviewRating', reviewRating);

  return sendRequest(url, {
    method: "POST",
    body: hotels,
  }).then((response) => response);
}

export async function filterCarRentals(cars, rating, transmission, seats, price) {
  const url = new URL('http://localhost:8084/filteringCar');

  // Add query parameters to the URL
  if (rating !== undefined) url.searchParams.append('rating', rating);
  if (transmission !== undefined) url.searchParams.append('transmission', transmission);
  if (seats !== undefined) url.searchParams.append('seats', seats);
  if (price !== undefined) url.searchParams.append('price', price);

  return sendRequest(url, {
    method: "POST",
    body: cars,
  }).then((response) => response);
}

export async function filterFlights(flights, maxPrice, maxDuration) {
  const url = new URL('http://localhost:8084/filteringFlights');

  // Add query parameters to the URL
  if (maxPrice !== undefined) url.searchParams.append('maxPrice', maxPrice);
  if (maxDuration !== undefined) url.searchParams.append('maxDuration', maxDuration);

  return sendRequest(url, {
    method: "POST",
    body: flights,
  }).then((response) => response);
}

export async function sortCars(cars, sort) {
  const url = new URL('http://localhost:8084/sortCar');

  // Add query parameters to the URL
  if (sort !== undefined) url.searchParams.append('sort', sort);

  return sendRequest(url, {
    method: "POST",
    body: cars,
  }).then((response) => response);
}

export async function sortHotels(hotels, sortField, sortOrder) {
  const url = new URL('http://localhost:8084/sortHotels');

  // Add query parameters to the URL
  if (sortField !== undefined) url.searchParams.append('sortField', sortField);
  if (sortOrder !== undefined) url.searchParams.append('sortOrder', sortOrder);

  return sendRequest(url, {
    method: "POST",
    body: hotels,
  }).then((response) => response);
}

export async function sortFlights(flights, sortBy, sortOrder) {
  const url = new URL('http://localhost:8084/sortFlights');

  // Add query parameters to the URL
  if (sortBy !== undefined) url.searchParams.append('sortBy', sortBy);
  if (sortOrder !== undefined) url.searchParams.append('sortOrder', sortOrder);

  return sendRequest(url, {
    method: "POST",
    body: flights,
  }).then((response) => response);
}