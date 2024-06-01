// test/hotel.test.js
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

const mockUserLoggedData = {
  token: "testToken",
  userId: "testUserId",
};

const mockRows = [
  {
    id: "1",
    name: "Hotel One",
    city: "City One",
    country: "Country One",
    address: "Address One",
    starRating: "5",
    minPrice: "100",
    hotelRank: "1",
    imageUrl: "http://example.com/image1.jpg",
  },
  {
    id: "2",
    name: "Hotel Two",
    city: "City Two",
    country: "Country Two",
    address: "Address Two",
    starRating: "4",
    minPrice: "80",
    hotelRank: "2",
    imageUrl: "http://example.com/image2.jpg",
  },
  // Add more mock rows as needed
];


describe("CollapsibleTable", () => {
  beforeEach(() => {
    const div = document.createElement("div");
    div.id = "app";
    document.body.appendChild(div);
  });

  afterEach(() => {
    const div = document.getElementById("app");
    if (div) {
      document.body.removeChild(div);
    }
  });

  test("renders accordion summary", () => {
    const filteredHotels = [];
    const userLoggedData = {};

    render(
      <CollapsibleTable rows={filteredHotels} userLoggedData={userLoggedData} />
    );

    const accordionSummary = screen.getByTestId("accordion-summary");
    expect(accordionSummary).toBeInTheDocument();
  });
  test("renders correctly", () => {
    render(
      <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
    );
    expect(screen.getByText("Filters")).toBeInTheDocument();

    expect(screen.getByText("Asc")).toBeInTheDocument();
    expect(screen.getByText("Desc")).toBeInTheDocument();
    expect(screen.getByTestId("clear-button")).toBeInTheDocument();
  });

  test("sorts hotels", async () => {
    const handleSortFieldChange = jest.fn();
    render(
      <CollapsibleTable
        rows={mockRows}
        userLoggedData={mockUserLoggedData}
        onChange={handleSortFieldChange}
      />
    );

    const sortFieldSelects = screen.getAllByLabelText("Sort By");
    const sortFieldSelect = sortFieldSelects[1];

    userEvent.click(sortFieldSelect);

    const priceOption = await screen.findByRole("option", { name: "Price" });
    userEvent.click(priceOption);
  });

  test("filter hotels", async () => {
    const handleSortFieldChange = jest.fn();
    render(
      <CollapsibleTable
        rows={mockRows}
        userLoggedData={mockUserLoggedData}
        onChange={handleSortFieldChange}
      />
    );

    const sortFieldSelects = screen.getAllByLabelText("Sort By");
    const sortFieldSelect = sortFieldSelects[1];

    userEvent.click(sortFieldSelect);

    const priceOption = await screen.findByRole("option", { name: "Price" });
    userEvent.click(priceOption);
  });
});

