import { TokenProvider } from "./context/TokenContext";
import { ProtectedRoute } from "./context/PrivateRoute";
import "./index.scss";

import React, { Suspense, lazy } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ResponsiveAppBar from "./Components/Navigation";
import LandingPage from "./Components/LandingPage";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useToken } from "./context/TokenContext";

const Admin = lazy(() =>
  import("./Components/Admin").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);
const TableOfHotels = lazy(() =>
  import("hotels/TableOfHotels").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);
const HotelFlightCar = lazy(() =>
  import("./Components/HotelFlightCar").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);
const ContactUsPage = lazy(() =>
  import("./Components/ContactUsPage").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);
const LoginPage = lazy(() =>
  import("./Components/LoginPage").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);
const ProductCard = lazy(() =>
  import("./Components/ProductCard").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);

const UserManagement = lazy(() =>
  import("usermanagement/usermanagment").catch(() => ({
    default: () => <div>This service is down</div>,
  }))
);

const withToken = (Component) => {
  return (props) => {
    const userLoggedData = useToken();
    return <Component {...props} userLoggedData={userLoggedData} />;
  };
};

const AdminWithToken = withToken(Admin);
const HotelFlightCarWithToken = withToken(HotelFlightCar);
const TableOfHotelsWithToken = withToken(TableOfHotels);
const ProductCardWithToken = withToken(ProductCard);
const ContactUsPageWithToken = withToken(ContactUsPage);
const UserManagementWithToken = withToken(UserManagement);

const App = () => {
  return (
    <TokenProvider>
      <Router>
        <div id="app" className="app">
          <ResponsiveAppBar />
          <ToastContainer />
        </div>
        <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route
            path="/login"
            element={
              <Suspense fallback={<div>Loading...</div>}>
                <LoginPage />
              </Suspense>
            }
          />
          <Route
            path="/admin"
            element={
              <ProtectedRoute path="/admin">
                <Suspense fallback={<div>Loading...</div>}>
                  <AdminWithToken users={users} />
                </Suspense>
              </ProtectedRoute>
            }
          />
          <Route
            path="/table"
            element={
              <ProtectedRoute>
                <Suspense fallback={<div>Loading...</div>}>
                  <HotelFlightCarWithToken />
                </Suspense>
              </ProtectedRoute>
            }
          />
          <Route
            path="/hotels"
            element={
              <ProtectedRoute>
                <Suspense fallback={<div>Loading...</div>}>
                  <TableOfHotelsWithToken />
                </Suspense>
              </ProtectedRoute>
            }
          />
          <Route
            path="/search"
            element={
              <ProtectedRoute>
                <Suspense fallback={<div>Loading...</div>}>
                  <ProductCardWithToken />
                </Suspense>
              </ProtectedRoute>
            }
          />
          <Route
            path="/contact-us"
            element={
              <ProtectedRoute>
                <Suspense fallback={<div>Loading...</div>}>
                  <ContactUsPageWithToken />
                </Suspense>
              </ProtectedRoute>
            }
          />
          <Route
            path="/account"
            element={
              <ProtectedRoute>
                <Suspense fallback={<div>Loading...</div>}>
                  <UserManagementWithToken user={user} />
                </Suspense>
              </ProtectedRoute>
            }
          />
        </Routes>
      </Router>
    </TokenProvider>
  );
};

const root = document.getElementById("app");
ReactDOM.createRoot(root).render(<App />);
