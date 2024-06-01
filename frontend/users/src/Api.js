const BACKEND_URL =
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8765/USER-MANAGEMENT-SERVICE";

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


export async function fetchSavedFlights(id, token) {
  return sendRequest(BACKEND_URL + `/users/${id}/flights`, {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function fetchSavedHotels(id, token) {
  return sendRequest(BACKEND_URL + `/users/${id}/hotels`, {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function fetchSavedCarRentals(id, token) {
  return sendRequest(BACKEND_URL + `/users/${id}/carRentals`, {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function fetchSavedRecentSearches(id, token) {
  return sendRequest(BACKEND_URL + `/users/${id}/recentSearches`, {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function removeRentedCar(userId, carRentalId, token) {
  return sendRequest(BACKEND_URL + `/users/${userId}/rentals/${carRentalId}`, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function removeBookedHotel(userId, hotelId, token) {
  return sendRequest(BACKEND_URL + `/users/${userId}/hotels/${hotelId}`, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function removeBookedFlight(userId, flightId, token) {
  return sendRequest(BACKEND_URL + `/users/${userId}/flights/${flightId}`, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function removeSearch(userId, searchId, token) {
  return sendRequest(BACKEND_URL + `/users/${userId}/searches/${searchId}`, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function changeUsername(oldUsername, newUsername, token) {
  return sendRequest(BACKEND_URL + '/users/username', {
    method: 'PUT',
    body: { oldUsername, newUsername },
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}
