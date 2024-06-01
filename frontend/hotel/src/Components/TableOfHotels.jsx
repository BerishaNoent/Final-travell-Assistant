import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
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
import TextField from "@mui/material/TextField";
import Fab from "@mui/material/Fab";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import OutlinedInput from "@mui/material/OutlinedInput";
import FavoriteIcon from "@mui/icons-material/Favorite";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import { filterHotels, sortHotels, addHotel } from "../Api.js";
import Input from "@mui/material/Input";
import InputAdornment from "@mui/material/InputAdornment";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import Accordion from "@mui/material/Accordion";
import AccordionSummary from "@mui/material/AccordionSummary";
import AccordionDetails from "@mui/material/AccordionDetails";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import { useNavigate } from "react-router-dom";
import Modal from "react-modal";
import CloseIcon from "@mui/icons-material/Close";
import HotelDetails from "../Components/ExtraInfo.jsx";
import { toast } from "react-toastify";
import StarRatings from "react-star-ratings";
import { Rating } from "@mui/material";

function Row({ row, userLoggedData }) {
  const { token, userId } = userLoggedData;
  const [open, setOpen] = React.useState(false);
  // const navigate = useNavigate();
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [wishlistClicked, setWishlistClicked] = React.useState(false);

  useEffect(() => {
    Modal.setAppElement("#app");
  }, []);

  const handleWishlistClick = async () => {
    try {
      if (!wishlistClicked) {
        const response = await addHotel(row, userId, token);
        if (response.status === 200) {
          // HttpStatus.OK
          setWishlistClicked(true);
          toast.success("Hotel added to wishlist successfully");
          toast.info("You can remove saved hotels from your account page");
        } else {
          toast.error("Failed to add the hotel to wishlist");
        }
      }
    } catch (error) {
      if (error.status === 409) {
        toast.error("Hotel already added to wishlist");
      } else {
        toast.error("Failed to add the hotel to wishlist");
      }
    }
  };

  const openModal = () => {
    setModalIsOpen(true);
  };

  const closeModal = () => {
    setModalIsOpen(false);
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
        <TableCell
          align="center"
          component="th"
          scope="row"
          style={{ display: "none" }}
        >
          {row.id}
        </TableCell>
        <TableCell align="center">
          <img
            src={row.imageUrl}
            alt={row.name}
            style={{ width: "50px", height: "50px" }}
          />
        </TableCell>
        <TableCell align="center">{row.name}</TableCell>
        <TableCell align="center">{row.city}</TableCell>
        <TableCell align="center">{row.country}</TableCell>
        <TableCell align="center">
          <div style={{ display: "inline-block", whiteSpace: "nowrap" }}>
            <StarRatings
              rating={row.starRating ? parseFloat(row.starRating) : 0}
              starDimension="15px"
              starSpacing="2px"
              starRatedColor="gold"
            />
          </div>
        </TableCell>
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
                Hotel Details
              </Typography>
              <Table size="small" aria-label="purchases">
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Address</TableCell>
                    <TableCell align="center">Minimum Price</TableCell>
                    <TableCell align="center">Hotel Rank</TableCell>
                    <TableCell align="center">Review Rating</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  <TableRow>
                    <TableCell align="center">{row.address}</TableCell>
                    <TableCell align="center">{row.minPrice}</TableCell>
                    <TableCell align="center">{row.hotelRank}</TableCell>
                    <TableCell align="center">{row.reviewRating}</TableCell>
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
    (row) => row.minPrice != null && row.starRating != null
  );
  const [filteredHotels, setFilteredHotels] = React.useState(filteredRows);
  const [minPrice, setMinPrice] = React.useState("");
  const [starRating, setStarRating] = React.useState("");
  const [sortOrder, setSortOrder] = React.useState("");
  const [sortField, setSortField] = React.useState("");
  const [displayedRowsCount, setDisplayedRowsCount] = React.useState(
    filteredRows.length
  );

  useEffect(() => {
    Modal.setAppElement("#app");
  }, []);

  const handleSort = async (sortField, sortOrder) => {
    const rowsWithCleanedPrice = filteredRows.map((row) => ({
      ...row,
      minPrice: row.minPrice.replace("$", ""),
    }));
    const sortedHotels = await sortHotels(
      rowsWithCleanedPrice,
      sortField,
      sortOrder
    );
    setFilteredHotels(sortedHotels.body);
    setSortOrder(sortOrder);
  };

  const clearSort = () => {
    setSortOrder("");
    setSortField("");
    setFilteredHotels(filteredRows);
  };

  const filterHotel = async (minPrice, starRating) => {
    if (minPrice === "" && starRating === "") {
      return;
    }
    const rowsWithCleanedPrice = filteredRows.map((row) => ({
      ...row,
      minPrice: row.minPrice.replace("$", ""),
    }));
    try {
      const response = await filterHotels(
        rowsWithCleanedPrice,
        minPrice,
        starRating
      );
      setFilteredHotels(response.body);
      setDisplayedRowsCount(response.body.length);
    } catch (error) {
      toast.error("Failed to filter hotels");
    }
  };

  const clearFilters = () => {
    setFilteredHotels(filteredRows);
    setMinPrice("");
    setStarRating("");
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
            data-testid="accordion-summary"
          >
            <Typography>Filters</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Box display="flex" flexDirection="column">
              <Box mb={1}>
                <Input
                  id="min-price"
                  startAdornment={
                    <InputAdornment position="start">Min Price</InputAdornment>
                  }
                  value={minPrice}
                  onChange={(e) => setMinPrice(e.target.value)}
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
                mb={1}
                display={"flex"}
                flexDirection={"row"}
                justifyContent={"space-between"}
                alignContent={"center"}
              >
                <InputLabel>Star Rating</InputLabel>
                <Rating
                  name="star-rating"
                  value={parseInt(starRating, 10)}
                  onChange={(event, newValue) => {
                    setStarRating(newValue);
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
                    data-testid="apply-button"
                    size="small"
                    color="primary"
                    onClick={() => filterHotel(minPrice, starRating)}
                  >
                    Apply
                  </Fab>
                </Box>
                <Box mr={1}>
                  <Fab
                    variant="extended"
                    size="small"
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
            <Box display="flex" flexDirection="column">
              <FormControl
                variant="outlined"
                size="small"
                style={{
                  minWidth: 120,
                  marginBottom: 5,
                  padding: "2rem",
                  backgroundColor: "#f8f9fa",
                  borderRadius: "15px",
                }}
              >
                <InputLabel id="sort-field-label" size="small">
                  Sort By
                </InputLabel>
                <Select
                  labelId="sort-field-label"
                  id="sort-field"
                  value={sortField}
                  onChange={(e) => setSortField(e.target.value)}
                  label="Sort By"
                  size="small"
                  aria-label="Sort Field Select"
                >
                  <MenuItem id="price" value={"price"}>
                    Price
                  </MenuItem>
                  <MenuItem value={"starRating"}>Star Rating</MenuItem>
                </Select>
              </FormControl>
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
                    onClick={() => handleSort(sortField, "asc")}
                  >
                    Asc
                  </Fab>
                </Box>
                <Box mr={1}>
                  <Fab
                    variant="extended"
                    size="small"
                    color="primary"
                    onClick={() => handleSort(sortField, "desc")}
                  >
                    Desc
                  </Fab>
                </Box>
                <Box mr={1}>
                  <Fab
                    variant="extended"
                    size="small"
                    color="secondary"
                    data-testid="clear-button"
                    onClick={clearSort}
                  >
                    Clear
                  </Fab>
                </Box>
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
                <TableCell align="center">Image</TableCell>
                <TableCell align="center">Name</TableCell>
                <TableCell align="center">City</TableCell>
                <TableCell align="center">Country</TableCell>
                <TableCell align="center">Star Rating</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {filteredHotels &&
                filteredHotels.length > 0 &&
                filteredHotels
                  .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                  .map((row, index) => (
                    <Row
                      key={index}
                      row={row}
                      userLoggedData={userLoggedData}
                    />
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
            rowsPerPageOptions={[rowsPerPage]} // Add this line
          />
        </TableContainer>
      </Grid>
    </Grid>
  );
}
