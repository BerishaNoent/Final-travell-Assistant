import React from 'react';
import { Navigate } from 'react-router-dom';
import { useToken } from './TokenContext';

// Create a PrivateRoute component
export const ProtectedRoute = ({ children, path }) => {
  const { token, role } = useToken();

  if (!token) {
    return <Navigate to="/login" />;
  }
  if (path === '/admin' && role !== 'ADMIN') {
    return <Navigate to="/" />;
  }

  return children;
  
};

