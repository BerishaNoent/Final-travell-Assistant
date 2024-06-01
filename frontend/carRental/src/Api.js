const BACKEND_URL =
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8765/CRITERIA-BASED-SEARCH-SERVICE";
  const FILTERING_SORTING_URL = process.env.FILTERING_SORTING_SERVICE || "http://localhost:8765/FILTERING-SORTING-SERVICE";


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
      return jsonOrTextPromise.then(body => ({ status: res.status, body }));
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

export async function addCarRental(carRental, userId, token) {
  return sendRequest(BACKEND_URL + `/carRentals/publish`, {
    method: "POST",
    body: {
      ...carRental,
      userId,
    },
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}


export async function filterCarRentals(cars, rating, transmission, seats, price) {
  const url = new URL(FILTERING_SORTING_URL + `/filteringCar`);

  if (rating !== undefined) url.searchParams.append('rating', rating);
  if (transmission !== undefined) url.searchParams.append('transmission', transmission);
  if (seats !== undefined) url.searchParams.append('seats', seats);
  if (price !== undefined) url.searchParams.append('price', price);

  return sendRequest(url, {
    method: "POST",
    body: cars,
  }).then((response) => response);
}

export async function sortCars(cars, sort) {
  const url = new URL(FILTERING_SORTING_URL + `/sortCar`);

  if (sort !== undefined) url.searchParams.append('sort', sort);

  return sendRequest(url, {
    method: "POST",
    body: cars,
  }).then((response) => response);
}
