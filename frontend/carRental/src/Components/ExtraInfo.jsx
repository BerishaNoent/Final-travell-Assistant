import React from "react";
import {
  Card,
  CardContent,
  Typography,
  Box,
  Rating,
  Button,
} from "@mui/material";

const CarRentalDetails = ({ carRental }) => {
  return (
    <Card
      sx={{
        margin: "auto",
        backgroundColor: "#f5f5f5",
        borderRadius: "15px",
        padding: "20px",
      }}
    >
      <CardContent>
        <Box
          sx={{
            display: "grid",
            gridTemplateColumns: "repeat(3, 1fr)",
            gap: "10px",
          }}
        >
          <Typography variant="h5" sx={{ mt: 2, mb: 2, gridColumn: "span 3" }}>
            {carRental.supplierName}
          </Typography>
          <img
            src={carRental.supplierImage}
            alt={carRental.supplierName}
            style={{
              maxHeight: "300px",
              maxWidth: "100%",
              objectFit: "cover",
              borderRadius: "10px",
            }}
          />
          <Typography variant="subtitle1" sx={{ mt: 2, mb: 2 }}>
            <strong>Address:</strong> {carRental.supplierAddress}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Car Name:</strong> {carRental.carName}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Transmission:</strong> {carRental.transmission}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Seats:</strong> {carRental.seats}
          </Typography>
          <img
            src={carRental.carImage}
            alt={carRental.carName}
            style={{
              maxHeight: "300px",
              maxWidth: "100%",
              objectFit: "cover",
              borderRadius: "10px",
            }}
          />
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Price:</strong> {carRental.price} {carRental.currency}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Base Deposit:</strong> {carRental.baseDeposit}
          </Typography>
          <Button
            variant="contained"
            color="primary"
            sx={{ mt: 2, gridColumn: "span 3" }}
          >
            Rent Now
          </Button>
        </Box>
      </CardContent>
    </Card>
  );
};

export default CarRentalDetails;
