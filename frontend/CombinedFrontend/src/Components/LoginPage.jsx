import React, { useState, useEffect } from 'react';
import ReactCardFlip from 'react-card-flip';
import styled from 'styled-components';
import {registerUser, authenticateUser} from '../Api';
import { toast } from 'react-toastify';
import { useToken } from '../context/TokenContext';
import { useNavigate } from 'react-router-dom';
import IconButton from '@mui/material/IconButton';
import InputAdornment from '@mui/material/InputAdornment';
import TextField from '@mui/material/TextField';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';

const Card = styled.div`
  background-color: #f8f9fa;
  border-radius: 15px;
  padding: 2rem;
  width: 500px; // Increase the width
  margin: 50px auto; // Add 50px margin from the top
`;

const Nav = styled.div`
  position: relative;
  display: flex;
  justify-content: space-around;
  margin-bottom: 2rem;
  &::after {
    content: '';
    position: absolute;
    height: 2px;
    width: 50%;
    left: ${props => props.isFlipped ? '50%' : '0'};
    bottom: 0;
    background-color: #007bff;
    transition: left 0.3s ease-in-out;
  }
`;

const NavButton = styled.button`
  background-color: transparent;
  border: none;
  color: ${props => props.active ? '#007bff' : '#6c757d'};
  padding: 0.5rem 2rem;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 1.2rem;
  margin: 1rem 2px;
  cursor: pointer;
  position: relative;
  z-index: 1;
`;

const Input = styled.input`
  width: 100%;
  padding: 0.5rem;
  margin: 0.5rem 0;
  box-sizing: border-box;
`;
const Button = styled.button`
  background-color: #0000A0;
  border: none;
  color: white;
  padding: 0.5rem 2rem;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 1.2rem;
  margin: 1rem 2px;
  cursor: pointer;
`;

export default function LoginPage() {
  const { setToken, setUserId, setRole, setContextEmail, setContextUsername, setContextPhoneNumber, setContextCountry, setContextCity, setContextAddress, setContextDateOfBirth, setContextName, setContextSurname } = useToken();
  const [isFlipped, setIsFlipped] = useState(false);
  const navigate = useNavigate();

  const [loginUsername, setLoginUsername] = useState('');
  const [loginPassword, setLoginPassword] = useState('');

  // Add state variables for sign up
  const [signUpUsername, setSignUpUsername] = useState('');
  const [signUpPassword, setSignUpPassword] = useState('');
  const [name, setName] = useState('');
  const [surname, setSurname] = useState('');
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [country, setCountry] = useState('');
  const [city, setCity] = useState('');
  const [address, setAddress] = useState('');
  const [dob, setDob] = useState('');
  const [showPassword, setShowPassword] = useState(false);

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  const handleLogin = async () => {
    try {
      const responsee = await authenticateUser({ username: loginUsername, password: loginPassword });
      const response = responsee.body;
setToken(response.token);
setUserId(response.userId);
setRole(response.role);
setContextEmail(response.email);
setContextUsername(response.username);
setContextPhoneNumber(response.phoneNumber);
setContextCountry(response.country);
setContextCity(response.city);
setContextAddress(response.address);
setContextDateOfBirth(response.dateOfBirth);
setContextName(response.name);
setContextSurname(response.surname);
navigate('/search');
console.log(response);
    } catch (error) {
      toast.error("Login failed: Please check your credentials");
    }
  };
  
  // Handle sign up
  const handleSignUp = async () => {
    try {
      const response = await registerUser({
        username: signUpUsername,
        password: signUpPassword,
        name,
        surname,
        email,
        phoneNumber,
        country,
        city,
        address,
        DateOfBirth: dob
      });
      console.log(response);
      setIsFlipped(false);
    } catch (error) {
      toast.error(`Sign up failed`);
    }
  };


  const today = new Date().toISOString().split('T')[0];
  const handleClick = (flipState) => {
    setIsFlipped(flipState);
  };

  return (
    <Card style={{ marginTop: '150px' }}>
      <Nav isFlipped={isFlipped}>
  <NavButton active={!isFlipped} onClick={() => handleClick(false)}>Login</NavButton>
  <NavButton active={isFlipped} onClick={() => handleClick(true)}>Sign Up</NavButton>
</Nav>
<ReactCardFlip isFlipped={isFlipped} flipDirection="horizontal">
      <div>
        <TextField 
  type="text" 
  placeholder="Username" 
  value={loginUsername} 
  onChange={e => setLoginUsername(e.target.value)} 
  sx={{ marginBottom: '20px', width: '100%' }}
/>
<TextField 
  type={showPassword ? "text" : "password"} 
  placeholder="Password" 
  value={loginPassword} 
  onChange={e => setLoginPassword(e.target.value)}
  InputProps={{
    endAdornment: (
      <InputAdornment position="end">
        <IconButton
          aria-label="toggle password visibility"
          onClick={() => setShowPassword(!showPassword)}
        >
          {showPassword ? <Visibility /> : <VisibilityOff />}
        </IconButton>
      </InputAdornment>
    ),
  }}
  sx={{ marginBottom: '20px', width: '100%' }}
/>
        <Button onClick={handleLogin}>Login</Button>
      </div>
      <div>
       
        <Input type="text" placeholder="Username" value={signUpUsername} onChange={e => setSignUpUsername(e.target.value)} />
        <Input type="password" placeholder="Password" value={signUpPassword} onChange={e => setSignUpPassword(e.target.value)} />
        <Input type="text" placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
        <Input type="text" placeholder="Surname" value={surname} onChange={e => setSurname(e.target.value)} />
        <Input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} />
        <Input type="tel" placeholder="Phone Number" value={phoneNumber} onChange={e => setPhoneNumber(e.target.value)} />
        <Input type="text" placeholder="Country" value={country} onChange={e => setCountry(e.target.value)} />
        <Input type="text" placeholder="City" value={city} onChange={e => setCity(e.target.value)} />
        <Input type="text" placeholder="Address" value={address} onChange={e => setAddress(e.target.value)} />
        <Input type="date" placeholder="Date of Birth" max={today} value={dob} onChange={e => setDob(e.target.value)} />
        <Button onClick={handleSignUp}>Sign Up</Button>
      </div>
    </ReactCardFlip>
    </Card>
  );
}