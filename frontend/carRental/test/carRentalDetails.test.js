import React from 'react';
import { render, screen } from '@testing-library/react';
import CarRentalDetails from "../src/Components/ExtraInfo";
import '@testing-library/jest-dom/extend-expect';
jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});
  
afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });
const mockCarRental = {
  supplierName: 'Test Supplier',
  supplierImage: 'test-supplier-image.jpg',
  supplierAddress: '123 Test St',
  carName: 'Test Car',
  transmission: 'Automatic',
  seats: '5',
  carImage: 'test-car-image.jpg',
  price: '100',
  currency: 'USD',
  baseDeposit: '200',
};

test("renders CarRentalDetails component with correct values", () => {
    const { container } = render(<CarRentalDetails carRental={mockCarRental} />);
const carNameParagraph = container.querySelector('.MuiTypography-root.MuiTypography-body2.css-4ny1nj-MuiTypography-root');
expect(carNameParagraph).toBeInTheDocument();
  
    const supplierNameHeading = screen.getByRole('heading', { name: mockCarRental.supplierName });
    expect(supplierNameHeading).toBeInTheDocument();
  
    const supplierAddressHeading = screen.getByRole('heading', { name: `Address: ${mockCarRental.supplierAddress}` });
    expect(supplierAddressHeading).toBeInTheDocument();
  
    const supplierImage = screen.getByRole('img', { name: mockCarRental.supplierName });
    expect(supplierImage.src).toContain(mockCarRental.supplierImage);
  
    const carImage = screen.getByRole('img', { name: mockCarRental.carName });
    expect(carImage.src).toContain(mockCarRental.carImage);
  
    const rentNowButton = screen.getByRole('button', { name: 'Rent Now' });
    expect(rentNowButton).toBeInTheDocument();
  });

describe("CarRentalDetails", () => {
  test("displays the correct images", () => {
    render(<CarRentalDetails carRental={mockCarRental} />);
    const images = screen.getAllByRole("img");
    expect(images[0].getAttribute("src")).toBe(mockCarRental.supplierImage);
    expect(images[1].getAttribute("src")).toBe(mockCarRental.carImage);
  });
});
