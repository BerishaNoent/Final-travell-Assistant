import { render, fireEvent } from '@testing-library/react';
import ContactUsPage from '../src/Components/ContactUsPage'; // replace with the actual file path
import { addMessage } from '../src/Api'; // replace with the actual file path

jest.spyOn(console, 'log').mockImplementation(() => {});
jest.spyOn(console, 'warn').mockImplementation(() => {});
jest.spyOn(console, 'error').mockImplementation(() => {});

afterAll(() => {
    console.log.mockRestore();
    console.warn.mockRestore();
    console.error.mockRestore();
  });

jest.mock('../src/Api'); // replace with the actual file path

describe('Contact Us Page', () => {
  afterEach(() => {
    // cleaning up the mess left behind the previous test
    jest.clearAllMocks();
  });

  test('submits the form', async () => {
    // setup
    const userLoggedData = {
      token: 'token',
      username: 'username',
      email: 'email',
    };

    const { getByLabelText, getByText } = render(<ContactUsPage userLoggedData={userLoggedData} />);

    // Mock the addMessage function
    addMessage.mockResolvedValue(true);

    // work
    fireEvent.change(getByLabelText(/message/i), { target: { value: 'Test message' } });
    fireEvent.click(getByText(/submit/i));

    // expectations
    expect(addMessage).toHaveBeenCalledWith({
      username: userLoggedData.username,
      email: userLoggedData.email,
      message: 'Test message',
    }, userLoggedData.token);
  });
});