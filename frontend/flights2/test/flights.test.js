import { screen, render } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import CollapsibleTable from "../src/Components/TableOfItems";
import "@testing-library/jest-dom/extend-expect";
jest.spyOn(console, "log").mockImplementation(() => {});
jest.spyOn(console, "warn").mockImplementation(() => {});
jest.spyOn(console, "error").mockImplementation(() => {});

afterAll(() => {
  console.log.mockRestore();
  console.warn.mockRestore();
  console.error.mockRestore();
});

const mockUserLoggedData = {
  userId: "sampleUserId",
  token: "sampleToken",
};

const mockRows = [
  {
    originPlace: "Origin 1",
    destinationPlace: "Destination 1",
    departureDateTime: {
      year: 2024,
      month: 5,
      day: 25,
      hour: 10,
      minute: 30,
    },
    arrivalDateTime: {
      year: 2024,
      month: 5,
      day: 25,
      hour: 12,
      minute: 30,
    },
    price: 100,
    bookingLink: "https://example.com/book",
  },
];

describe("CollapsibleTable component", () => {
  test("renders without errors", () => {
    render(
      <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
    );
    expect(screen.getByLabelText("collapsible table")).toBeInTheDocument();
  });

  test("filters flights based on price", async () => {
    render(
      <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
    );
    expect(screen.getByText("Filters")).toBeInTheDocument();

    expect(screen.getByText("Asc")).toBeInTheDocument();
    expect(screen.getByText("Desc")).toBeInTheDocument();
  });

  test("sorts flights by price in ascending order", async () => {
    render(
      <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
    );
    const accordionSummary = screen.getByTestId("accordion-summary");
    expect(accordionSummary).toBeInTheDocument();
  });

  test("sorts flights by price in descending order", async () => {
    render(
      <CollapsibleTable rows={mockRows} userLoggedData={mockUserLoggedData} />
    );
    const sortFieldSelects = screen.getAllByLabelText("Sort By");
    const sortFieldSelect = sortFieldSelects[1];

    userEvent.click(sortFieldSelect);

    const priceOption = await screen.findByRole("option", { name: "Price" });
    userEvent.click(priceOption);
  });
});
