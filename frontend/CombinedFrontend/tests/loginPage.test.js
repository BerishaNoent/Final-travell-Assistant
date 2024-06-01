import React from 'react';
import { render, fireEvent, waitFor } from '@testing-library/react';
import LoginPage from '../src/Components/LoginPage';
import { useToken } from '../src/context/TokenContext';
import { registerUser, authenticateUser } from '../src/Api';
import { useNavigate } from 'react-router-dom';
import '@testing-library/jest-dom/extend-expect';

jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});


afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });

jest.mock('../src/context/TokenContext');
jest.mock('../src/Api');
jest.mock('react-router-dom', () => ({
  useNavigate: jest.fn(),
}));

describe('LoginPage', () => {
  beforeEach(() => {
    useToken.mockReturnValue({
      setToken: jest.fn(),
      setUserId: jest.fn(),
      setRole: jest.fn(),
      setContextEmail: jest.fn(),
      setContextUsername: jest.fn(),
      setContextPhoneNumber: jest.fn(),
      setContextCountry: jest.fn(),
      setContextCity: jest.fn(),
      setContextAddress: jest.fn(),
      setContextDateOfBirth: jest.fn(),
      setContextName: jest.fn(),
      setContextSurname: jest.fn(),
    });
    authenticateUser.mockResolvedValue({
      token: 'test-token',
      userId: 'test-userId',
      role: 'test-role',
      email: 'test-email',
      username: 'test-username',
      phoneNumber: 'test-phoneNumber',
      country: 'test-country',
      city: 'test-city',
      address: 'test-address',
      dateOfBirth: 'test-dateOfBirth',
      name: 'test-name',
      surname: 'test-surname',
    });
    registerUser.mockResolvedValue({});
    useNavigate.mockReturnValue(jest.fn());
  });

  it('renders without crashing', () => {
    render(<LoginPage />);
  });

  it('handles login', async () => {
    const { getAllByPlaceholderText, getAllByText } = render(<LoginPage />);
    const usernameInputs = getAllByPlaceholderText('Username');
    const passwordInputs = getAllByPlaceholderText('Password');
    const loginButtons = getAllByText('Login');
    fireEvent.change(usernameInputs[0], { target: { value: 'test-username' } });
    fireEvent.change(passwordInputs[0], { target: { value: 'test-password' } });
    fireEvent.click(loginButtons[1]);
    await waitFor(() => expect(authenticateUser).toHaveBeenCalledWith({ username: 'test-username', password: 'test-password' }));
  });

  it('handles sign up', async () => {
    const { getAllByPlaceholderText, getAllByText } = render(<LoginPage />);
    const usernameInputs = getAllByPlaceholderText('Username');
    const passwordInputs = getAllByPlaceholderText('Password');
    const signUpButtons = getAllByText('Sign Up');
    fireEvent.change(usernameInputs[1], { target: { value: 'test-username' } });
    fireEvent.change(passwordInputs[1], { target: { value: 'test-password' } });
    fireEvent.click(signUpButtons[1]);
    await waitFor(() => expect(registerUser).toHaveBeenCalled());
  });
});