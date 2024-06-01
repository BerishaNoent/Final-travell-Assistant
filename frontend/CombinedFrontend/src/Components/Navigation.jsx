import React, { useContext, useState } from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import Container from "@mui/material/Container";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import MenuItem from "@mui/material/MenuItem";
import AdbIcon from "@mui/icons-material/Adb";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import { TokenContext, useToken } from "../context/TokenContext";
import Cookies from "js-cookie";

const pages = ["Search", "Contact Us", "Table"];
const settings = ["Account", "Logout"];

function ResponsiveAppBar() {
  const [anchorElNav, setAnchorElNav] = React.useState(null);
  const [anchorElUser, setAnchorElUser] = React.useState(null);
  const location = useLocation();
  const navigate = useNavigate();
  const userData = useToken();
  const {
    role,
    name,
    surname,
    setToken,
    setUserId,
    setRole,
    setContextEmail,
    setContextUsername,
    setContextPhoneNumber,
    setContextCountry,
    setContextCity,
    setContextAddress,
    setContextDateOfBirth,
    setContextName,
    setContextSurname,
  } = userData;
  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleLogout = () => {
    handleCloseUserMenu();

    Cookies.remove("token");
    Cookies.remove("userId");
    Cookies.remove("role");
    Cookies.remove("email");
    Cookies.remove("username");
    Cookies.remove("phoneNumber");
    Cookies.remove("country");
    Cookies.remove("city");
    Cookies.remove("address");
    Cookies.remove("dateOfBirth");
    Cookies.remove("name");
    Cookies.remove("surname");

    setToken((prev) => null);
    setUserId((prev) => null);
    setRole((prev) => null);
    setContextEmail((prev) => null);
    setContextUsername((prev) => null);
    setContextPhoneNumber((prev) => null);
    setContextCountry((prev) => null);
    setContextCity((prev) => null);
    setContextAddress((prev) => null);
    setContextDateOfBirth((prev) => null);
    setContextName((prev) => null);
    setContextSurname((prev) => null);

    navigate("/login");
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (
    <AppBar position="fixed">
      <Container>
        <Toolbar disableGutters>
          <AdbIcon sx={{ display: { xs: "none", md: "flex" }, mr: 1 }} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: "none", md: "flex" },
              fontFamily: "Oswald, sans-serif",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            Travelling Assistant
          </Typography>

          <Box sx={{ flexGrow: 1 }} />

          <Box sx={{ display: "flex", alignItems: "center" }}>
            <Box sx={{ flexGrow: 1, display: { xs: "none", md: "flex" } }}>
              <Button
                component={NavLink}
                to="/search"
                disableRipple
                onClick={handleCloseNavMenu}
                sx={(theme) => ({
                  my: 2,
                  color: "white",
                  display: "block",
                  position: "relative",
                  "&::after": {
                    content: '""',
                    position: "absolute",
                    bottom: 0,
                    left: "50%",
                    width: location.pathname === "/search" ? "100%" : 0,
                    transform:
                      location.pathname === "/search"
                        ? "translateX(-50%)"
                        : "translateX(0)",
                    borderBottom: "2px solid white",
                    transition: "all 0.3s ease-in-out",
                    fontFamily: "Oswald",
                  },
                })}
              >
                Search
              </Button>
              <Button
                component={NavLink}
                to="/contact-us"
                disableRipple
                onClick={handleCloseNavMenu}
                sx={(theme) => ({
                  my: 2,
                  color: "white",
                  display: "block",
                  position: "relative",
                  "&::after": {
                    content: '""',
                    position: "absolute",
                    bottom: 0,
                    left: "50%",
                    width: location.pathname === "/contact-us" ? "100%" : 0,
                    transform:
                      location.pathname === "/contact-us"
                        ? "translateX(-50%)"
                        : "translateX(0)",
                    borderBottom: "2px solid white",
                    transition: "all 0.3s ease-in-out",
                    fontFamily: "Oswald",
                  },
                })}
              >
                Contact Us
              </Button>
              {role === "ADMIN" && (
                <Button
                  component={NavLink}
                  to="/admin"
                  disableRipple
                  onClick={handleCloseNavMenu}
                  sx={(theme) => ({
                    my: 2,
                    color: "white",
                    display: "block",
                    position: "relative",
                    "&::after": {
                      content: '""',
                      position: "absolute",
                      bottom: 0,
                      left: "50%",
                      width: location.pathname === "/admin" ? "100%" : 0,
                      transform:
                        location.pathname === "/admin"
                          ? "translateX(-50%)"
                          : "translateX(0)",
                      borderBottom: "2px solid white",
                      transition: "all 0.3s ease-in-out",
                      fontFamily: "Oswald",
                    },
                  })}
                >
                  Admin
                </Button>
              )}
              {!name && !surname && (
                <Button
                  component={NavLink}
                  to="/login"
                  disableRipple
                  onClick={handleCloseNavMenu}
                  sx={(theme) => ({
                    my: 2,
                    color: "white",
                    display: "block",
                    position: "relative",
                    "&::after": {
                      content: '""',
                      position: "absolute",
                      bottom: 0,
                      left: "50%",
                      width: location.pathname === "/login" ? "100%" : 0,
                      transform:
                        location.pathname === "/login"
                          ? "translateX(-50%)"
                          : "translateX(0)",
                      borderBottom: "2px solid white",
                      transition: "all 0.3s ease-in-out",
                      fontFamily: "Oswald",
                    },
                  })}
                >
                  Login
                </Button>
              )}
            </Box>

            <Tooltip title="Open settings">
              {name && surname && (
                <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                  <Avatar>
                    {name[0]}
                    {surname[0]}
                  </Avatar>
                </IconButton>
              )}
            </Tooltip>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElUser}
              anchorOrigin={{
                vertical: "top",
                horizontal: "right",
              }}
              keepMounted
              transformOrigin={{
                vertical: "top",
                horizontal: "right",
              }}
              open={Boolean(anchorElUser)}
              onClose={handleCloseUserMenu}
            >
              <MenuItem
                component={NavLink}
                to="/account"
                onClick={handleCloseUserMenu}
              >
                <Typography
                  textAlign="center"
                  sx={{ fontFamily: "Oswald, sans-serif" }}
                >
                  Account
                </Typography>
              </MenuItem>
              <MenuItem onClick={handleLogout}>
                <Typography
                  textAlign="center"
                  sx={{ fontFamily: "Oswald, sans-serif" }}
                >
                  Logout
                </Typography>
              </MenuItem>
            </Menu>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default ResponsiveAppBar;
