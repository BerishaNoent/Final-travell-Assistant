import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import CollapsibleTable from '../src/Components/TableOfCars';


jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});
  
afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });

  
  describe("CollapsibleTable", () => {
    const mockRows = []; // Add your mock rows here
    const mockUserLoggedData = {}; // Add your mock user data here
  
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
      render(
        <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
      );
  
      const accordionSummary = screen.getByText("Filters");
      expect(accordionSummary).toBeInTheDocument();
    });
  
    test("renders correctly", () => {
      render(
        <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
      );
  
      expect(screen.getByText("Filters")).toBeInTheDocument();
    });
  
    test("filters car rentals", async () => {
      render(
        <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
      );
  
      const ratingInput = screen.getByPlaceholderText("From 1-10");
      userEvent.type(ratingInput, "5");
  
      const applyButton = screen.getByText("Apply");
      userEvent.click(applyButton);
  
      // Add assertions to check if the car rentals are filtered correctly
    });
  });