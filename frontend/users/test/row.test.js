import { render, screen} from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import{Row} from '../src/Components/UserManagment';

jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});
  
afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });
describe('Row in UserManagement', () => {
  const mockProps = {
    row: {
      originPlace: 'Origin',
      destinationPlace: 'Destination',
      departureDateTime: new Date(),
      arrivalDateTime: new Date(),
      price: { amount: 100 },
      bookingLink: 'http://booking.com',
      legs: [
        {
          originPlace: 'Leg Origin',
          destinationPlace: 'Leg Destination',
          departureDateTime: new Date(),
          arrivalDateTime: new Date(),
        },
      ],
      carriers: [
        {
          name: 'Carrier Name',
          imageUrl: 'http://carrier.com/image.png',
        },
      ],
      agents: [
        {
          name: 'Agent Name',
          imageUrl: 'http://agent.com/image.png',
        },
      ],
    },
    handleDelete: jest.fn(),
    setOpen: jest.fn(),
    open: false,
    openDeleteDialog: false,
    cancelDelete: jest.fn(),
    confirmDelete: jest.fn(),
  };

  beforeEach(() => {
    render(<Row {...mockProps} />);
  });

  test('renders origin place', () => {
    expect(screen.getByText('Origin')).toBeInTheDocument();
  });

  test('renders destination place', () => {
    expect(screen.getByText('Destination')).toBeInTheDocument();
  });

  test('renders price', () => {
    expect(screen.getByText('100')).toBeInTheDocument();
  });

  test('renders booking link', () => {
    expect(screen.getByText('Book Now')).toBeInTheDocument();
  });

});
