import React, { lazy } from "react";
import { useLocation } from "react-router-dom";

const TableOfHotels = lazy(() =>
  import("hotels/TableOfHotels").catch(() => ({
    default: () => <div>This service are temporarily down</div>,
  }))
);
const TableOfCars = lazy(() =>
  import("carRentals/TableOfCars").catch(() => ({
    default: () => <div>This service are temporarily down</div>,
  }))
);
const TableOfItems = lazy(() =>
  import("flights/TableOfItems").catch(() => ({
    default: () => <div>This service are temporarily down</div>,
  }))
);

function ParentComponent({ userLoggedData }) {
  const { token, userId } = userLoggedData;
  const location = useLocation();
  const { flightResults, hotelResults, carRentalResults } = location.state;
  console.log(carRentalResults);
  return (
    <div className="tt">
      <h1
        style={{
          fontSize: "2.5em",
          fontFamily: "Oswald",
          marginBottom: "20px",
        }}
      >
        Flights
      </h1>
      <div style={{ marginBottom: "20px" }}>
        <div className="yy">
          {flightResults.body ? (
            <TableOfItems
              rows={flightResults.body}
              userLoggedData={userLoggedData}
            />
          ) : (
            <div>This service is temporarily down</div>
          )}
        </div>
      </div>

      <hr
        style={{
          borderTop: "2px solid #888",
          width: "80%",
          marginTop: "4rem",
          marginLeft: "auto",
          marginRight: "auto",
          marginBottom: "4rem",
          zIndex: "1",
          position: "relative",
        }}
      />

      <h1
        style={{
          fontSize: "2.5em",
          fontFamily: "Oswald",
          marginBottom: "20px",
        }}
      >
        See also Hotels
      </h1>
      <div style={{ marginBottom: "20px" }}>
        {hotelResults.body ? (
          <TableOfHotels
            rows={hotelResults.body}
            userLoggedData={userLoggedData}
          />
        ) : (
          <div>This service is temporarily down</div>
        )}
      </div>

      <hr
        style={{
          borderTop: "2px solid #888",
          width: "80%",
          marginTop: "4rem",
          marginLeft: "auto",
          marginRight: "auto",
          marginBottom: "4rem",
          zIndex: "1",
          position: "relative",
        }}
      />

      <h1
        style={{
          fontSize: "2.5em",
          fontFamily: "Oswald",
          marginBottom: "20px",
        }}
      >
        See also Cars
      </h1>
      <div>
        {carRentalResults.body ? (
          <TableOfCars
            rows={carRentalResults.body}
            userLoggedData={userLoggedData}
          />
        ) : (
          <div>This service is temporarily down</div>
        )}
      </div>
    </div>
  );
}

export default ParentComponent;
