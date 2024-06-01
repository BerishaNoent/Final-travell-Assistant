import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import Row from "../src/Components/TableOfHotels";
import "@testing-library/jest-dom";
import HotelDetails from "../src/Components/ExtraInfo";
import CollapsibleTable from "../src/Components/TableOfHotels";
import '@testing-library/jest-dom/extend-expect';

jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});
  
afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });

  const mockRow = {
    id: 1,
    imageUrl: "http://example.com/image.jpg",
    name: "Test Hotel",
    city: "Test City",
    country: "Test Country",
    starRating: 4,
    address: "123 Test St",
    minPrice: 100,
    hotelRank: "5-star",
    reviewRating: 4.5,
  };

  const mockUserLoggedData = {
    token: "testToken",
    userId: "testUserId",
  };
describe("Row", () => {
    beforeAll(() => {
      // Create a div with id 'app' to attach the modal to
      const modalRoot = document.createElement("div");
      modalRoot.setAttribute("id", "app");
      document.body.appendChild(modalRoot);
    });
  
    test("displays the hotel details", () => {
      render(
        <Row row={mockRow} userLoggedData={mockUserLoggedData} rows={[mockRow]} />
      );
      expect(screen.getByText(mockRow.name)).toBeInTheDocument();
      expect(screen.getByText(mockRow.city)).toBeInTheDocument();
      expect(screen.getByText(mockRow.country)).toBeInTheDocument();
    });
  
    test("toggles open state when the button is clicked", () => {
      render(
        <Row row={mockRow} userLoggedData={mockUserLoggedData} rows={[mockRow]} />
      );
      const button = screen.getByRole("button", { name: /expand row/i });
      fireEvent.click(button);
      expect(screen.getByText("Hotel Details")).toBeInTheDocument();
    });
  });