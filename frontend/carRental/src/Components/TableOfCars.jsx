import * as React from "react";
import Box from "@mui/material/Box";
import Collapse from "@mui/material/Collapse";
import IconButton from "@mui/material/IconButton";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Typography from "@mui/material/Typography";
import Paper from "@mui/material/Paper";
import KeyboardArrowDownIcon from "@mui/icons-material/KeyboardArrowDown";
import KeyboardArrowUpIcon from "@mui/icons-material/KeyboardArrowUp";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";
import TablePagination from "@mui/material/TablePagination";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FavoriteIcon from "@mui/icons-material/Favorite";
import { addCarRental, filterCarRentals, sortCars } from "../Api.js";
import Fab from "@mui/material/Fab";
import Input from "@mui/material/Input";
import InputAdornment from "@mui/material/InputAdornment";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import Accordion from "@mui/material/Accordion";
import AccordionSummary from "@mui/material/AccordionSummary";
import AccordionDetails from "@mui/material/AccordionDetails";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import { toast } from "react-toastify";
import { InputLabel } from "@mui/material";
import Modal from "react-modal";
import CloseIcon from "@mui/icons-material/Close";

export function Row({ row, userLoggedData }) {
  const { token, userId } = userLoggedData;
  const [open, setOpen] = React.useState(false);

  const [wishlistClicked, setWishlistClicked] = React.useState(false);
  const [modalIsOpen, setModalIsOpen] = React.useState(false);

  const openModal = () => {
    setModalIsOpen(true);
  };

  const closeModal = () => {
    setModalIsOpen(false);
  };

  const handleWishlistClick = async () => {
    try {
      if (!wishlistClicked) {
        const response = await addCarRental(row, userId, token);
        if (response.status === 200) {
          toast.success("Car rental added to wishlist successfully");
          toast.info("You can remove saved car rentals from your account page");
          setWishlistClicked(true);
        } else {
          toast.error("Failed to add the car rental to wishlist");
        }
      }
    } catch (error) {
      if (error.status === 409) {
        // HttpStatus.CONFLICT
        toast.error("Car Rental already added to wishlist");
      } else {
        toast.error("Failed to add the car rental to wishlist");
      }
    }
  };

  return (
    <React.Fragment>
      <TableRow sx={{ "& > *": { borderBottom: "unset" } }}>
        <TableCell>
          <IconButton
            aria-label="expand row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
        </TableCell>
        <TableCell component="th" scope="row" style={{ display: "none" }}>
          {row.id}
        </TableCell>
        <TableCell align="center">
          <img
            src={row.carImage}
            alt={row.carName}
            style={{ width: "50px", height: "50px" }}
          />
        </TableCell>
        <TableCell align="center">{row.carName}</TableCell>
        <TableCell align="center">{row.price}</TableCell>
        <TableCell align="center">{row.currency}</TableCell>
        <TableCell align="center">{row.rating}</TableCell>
        <TableCell align="center">
          <IconButton onClick={handleWishlistClick}>
            {wishlistClicked ? <FavoriteIcon /> : <FavoriteBorderIcon />}
          </IconButton>
        </TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            <Box sx={{ margin: 1 }}>
              <Typography variant="h6" gutterBottom component="div">
                Car Rental Details
              </Typography>
              <Table size="small" aria-label="purchases">
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Supplier Name</TableCell>
                    <TableCell align="center">Supplier Image</TableCell>
                    <TableCell align="center">Supplier Address</TableCell>
                    <TableCell align="center">Badges</TableCell>
                    <TableCell align="center">Transmission</TableCell>
                    <TableCell align="center">Seats</TableCell>
                    <TableCell align="center">Base Deposit</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  <TableRow>
                    <TableCell align="center">{row.supplierName}</TableCell>
                    <TableCell align="center">
                      <img
                        src={row.supplierImage}
                        alt={row.supplierName}
                        style={{ width: "50px", height: "50px" }}
                      />
                    </TableCell>
                    <TableCell align="center">{row.supplierAddress}</TableCell>
                    <TableCell align="center">
                      {row.badges ? row.badges.join(", ") : ""}
                    </TableCell>
                    <TableCell align="center">{row.transmission}</TableCell>
                    <TableCell align="center">{row.seats}</TableCell>
                    <TableCell align="center">{row.baseDeposit}</TableCell>
                  </TableRow>
                </TableBody>
              </Table>

              <Button
                variant="contained"
                style={{ backgroundColor: "#0000A0", marginTop: "20px" }}
                onClick={openModal}
              >
                See More
              </Button>

              <Modal
                isOpen={modalIsOpen}
                onRequestClose={closeModal}
                contentLabel="Hotel Details"
                style={{
                  overlay: {
                    backgroundColor: "rgba(0, 0, 0, 0.75)",
                  },
                  content: {
                    color: "lightsteelblue",
                  },
                }}
              >
                {/* Here you can render the component you want to show in the modal */}
                <IconButton onClick={closeModal}>
                  <CloseIcon />
                </IconButton>
                {/* <HotelDetails hotel={hotel} /> */}
              </Modal>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </React.Fragment>
  );
}

export default function CollapsibleTable({ rows, userLoggedData }) {
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(5);
  const filteredRows = rows.filter(
    (row) => row.price !== null && row.price !== "null"
  );
  const [filteredCarRentals, setFilteredCarRentals] =
    React.useState(filteredRows);
  const [rating, setRating] = React.useState("");
  const [price, setPrice] = React.useState("");
  const [transmission, setTransmission] = React.useState("");
  const [seats, setSeats] = React.useState("");
  const [sortOrder, setSortOrder] = React.useState("");
  const [displayedRowsCount, setDisplayedRowsCount] = React.useState(
    filteredRows.length
  );

  const handleSort = async (sortOrder) => {
    const sortedCars = await sortCars(filteredRows, sortOrder);
    console.log(sortedCars);
    setFilteredCarRentals(sortedCars.body);
    setSortOrder(sortOrder);
  };

  const clearSort = () => {
    setSortOrder("");
    setFilteredCarRentals(filteredRows);
  };

  const filterCarRental = async () => {
    try {
      const response = await filterCarRentals(
        filteredRows,
        rating,
        transmission,
        seats,
        price
      );
      console.log(response);
      setFilteredCarRentals(response.body);
      setDisplayedRowsCount(response.body.length);
    } catch (error) {
      toast.error("Failed to filter car rentals");
    }
  };

  const clearFilters = () => {
    setFilteredCarRentals(filteredRows);
    setRating("");
    setPrice("");
    setTransmission("");
    setSeats("");
    setDisplayedRowsCount(filteredRows.length);
  };

  return (
    <Grid
      container
      spacing={3}
      alignItems="center"
      justifyContent="center"
      sx={{ fontFamily: "Oswald, sans-serif" }}
    >
      <Grid item xs={3}>
        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography>Filters</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Box display="flex" flexDirection="column">
              <Box mb={1}>
                <Input
                  id="rating"
                  startAdornment={
                    <InputAdornment position="start">Rating</InputAdornment>
                  }
                  value={rating}
                  onChange={(e) => setRating(e.target.value)}
                  disableUnderline
                  placeholder="From 1-10"
                  sx={{
                    "& input": {
                      border: "1px solid #000",
                      borderRadius: "4px",
                      padding: "2px",
                    },
                  }}
                />
              </Box>
              <Box
                mb={1}
                display={"flex"}
                flexDirection={"row"}
                justifyContent={"space-between"}
                alignItems={"center"}
              >
                <InputLabel id="transmission-label">Transmission</InputLabel>
                <Select
                  labelId="transmission-label"
                  id="transmission"
                  value={transmission}
                  onChange={(e) => setTransmission(e.target.value)}
                >
                  <MenuItem value="Automatic">Automatic</MenuItem>
                  <MenuItem value="Manual">Manual</MenuItem>
                </Select>
              </Box>
              <Box mb={1}>
                <Input
                  id="seats"
                  startAdornment={
                    <InputAdornment position="start">Seats</InputAdornment>
                  }
                  value={seats}
                  onChange={(e) => setSeats(e.target.value)}
                  disableUnderline
                  sx={{
                    "& input": {
                      border: "1px solid #000",
                      borderRadius: "4px",
                      padding: "2px",
                    },
                  }}
                />
              </Box>
              <Box mb={1}>
                <Input
                  id="price"
                  startAdornment={
                    <InputAdornment position="start">Price</InputAdornment>
                  }
                  value={price}
                  onChange={(e) => setPrice(e.target.value)}
                  disableUnderline
                  sx={{
                    "& input": {
                      border: "1px solid #000",
                      borderRadius: "4px",
                      padding: "2px",
                    },
                  }}
                />
              </Box>
              <Box
                display={"flex"}
                justifyContent={"center"}
                alignItems={"center"}
                mt={2}
              >
                <Box mr={1}>
                  <Fab
                    variant="extended"
                    color="primary"
                    onClick={() =>
                      filterCarRental(rating, transmission, seats, price)
                    }
                  >
                    Apply
                  </Fab>
                </Box>
                <Box mr={1}>
                  <Fab
                    variant="extended"
                    color="secondary"
                    onClick={clearFilters}
                  >
                    Clear
                  </Fab>
                </Box>
              </Box>
            </Box>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel2a-content"
            id="panel2a-header"
          >
            <Typography>Sort By</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Box
              display={"flex"}
              justifyContent={"center"}
              alignItems={"center"}
            >
              <Box mr={1}>
                <Fab
                  variant="extended"
                  size="small"
                  color="primary"
                  onClick={() => handleSort("asc")}
                >
                  Asc
                </Fab>
              </Box>
              <Box mr={1}>
                <Fab
                  variant="extended"
                  size="small"
                  color="primary"
                  onClick={() => handleSort("desc")}
                >
                  Desc
                </Fab>
              </Box>
              <Box mr={1}>
                <Fab
                  variant="extended"
                  size="small"
                  color="secondary"
                  onClick={clearSort}
                >
                  Clear
                </Fab>
              </Box>
            </Box>
          </AccordionDetails>
        </Accordion>
      </Grid>
      <Grid item xs={9}>
        <TableContainer component={Paper} style={{ width: "700px" }}>
          <Table aria-label="collapsible table">
            <TableHead>
              <TableRow>
                <TableCell />

                <TableCell align="center">Car Image</TableCell>
                <TableCell align="center">Car Name</TableCell>
                <TableCell align="center">Price</TableCell>
                <TableCell align="center">Currency</TableCell>
                <TableCell align="center">Rating</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {filteredCarRentals
                .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                .map((row, index) => (
                  <Row key={index} row={row} userLoggedData={userLoggedData} />
                ))}
            </TableBody>
          </Table>
          <TablePagination
            component="div"
            count={displayedRowsCount}
            page={page}
            onPageChange={(event, newPage) => setPage(newPage)}
            rowsPerPage={rowsPerPage}
            onRowsPerPageChange={(event) =>
              setRowsPerPage(parseInt(event.target.value, 10))
            }
            rowsPerPageOptions={[rowsPerPage]}
          />
        </TableContainer>
      </Grid>
    </Grid>
  );
}
