import { screen, render } from "@testing-library/react";
import { Row } from "../src/Components/TableOfItems";
import "@testing-library/jest-dom/extend-expect";
jest.spyOn(console, "log").mockImplementation(() => {});
jest.spyOn(console, "warn").mockImplementation(() => {});
jest.spyOn(console, "error").mockImplementation(() => {});

afterAll(() => {
  console.log.mockRestore();
  console.warn.mockRestore();
  console.error.mockRestore();
});
describe("Row component", () => {
  const row = {
    originPlace: "Origin",
    destinationPlace: "Destination",
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
    price: {
      amount: 100,
      unit: "USD",
    },
    bookingLink: "https://example.com/book",
    carriers: [
      { name: "Carrier 1", imageUrl: "https://example.com/carrier1.jpg" },
    ],
    agents: [{ name: "Agent 1", imageUrl: "https://example.com/agent1.jpg" }],
    legs: [
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
          hour: 11,
          minute: 30,
        },
      },
    ],
  };

  const userId = "sampleUserId";
  const token = "sampleToken";

  test("renders components and text correctly", async () => {
    render(<Row row={row} userId={userId} token={token} />);

    expect(screen.getByText(row.originPlace)).toBeInTheDocument();
    expect(screen.getByText(row.destinationPlace)).toBeInTheDocument();
    expect(
      screen.getByText(`${row.price.amount} ${row.price.unit}`)
    ).toBeInTheDocument();
  });
});
