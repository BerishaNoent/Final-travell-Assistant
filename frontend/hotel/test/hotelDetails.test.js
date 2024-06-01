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

const mockHotel = {
  name: "Test Hotel",
  city: "Test City",
  country: "Test Country",
  address: "123 Test St",
  starRating: 4,
  reviewRating: 4.5,
  reviewCount: 200,
  checkInTime: "3:00 PM",
  checkOutTime: "11:00 AM",
  hotelDescription: "A nice place to stay.",
  latitude: "40.7128",
  longitude: "-74.0060",
  hotelRank: 1,
  goodDescription: "Very clean and well maintained.",
  badDescription: "Limited parking space.",
  minPrice: "$100",
  imageUrl: "http://example.com/image.jpg",
  photos: {
    0: "http://example.com/photo1.jpg",
    1: "http://example.com/photo2.jpg",
  },
};


test("renders HotelDetails component with correct hotel details", () => {
  const { container } = render(<HotelDetails hotel={mockHotel} />);

  const hotelNameHeading = container.querySelector('.MuiTypography-root.MuiTypography-h5.css-1qc2b7d-MuiTypography-root');
  expect(hotelNameHeading.textContent).toBe(mockHotel.name);

  const locationSubtitle = container.querySelector('.MuiTypography-root.MuiTypography-subtitle1.css-swwzjf-MuiTypography-root');
  expect(locationSubtitle.textContent).toBe(`Location: ${mockHotel.city}, ${mockHotel.country}`);

  const addressParagraph = container.querySelector('.MuiTypography-root.MuiTypography-body2.css-4ny1nj-MuiTypography-root');
  expect(addressParagraph.textContent).toBe(`Address: ${mockHotel.address}`);
});

test("renders HotelDetails component with correct hotel ratings", () => {
  const { container } = render(<HotelDetails hotel={mockHotel} />);

  const paragraphs = Array.from(container.querySelectorAll('.MuiTypography-root.MuiTypography-body2'));
  
  const descriptionParagraph = paragraphs.find(p => p.innerHTML.includes('Description:'));
  expect(descriptionParagraph.innerHTML).toContain(`Description:</strong> ${mockHotel.hotelDescription}`);

  const latitudeParagraph = paragraphs.find(p => p.innerHTML.includes('Latitude:'));
  expect(latitudeParagraph.innerHTML).toContain(`Latitude:</strong> ${mockHotel.latitude}`);

  const longitudeParagraph = paragraphs.find(p => p.innerHTML.includes('Longitude:'));
  expect(longitudeParagraph.innerHTML).toContain(`Longitude:</strong> ${mockHotel.longitude}`);

  const hotelRankParagraph = paragraphs.find(p => p.innerHTML.includes('Hotel Rank:'));
  expect(hotelRankParagraph.innerHTML).toContain(`Hotel Rank:</strong> ${mockHotel.hotelRank}`);
});


describe("HotelDetails", () => {
  test("displays the correct images in the carousel", () => {
    render(<HotelDetails hotel={mockHotel} />);
    const images = screen.getAllByRole("img");
    expect(images[0].getAttribute("src")).toBe(mockHotel.photos[0]);
    expect(images[1].getAttribute("src")).toBe(mockHotel.photos[1]);
  });
});