import * as React from "react";
import { useState, useEffect } from "react";
import {
  Card,
  CardContent,
  Button,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Typography,
  Badge,
  IconButton,
  Grid,
} from "@mui/material";
import Modal from "react-modal";
import Box from "@mui/material/Box";
import MailIcon from "@mui/icons-material/Mail";
import DeleteIcon from "@mui/icons-material/Delete";
import CloseIcon from "@mui/icons-material/Close";
import ReplyIcon from "@mui/icons-material/Reply";
import Container from "@mui/material/Container";
import TablePagination from "@mui/material/TablePagination";
import ConfirmationDialog from "./ConfirmationDialog";
import KeyboardArrowUpIcon from "@mui/icons-material/KeyboardArrowUp";
import KeyboardArrowDownIcon from "@mui/icons-material/KeyboardArrowDown";
import Collapse from "@mui/material/Collapse";

import { toast } from "react-toastify";
import {
  sendMail,
  deleteMessage,
  getAllUsers,
  markAllMessagesAsRead,
  getMessages,
  fetchAirports,
  getNumberOfFlights,
  getNumberOfHotels,
  getNumberOfCarRentals,
  getMostSearchedDestinations,
} from "../Api";
import AddAirportfrom from "./AddAirportForm";

const Admin = ({ userLoggedData }) => {
  const token = userLoggedData.token;
  const [users, setUsers] = useState([]);
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [messages, setMessages] = useState([]);
  const [hasNewMessages, setHasNewMessages] = useState(false);
  const [replyOpen, setReplyOpen] = useState({});
  const [page, setPage] = useState(0);
  const [replyText, setReplyText] = useState({});
  const [repliedStatus, setRepliedStatus] = useState({});
  const [rowsPerPage, setRowsPerPage] = useState(5);
  const [airports, setAirports] = useState([]);
  const [numberOfSavedFlights, setNumberOfSavedFlights] = useState(0);
  const [numberOfSavedHotels, setNumberOfSavedHotels] = useState(0);
  const [numberOfSavedCarRentals, setNumberOfSavedCarRentals] = useState(0);
  const [mostSearchedDestinations, setMostSearchedDestinations] = useState([]);
  const [open, setOpen] = useState({});

  useEffect(() => {
    Modal.setAppElement("#app");
  }, []);

  useEffect(() => {
    const fetchUserDetails = async () => {
      try {
        const flights = await getNumberOfFlights(token);
        setNumberOfSavedFlights(flights.body);

        const hotels = await getNumberOfHotels(token);
        setNumberOfSavedHotels(hotels.body);

        const carRentals = await getNumberOfCarRentals(token);
        setNumberOfSavedCarRentals(carRentals.body);

        const destinations = await getMostSearchedDestinations(token);
        setMostSearchedDestinations(destinations.body);
        console.log(destinations.body);
      } catch (error) {
        toast.error(error);
      }
    };

    fetchUserDetails();
  }, []);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await getAllUsers(token);
        console.log(response);
        setUsers(response.body);
      } catch (err) {
        toast.error("Something went wrong, please try again later.");
      }
    };

    fetchUsers();
  }, []);

  useEffect(() => {
    const fetchMessages = async () => {
      try {
        const response = await getMessages(token);
        setMessages(response.body);

        let hasNewMessages = false;
        for (let i = 0; i < response.body.length; i++) {
          if (!response.body[i].isRead) {
            hasNewMessages = true;
            break;
          }
        }
        setHasNewMessages(hasNewMessages);
      } catch (err) {
        toast.error("Something went wrong, please try again later.");
      }
    };

    fetchMessages();
  }, []);

  useEffect(() => {
    const getAirports = async () => {
      try {
        const response = await fetchAirports(token);
        setAirports(response.body);
      } catch (error) {
        toast.error("Failed to fetch airports:", error);
      }
    };

    getAirports();
  }, []);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  const handleReply = (messageId, email) => {
    sendMail(email, replyText[messageId], token)
      .then(() => {
        toast.success(`Reply sent to ${email}`);
        setRepliedStatus((prevStatus) => ({
          ...prevStatus,
          [messageId]: true,
        }));
      })
      .catch(() => toast.error(`An error occurred while replying to ${email}`));
  };

  const handleDelete = (messageId) => {
    deleteMessage(messageId, token)
      .then(() => {
        toast.success(`Message deleted`);
        setMessages((prevMessages) =>
          prevMessages.filter((message) => message.id !== messageId)
        );
      })
      .catch(() => toast.error(`An error occurred while deleting the message`));
  };

  const openModal = async () => {
    setModalIsOpen(true);
    setHasNewMessages(false);

    try {
      await markAllMessagesAsRead(token);
    } catch (err) {
      console.error("Something went wrong, please try again later.");
    }
  };

  const closeModal = () => {
    setModalIsOpen(false);
  };

  const toggleReply = (id) => {
    setReplyOpen((prevState) => ({ ...prevState, [id]: !prevState[id] }));
  };

  return (
    <Box sx={{ marginTop: "80px", fontFamily: "Oswald, sans-serif" }}>
      <Typography variant="h1">Admin Dashboard</Typography>

      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          marginTop: "50px",
        }}
      >
        <Typography variant="h2">Users</Typography>
        <IconButton
          color="primary"
          onClick={openModal}
          sx={{ fontSize: "2rem" }}
        >
          <Badge color="error" variant="dot" invisible={!hasNewMessages}>
            <MailIcon fontSize="inherit" />
          </Badge>
        </IconButton>
      </Box>

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell align="center">User ID</TableCell>
              <TableCell align="center">Username</TableCell>
              <TableCell align="center">Email</TableCell>
              <TableCell align="center">Phone Number</TableCell>
              <TableCell align="center">Country</TableCell>
              <TableCell align="center"></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {users &&
              users.length > 0 &&
              users
                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                .map((user) => (
                  <React.Fragment key={user.id}>
                    <TableRow key={user.id}>
                      <TableCell align="center">{user.id}</TableCell>
                      <TableCell data-testid="username" align="center">
                        {user.username}
                      </TableCell>
                      <TableCell data-testid="email" align="center">
                        {user.email}
                      </TableCell>
                      <TableCell data-testid="phoneNumber" align="center">
                        {user.phoneNumber}
                      </TableCell>
                      <TableCell data-testid="country" align="center">
                        {user.country}
                      </TableCell>
                      <TableCell align="center">
                        <IconButton
                          aria-label="expand row"
                          size="small"
                          onClick={() =>
                            setOpen((prevOpen) => ({
                              ...prevOpen,
                              [user.id]: !prevOpen[user.id],
                            }))
                          }
                        >
                          {open[user.id] ? (
                            <KeyboardArrowUpIcon />
                          ) : (
                            <KeyboardArrowDownIcon />
                          )}
                        </IconButton>
                      </TableCell>
                    </TableRow>
                    <TableRow>
                      <TableCell
                        style={{ paddingBottom: 0, paddingTop: 0 }}
                        colSpan={6}
                      >
                        <Collapse
                          in={open[user.id]}
                          timeout="auto"
                          unmountOnExit
                        >
                          <Box margin={1}>
                            <Typography
                              variant="h6"
                              gutterBottom
                              component="div"
                            >
                              More Details
                            </Typography>
                            <Table size="small" aria-label="purchases">
                              <TableHead>
                                <TableRow>
                                  <TableCell>City</TableCell>
                                  <TableCell>Address</TableCell>
                                  <TableCell>Date Of Birth</TableCell>
                                  <TableCell>Name</TableCell>
                                  <TableCell>Surname</TableCell>
                                </TableRow>
                              </TableHead>
                              <TableBody>
                                <TableRow>
                                  <TableCell component="th" scope="row">
                                    {user.city}
                                  </TableCell>
                                  <TableCell>{user.address}</TableCell>
                                  <TableCell>{user.DateOfBirth}</TableCell>
                                  <TableCell>{user.name}</TableCell>
                                  <TableCell>{user.surname}</TableCell>
                                </TableRow>
                              </TableBody>
                            </Table>
                          </Box>
                        </Collapse>
                      </TableCell>
                    </TableRow>
                  </React.Fragment>
                ))}
          </TableBody>
        </Table>
        <TablePagination
          rowsPerPageOptions={[5, 10, 25]}
          component="div"
          count={users.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </TableContainer>

      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        contentLabel="User Messages"
        style={{
          overlay: {
            backgroundColor: "rgba(0, 0, 0, 0.75)",
            zIndex: 1000,
          },
          content: {
            top: "55%",
            left: "50%",
            right: "auto",
            bottom: "auto",
            transform: "translate(-50%, -50%)",
            backgroundColor: "#fff",
            border: "1px solid #ccc",
            borderRadius: "4px",
            padding: "2rem",
            width: "75%",
            height: "80%",
            zIndex: 1000,
          },
        }}
      >
        <IconButton
          onClick={closeModal}
          sx={{ position: "absolute", top: "1rem", left: "1rem" }}
        >
          <CloseIcon />
        </IconButton>
        <Typography sx={{ marginTop: "2rem" }} variant="h2">
          User Messages
        </Typography>

        {messages &&
          messages.length > 0 &&
          messages.map((message, index) => (
            <Box
              key={index}
              sx={{
                marginBottom: "2rem",
                borderBottom: "1px solid #ccc",
                paddingBottom: "2rem",
                display: "flex",
                flexDirection: "column",
                justifyContent: "space-between",
              }}
            >
              <Paper
                elevation={3}
                sx={{ padding: "1rem", marginBottom: "1rem" }}
              >
                <Typography variant="h6" sx={{ fontWeight: "bold" }}>
                  {message.username}
                </Typography>

                <Typography sx={{ fontWeight: "bold" }}>
                  {message.email}
                </Typography>

                <Typography sx={{ marginBottom: "1rem" }}>
                  {message.message}
                </Typography>
                <Box
                  sx={{
                    display: "flex",
                    flexDirection: "row-reverse",
                    justifyContent: "space-between",
                  }}
                >
                  <IconButton onClick={() => toggleReply(message.id)}>
                    <ReplyIcon />
                  </IconButton>
                  <ConfirmationDialog
                    onConfirm={() => handleDelete(message.id)}
                  >
                    <DeleteIcon color="error" />
                  </ConfirmationDialog>
                </Box>
              </Paper>
              {replyOpen[message.id] && (
                <>
                  <textarea
                    aria-label="empty textarea"
                    placeholder="Write a reply..."
                    style={{
                      marginTop: "1rem",
                      marginBottom: "1rem",
                      width: "100%",
                    }}
                    value={replyText[message.id] || ""}
                    onChange={(e) =>
                      setReplyText((prevText) => ({
                        ...prevText,
                        [message.id]: e.target.value,
                      }))
                    }
                    disabled={repliedStatus[message.id]}
                  />
                  <Box sx={{ display: "flex", justifyContent: "flex-end" }}>
                    <Button
                      variant="contained"
                      color="primary"
                      onClick={() => handleReply(message.id, message.email)}
                      disabled={repliedStatus[message.id]}
                    >
                      Send Reply
                    </Button>
                  </Box>
                </>
              )}
            </Box>
          ))}
      </Modal>

      <Container maxWidth="md" sx={{ marginTop: "50px" }}>
        <Typography variant="h2">Statistics</Typography>
        <Grid container spacing={2}>
          <Grid item sm={4}>
            <Card sx={{ minWidth: 275 }}>
              <CardContent>
                <Typography variant="h6" component="div">
                  Number of Users
                </Typography>
                <Typography variant="body1" component="div">
                  {users.length}
                </Typography>
              </CardContent>
            </Card>
          </Grid>

          <Grid item xs={12} sm={4}>
            <Card sx={{ minWidth: 275 }}>
              <CardContent>
                <Typography variant="h6" component="div">
                  Most Searched Destinations
                </Typography>
                <Typography variant="body1" component="div">
                  {mostSearchedDestinations &&
                    mostSearchedDestinations.map((destination, index) => (
                      <Typography key={index}>{destination}</Typography>
                    ))}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
          <Grid item xs={12} sm={4}>
            <Card sx={{ minWidth: 275 }}>
              <CardContent>
                <Typography variant="h6" component="div">
                  Number of Saved Flights
                </Typography>
                <Typography variant="body1" component="div">
                  {numberOfSavedFlights}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
          <Grid item xs={12} sm={4}>
            <Card sx={{ minWidth: 275 }}>
              <CardContent>
                <Typography variant="h6" component="div">
                  Number of Saved Hotels
                </Typography>
                <Typography variant="body1" component="div">
                  {numberOfSavedHotels}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
          <Grid item xs={12} sm={4}>
            <Card sx={{ minWidth: 275 }}>
              <CardContent>
                <Typography variant="h6" component="div">
                  Number of Saved Car Rentals
                </Typography>
                <Typography variant="body1" component="div">
                  {numberOfSavedCarRentals}
                </Typography>
              </CardContent>
            </Card>
          </Grid>
        </Grid>
      </Container>
      <Container
        maxWidth="md"
        sx={{ marginTop: "50px", paddingBottom: "50px" }}
      >
        <Typography variant="h2">Add Airport</Typography>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <AddAirportfrom countries={airports} token={token} />
          </Grid>
        </Grid>
      </Container>
    </Box>
  );
};

export default Admin;
