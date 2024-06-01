import React, { useEffect, useState } from "react";
import { Button, Typography } from "antd";
import { Link } from "react-router-dom";
import { Layout } from "antd";

const { Header, Content } = Layout;

const LandingPage = () => {
  const [scrollPosition, setScrollPosition] = useState(0);

  const handleScroll = () => {
    const position = window.pageYOffset;
    setScrollPosition(position);
  };

  useEffect(() => {
    window.addEventListener("scroll", handleScroll, { passive: true });

    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, []);

  return (
    <Layout style={{ width: "100%" }}>
      <Content
        style={{
          padding: "20px",
          marginTop: "70px",
          textAlign: "center",
          backgroundImage:
            "url(/public/Default_website_png_logo_for_travelling_2.jpg)",
          backgroundSize: "cover",
          backgroundRepeat: "no-repeat",
          height: `calc(100vh - ${scrollPosition}px)`,
          transition: "height 0.10s ease-in-out",
        }}
      >
        <Typography.Title level={2} style={{ fontSize: "3em" }}>
          Welcome to Our Website!
        </Typography.Title>
      </Content>
      <Content style={{ padding: "20px", textAlign: "center" }}>
        <Typography.Paragraph style={{ fontSize: "1.5em" }}>
          Welcome to our travel assistant website. This platform is designed to
          make your travel planning easier and more efficient. You can search
          for different destinations, choose your departure and return dates,
          and we will provide you with a list of available flights. But that's
          not all, we also provide information about hotels and car rentals at
          your destination. Our goal is to make your travel planning a one-stop
          solution, saving you time and effort. Start your journey with us
          today!
        </Typography.Paragraph>
        <Typography.Title level={3} style={{ fontSize: "2em" }}>
          Search Flights
        </Typography.Title>
        <img
          src="/public/landingPage.png"
          alt="Travel assistant"
          style={{
            display: "block",
            marginLeft: "auto",
            marginRight: "auto",
            marginBottom: "20px",
            boxShadow: "0 0 10px rgba(0, 0, 0, 0.5)",
            transform: "translateZ(-1px)",
            width: "700px",
            height: "500px",
          }}
        />

        <Typography.Title level={3} style={{ fontSize: "2em" }}>
          Search CarRentals
        </Typography.Title>
        <img
          src="/public/carRentals.png"
          alt="Travel assistant"
          style={{
            display: "block",
            marginLeft: "auto",
            marginRight: "auto",
            marginBottom: "20px",
            boxShadow: "0 0 10px rgba(0, 0, 0, 0.5)",
            transform: "translateZ(-1px)",
            width: "700px",
            height: "500px",
          }}
        />

        <Typography.Title level={3} style={{ fontSize: "2em" }}>
          Search Hotels
        </Typography.Title>
        <img
          src="/public/hotels.png"
          alt="Travel assistant"
          style={{
            display: "block",
            marginLeft: "auto",
            marginRight: "auto",
            marginBottom: "20px",
            boxShadow: "0 0 10px rgba(0, 0, 0, 0.5)",
            transform: "translateZ(-1px)",
            width: "700px",
            height: "500px",
          }}
        />
        <Typography.Title level={3} style={{ fontSize: "2em" }}>
          Why Choose Us?
        </Typography.Title>
        <Typography.Paragraph style={{ fontSize: "1.5em" }}>
          We offer a comprehensive travel planning solution, from flights to
          accommodations and car rentals. Our platform is user-friendly and
          efficient, saving you time and effort. We have partnerships with
          numerous airlines and hotels, ensuring you get the best deals
          available. Don't just take our word for it, read what our users have
          to say:
        </Typography.Paragraph>

        <Typography.Title level={3} style={{ fontSize: "2em" }}>
          Start your search
        </Typography.Title>

        <Button type="primary" style={{ marginTop: "20px" }}>
          <Link to="/search">Go to Search Page</Link>
        </Button>
      </Content>
    </Layout>
  );
};

export default LandingPage;
