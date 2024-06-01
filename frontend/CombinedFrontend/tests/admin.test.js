import { render, screen, act } from "@testing-library/react";
import Admin from "../src/Components/Admin";
import "@testing-library/jest-dom/extend-expect";
import * as Api from "../src/Api";
jest.spyOn(console, "log").mockImplementation(() => {});
jest.spyOn(console, "warn").mockImplementation(() => {});
jest.spyOn(console, "error").mockImplementation(() => {});

afterAll(() => {
  console.log.mockRestore();
  console.warn.mockRestore();
  console.error.mockRestore();
});
// Mock user data
const mockUserData = {
  id: 1,
  username: "testUser",
  email: "testUser@example.com",
  phoneNumber: "1234567890",
  country: "TestCountry",
  city: "TestCity",
  address: "TestAddress",
  DateOfBirth: "2000-01-01",
  name: "Test",
  surname: "User",
};

jest.mock("../src/Api", () => ({
  getNumberOfFlights: jest.fn(),
  getNumberOfHotels: jest.fn(),
  getNumberOfCarRentals: jest.fn(),
}));
describe("Admin component", () => {
  beforeEach(async () => {
    Api.getNumberOfFlights.mockResolvedValue(10);
    Api.getNumberOfHotels.mockResolvedValue(20);
    Api.getNumberOfCarRentals.mockResolvedValue(30);
    let container;
    await act(async () => {
      const renderResult = render(<Admin userLoggedData={mockUserData} />);
      container = renderResult.container;
    });
  });
  beforeAll(() => {
    const modalRoot = document.createElement("div");
    modalRoot.setAttribute("id", "app");
    document.body.appendChild(modalRoot);
  });

  test("renders the number of saved flights", () => {
    const flightsElement = screen.getByText(/Number of Saved Flights/i);
    expect(flightsElement).toBeInTheDocument();
  });

  test("renders the number of saved hotels", () => {
    const flightsElement = screen.getByText(/Number of Saved Hotels/i);
    expect(flightsElement).toBeInTheDocument();
  });

  test("renders the number of saved car rentals", () => {
    const flightsElement = screen.getByText(/Number of Saved Car Rentals/i);
    expect(flightsElement).toBeInTheDocument();

  });

});
