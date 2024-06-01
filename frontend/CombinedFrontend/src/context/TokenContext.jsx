import React, { createContext, useState, useEffect, useContext } from 'react';
import Cookies from 'js-cookie';

export const TokenContext = createContext();

export function TokenProvider({ children }) {
    const [token, setToken] = useState(() => Cookies.get('token'));
    const [userId, setUserId] = useState(() => Cookies.get('userId'));
    const [role, setRole] = useState(() => Cookies.get('role'));
    const [email, setContextEmail] = useState(() => Cookies.get('email'));
    const [username, setContextUsername] = useState(() => Cookies.get('username'));
    const [phoneNumber, setContextPhoneNumber] = useState(() => Cookies.get('phoneNumber'));
    const [country, setContextCountry] = useState(() => Cookies.get('country'));
    const [city, setContextCity] = useState(() => Cookies.get('city'));
    const [address, setContextAddress] = useState(() => Cookies.get('address'));
    const [dateOfBirth, setContextDateOfBirth] = useState(() => Cookies.get('dateOfBirth'));
    const [name, setContextName] = useState(() => Cookies.get('name'));
    const [surname, setContextSurname] = useState(() => Cookies.get('surname'));

    useEffect(() => {
      if (token) Cookies.set('token', token);
      if (userId) Cookies.set('userId', userId);
      if (role) Cookies.set('role', role);
      if (email) Cookies.set('email', email);
      if (username) Cookies.set('username', username);
      if (phoneNumber) Cookies.set('phoneNumber', phoneNumber);
      if (country) Cookies.set('country', country);
      if (city) Cookies.set('city', city);
      if (address) Cookies.set('address', address);
      if (dateOfBirth) Cookies.set('dateOfBirth', dateOfBirth);
      if (name) Cookies.set('name', name);
      if (surname) Cookies.set('surname', surname);
    }, [token, userId, role, email, username, phoneNumber, country, city, address, dateOfBirth, name, surname]);

    return (
      <TokenContext.Provider value={{ 
        token, 
        setToken, 
        userId, 
        setUserId, 
        role, 
        setRole, 
        email, 
        setContextEmail, 
        username, 
        setContextUsername, 
        phoneNumber, 
        setContextPhoneNumber, 
        country, 
        setContextCountry, 
        city, 
        setContextCity, 
        address, 
        setContextAddress, 
        dateOfBirth, 
        setContextDateOfBirth, 
        name, 
        setContextName, 
        surname, 
        setContextSurname 
      }}>
        {children}
      </TokenContext.Provider>
    );
}

export function useToken() {
  const context = useContext(TokenContext);
  if (context === undefined) {
    throw new Error('useToken must be used within a TokenProvider');
  }
  return context;
}