const BACKEND_URL =
  process.env.REACT_APP_BACKEND_URL ||
  "http://localhost:8765/HOTEL-SEARCH-SERVICE";

const FILTERING_SORTING_URL =
  process.env.FILTERING_SORTING_SERVICE ||
  "http://localhost:8765/FILTERING-SORTING-SERVICE";

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
      return jsonOrTextPromise.then((body) => ({ status: res.status, body }));
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

export async function addHotel(hotel, userId, token) {
  return sendRequest(BACKEND_URL + `/hotel/publishHotel`, {
    method: "POST",
    headers: {
      Authorization: `Bearer ${token}`,
    },
    body: {
      ...hotel,
      userId,
    },
  }).then((response) => response);
}

export async function filterHotels(hotels, minPrice, starRating) {
  const url = new URL(FILTERING_SORTING_URL + `/filtering`);
  if (minPrice !== undefined) url.searchParams.append("minPrice", minPrice);
  if (starRating !== undefined)
    url.searchParams.append("starRating", starRating);

  return sendRequest(url, {
    method: "POST",
    body: hotels,
  }).then((response) => response);
}

export async function sortHotels(hotels, sortField, sortOrder) {
  const url = new URL(FILTERING_SORTING_URL + `/sortHotels`);

  // Add query parameters to the URL
  if (sortField !== undefined) url.searchParams.append("sortField", sortField);
  if (sortOrder !== undefined) url.searchParams.append("sortOrder", sortOrder);

  return sendRequest(url, {
    method: "POST",
    body: hotels,
  }).then((response) => response);
}
