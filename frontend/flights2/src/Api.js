const BACKEND_URL =
  process.env.REACT_APP_BACKEND_URL ||
  "http://localhost:8765/CRITERIA-BASED-SEARCH-SERVICE";
const FILTERING_SORTING_URL =
  process.env.FILTERING_SORTING_SERVICE ||
  "http://localhost:8765/FILTERING-SORTING-SERVICE";

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

export async function addFlight(flight, userId, token) {
  return sendRequest(BACKEND_URL + `/flights/publish`, {
    method: "POST",
    headers: {
      Authorization: `Bearer ${token}`,
    },
    body: {
      ...flight,
      userId,
    },
  }).then((response) => response);
}

export async function filterFlights(flights, maxPrice) {
  const url = new URL(FILTERING_SORTING_URL + `/filteringFlights`);

  if (maxPrice !== undefined) url.searchParams.append("maxPrice", maxPrice);

  return sendRequest(url, {
    method: "POST",
    body: flights,
  }).then((response) => response);
}

export async function sortFlights(flights, sortField, sortOrder) {
  const url = new URL(FILTERING_SORTING_URL + `/sortFlights`);

  if (sortField !== undefined) url.searchParams.append("sortBy", sortField);
  if (sortOrder !== undefined) url.searchParams.append("sortOrder", sortOrder);
  console.log("jcwkjdc" + sortField);
  console.log(sortOrder);

  return sendRequest(url, {
    method: "POST",
    body: flights,
  }).then((response) => response);
}
