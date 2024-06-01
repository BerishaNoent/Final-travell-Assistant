import React, { useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import DialogActions from "@mui/material/DialogActions";
import Button from "@mui/material/Button";

const ConfirmationDialog = ({ onConfirm, onCancel, children }) => {
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
    if (onCancel) {
      onCancel();
    }
  };

  const handleConfirm = () => {
    setOpen(false);
    if (onConfirm) {
      onConfirm();
    }
  };

  return (
    <>
      <Button onClick={handleOpen} sx={{ fontFamily: "Oswald, sans-serif" }}>
        {children}
      </Button>
      <Dialog
        open={open}
        onClose={handleClose}
        sx={{ fontFamily: "Oswald, sans-serif" }}
      >
        <DialogTitle sx={{ fontFamily: "Oswald, sans-serif" }}>
          Are you sure you want to delete this?
        </DialogTitle>
        <DialogActions sx={{ fontFamily: "Oswald, sans-serif" }}>
          <Button
            onClick={handleClose}
            sx={{ fontFamily: "Oswald, sans-serif" }}
          >
            Cancel
          </Button>
          <Button
            onClick={handleConfirm}
            color="error"
            sx={{ fontFamily: "Oswald, sans-serif" }}
          >
            Delete
          </Button>
        </DialogActions>
      </Dialog>
    </>
  );
};

export default ConfirmationDialog;
