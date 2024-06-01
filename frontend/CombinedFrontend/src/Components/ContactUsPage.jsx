import React, { useEffect, useState } from "react";
import { Container, Form, Button } from "react-bootstrap";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./serachFlights.css";
import { addMessage } from "../Api"; // replace with the actual file path

export default function ContactUsPage({ userLoggedData }) {
  const { token, username, email } = userLoggedData;
  const [message, setMessage] = useState("");

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
  const handleSubmit = async (event) => {
    event.preventDefault();
    const form = event.target;
    const contactUs = {
      username: form.elements.formBasicName.value,
      email: form.elements.formBasicEmail.value,
      message: form.elements.formBasicMessage.value,
    };
    const response = await addMessage(contactUs, token);
    if (response.status === 201) {
      toast.success("Your message has been submitted!");
    } else {
      toast.error("There was an error submitting your message.");
    }
  };

  return (
    <Container style={{ width: "600px", margin: "10px auto" }}>
      <h1
        style={{ textAlign: "center", marginBottom: "2rem", fontSize: "3em" }}
      >
        Contact Us
      </h1>
      <Form
        style={{
          padding: "2rem",
          backgroundColor: "#f8f9fa",
          borderRadius: "15px",
          maxWidth: "90%",
        }}
        onSubmit={handleSubmit}
      >
        <Form.Group controlId="formBasicName" style={{ marginBottom: "20px" }}>
          <Form.Label>Username</Form.Label>
          <Form.Control
            type="text"
            style={{ width: "100%" }}
            value={username}
            readOnly
          />
        </Form.Group>

        <Form.Group controlId="formBasicEmail" style={{ marginBottom: "20px" }}>
          <Form.Label>Email address</Form.Label>
          <Form.Control
            type="email"
            style={{ width: "100%" }}
            value={email}
            readOnly
          />
        </Form.Group>

        <Form.Group
          controlId="formBasicMessage"
          style={{ marginBottom: "20px" }}
        >
          <Form.Label>Message</Form.Label>
          <Form.Control
            as="textarea"
            placeholder="Enter message"
            rows={3}
            maxLength={200}
            style={{ width: "100%" }}
          />
        </Form.Group>

        <Button
          variant="primary"
          type="submit"
          style={{
            marginTop: "2rem",
            backgroundColor: "#0000A0",
            border: "none",
            padding: "0.5rem 2rem",
            fontSize: "1.2rem",
            color: "white",
          }}
        >
          Submit
        </Button>
      </Form>
    </Container>
  );
}
