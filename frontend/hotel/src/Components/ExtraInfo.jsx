import React from "react";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import {
  Card,
  CardContent,
  Typography,
  Box,
  Rating,
  Button,
} from "@mui/material";

const HotelDetails = ({ hotel }) => {
  return (
    <Card
      sx={{
        margin: "auto",
        backgroundColor: "#f5f5f5",
        borderRadius: "15px",
        padding: "20px",
        fontFamily: "Oswald, sans-serif",
      }}
    >
      <Carousel
        role="list"
        data-testid="hotel-carousel"
        style={{ width: "80%", margin: "auto" }}
      >
        {Object.values(hotel.photos).map((photo, index) => (
          <div key={index}>
            <img
              src={photo}
              alt={`Slide ${index}`}
              style={{
                maxHeight: "300px",
                maxWidth: "100%",
                objectFit: "cover",
                borderRadius: "10px",
              }}
            />
          </div>
        ))}
      </Carousel>
      <CardContent>
        <Box
          sx={{
            display: "grid",
            gridTemplateColumns: "repeat(3, 1fr)",
            gap: "10px",
          }}
        >
          <Typography variant="h5" sx={{ mt: 2, mb: 2, gridColumn: "span 3" }}>
            {hotel.name}
          </Typography>
          <Typography variant="subtitle1" sx={{ mt: 2, mb: 2 }}>
            <strong>Location:</strong> {hotel.city}, {hotel.country}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Address:</strong> {hotel.address}
          </Typography>
          <Box sx={{ display: "flex", alignItems: "center", gap: "10px" }}>
            <Typography variant="body2">
              <strong>Star Rating:</strong>
            </Typography>
            <Rating name="star-rating" value={hotel.starRating} readOnly />
            <Typography variant="body2">{hotel.starRating}</Typography>
          </Box>
          <Box sx={{ display: "flex", alignItems: "center", gap: "10px" }}>
            <Typography variant="body2">
              <strong>Review Rating:</strong>
            </Typography>
            <Rating name="review-rating" value={hotel.reviewRating} readOnly />
            <Typography variant="body2">{hotel.reviewRating}</Typography>
          </Box>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Review Count:</strong> {hotel.reviewCount}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Check In Time:</strong> {hotel.checkInTime}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Check Out Time:</strong> {hotel.checkOutTime}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Description:</strong> {hotel.hotelDescription}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Latitude:</strong> {hotel.latitude}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Longitude:</strong> {hotel.longitude}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Hotel Rank:</strong> {hotel.hotelRank}
          </Typography>

          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Good Description:</strong> {hotel.goodDescription}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Bad Description:</strong> {hotel.badDescription}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Min Price:</strong> {hotel.minPrice}
          </Typography>
          <Typography variant="body2" sx={{ mt: 2, mb: 2 }}>
            <strong>Image URL:</strong> {hotel.imageUrl}
          </Typography>
          <Button
            variant="contained"
            color="primary"
            sx={{ mt: 2, gridColumn: "span 3" }}
          >
            Book Now
          </Button>
        </Box>
      </CardContent>
    </Card>
  );
};

export default HotelDetails;
