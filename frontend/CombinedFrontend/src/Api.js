const BACKEND_URL =
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8765/CRITERIA-BASED-SEARCH-SERVICE";

  const userManagementUrl = process.env.REACT_APP_USER_MANAGEMENT_URL || "http://localhost:8765/USER-MANAGEMENT-SERVICE";
  const hotelUrl = process.env.REACT_APP_HOTEL_URL || "http://localhost:8765/HOTEL-SEARCH-SERVICE";


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

export async function getAllUsers(token) {
  return sendRequest(userManagementUrl + '/users', {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function sendMail(email, text, token) {
  const url = new URL(userManagementUrl + `/sendMail`);
  url.searchParams.append('email', email);
  url.searchParams.append('text', text);

  return sendRequest(url, {
    method: "POST",
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function getMessages(token) {
  const url = new URL(userManagementUrl + `/messages`);

  return sendRequest(url, {
    method: "GET",
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function addMessage(contactUs, token) {
  const url = new URL(userManagementUrl + `/addMessage`);

  return sendRequest(url, {
    method: "POST",
    body: contactUs,
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}

export async function fetchAirports(token) {
  const url = new URL(BACKEND_URL + `/getAirports`);

  return sendRequest(url, {
    method: "GET",
    headers: {
      'Authorization': `Bearer ${token}`
    }
  }).then((response) => response);
}


export async function registerUser(registerRequest) {
  return sendRequest(userManagementUrl + `/auth/register`, {
      method: "POST",
      body: registerRequest,
  }).then((response) => response);
}

export async function authenticateUser(authenticationRequest) {
  return sendRequest(userManagementUrl + `/auth/authenticate`, {
      method: "POST",
      body: authenticationRequest,
  }).then((response) => response);
}


export async function publishAirport(newCountry, token) {
  return sendRequest(userManagementUrl + '/publishAirport', {
      method: 'POST',
      body: newCountry,
      headers: {
        'Authorization': `Bearer ${token}`
      }
  }).then(response => response.data);
}

export async function removeAirport(iataCode, token) {
  return sendRequest(userManagementUrl + '/removeAirport/' + iataCode, {
      method: 'DELETE',
      headers: {
        'Authorization': `Bearer ${token}`
      }
  }).then(response => response);
}



export async function getFlightResults(formData, token){
  console.log(token)
  return sendRequest(BACKEND_URL+ `/flights/aggregateData`, {
    method: "POST",
    headers: {
      'Authorization': `Bearer ${token}`
    },
    body: formData
  }).then((response) => response);
}


export async function markAllMessagesAsRead(token) {
  return sendRequest(userManagementUrl + '/contactus/markAllAsRead', {
    method: 'PUT',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}

export async function deleteMessage(id, token) {
  return sendRequest(userManagementUrl + '/contactus/' + id, {
    method: 'DELETE',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}

export async function getMostSearchedDestinations(token) {
  return sendRequest(userManagementUrl + '/searches/top-destinations', {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}

export async function getNumberOfCarRentals(token) {
  return sendRequest(userManagementUrl + '/car-rentals/count', {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}

export async function getNumberOfHotels(token) {
  return sendRequest(userManagementUrl + '/hotels/count', {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}

export async function getNumberOfFlights(token) {
  return sendRequest(userManagementUrl + '/flights/count', {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
}

export async function getHotelResults(formData, token){
  return sendRequest(hotelUrl+ `/hotel/aggregateData`, {
    method: "POST",
    headers: {
      'Authorization': `Bearer ${token}`
    },
    body: formData
  }).then((response) => response);
}

export async function getCarRentalResults(formData, token){
  return sendRequest(BACKEND_URL+ `/carRentals/aggregateData`, {
    method: "POST",
    headers: {
      'Authorization': `Bearer ${token}`
    },
    body: formData
  }).then((response) => response);
}

export async function saveRecentSearch(search, token, userId){
  return sendRequest(BACKEND_URL+ `/publish`, {
    method: "POST",
    headers: {
      'Authorization': `Bearer ${token}`
    },
    body: {
    ...search,
    userId
    }
  }).then((response) => response);
}