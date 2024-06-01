import { render, screen } from '@testing-library/react';
import UserManagement from '../src/Components/UserManagment';
import '@testing-library/jest-dom/extend-expect';

jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});
  
afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });
describe('UserManagement', () => {
    const mockProps = {
        userLoggedData: {
          changeUsername: jest.fn(),
          setChangeUsername: jest.fn(),
          name: 'John',
          surname: 'Doe',
          phoneNumber: '1234567890',
          email: 'john.doe@example.com',
          savedFlights: [],
          token: 'token',
          userId: 'userId',
          removeFlight: jest.fn(),
          savedHotels: [],
          removeHotel: jest.fn(),
          recentSearches: [],
          savedCarRentals: [],
          removeCarRental: jest.fn()
        }
      };

      beforeEach(() => {
        render(<UserManagement {...mockProps} />);
      });
      
      test('renders user name', () => {
        expect(screen.getByText('Name:')).toBeInTheDocument();
        expect(screen.getByText('John')).toBeInTheDocument();
      });
      
      test('renders user surname', () => {
        expect(screen.getByText('Surname:')).toBeInTheDocument();
        expect(screen.getByText('Doe')).toBeInTheDocument();
      });
      
      test('renders user phone number', () => {
        expect(screen.getByText('Phone Number:')).toBeInTheDocument();
        expect(screen.getByText('1234567890')).toBeInTheDocument();
      });
      
      test('renders user email', () => {
        expect(screen.getByText('Email:')).toBeInTheDocument();
        expect(screen.getByText('john.doe@example.com')).toBeInTheDocument();
      });
      
      test('renders saved flights section', () => {
        expect(screen.getByText('Saved Flights')).toBeInTheDocument();
      });
      
      test('renders saved hotels section', () => {
        expect(screen.getByText('Saved Hotels')).toBeInTheDocument();
      });
      
      test('renders recent searches section', () => {
        expect(screen.getByText('Recent Searches')).toBeInTheDocument();
      });
      
      test('renders saved car rentals section', () => {
        expect(screen.getByText('Saved Car Rentals')).toBeInTheDocument();
      });
});