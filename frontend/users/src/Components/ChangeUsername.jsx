import React, { useState } from "react";
import {
  Editable,
  EditableInput,
  EditablePreview,
  useEditableControls,
  ButtonGroup,
  IconButton,
  Flex,
} from "@chakra-ui/react";
import { CheckIcon, CloseIcon, EditIcon } from "@chakra-ui/icons";
import { toast } from "react-toastify";
import { changeUsername as changeUsernameApi } from "../Api";

function CustomControlsExample({ username, changeUsername, token }) {
  function EditableControls() {
    const {
      isEditing,
      getSubmitButtonProps,
      getCancelButtonProps,
      getEditButtonProps,
    } = useEditableControls();

    return isEditing ? (
      <ButtonGroup justifyContent="center" size="sm">
        <IconButton icon={<CheckIcon />} {...getSubmitButtonProps()} />
        <IconButton icon={<CloseIcon />} {...getCancelButtonProps()} />
      </ButtonGroup>
    ) : (
      <Flex justifyContent="center">
        <IconButton size="sm" icon={<EditIcon />} {...getEditButtonProps()} />
      </Flex>
    );
  }

  const [newUsername, setNewUsername] = useState(changeUsername);

  const handleSubmit = async () => {
    try {
      await changeUsernameApi(changeUsername, newUsername, token);
    } catch (error) {
      toast.error(error); // handle error as needed
    }
  };

  return (
    <Editable
      textAlign="center"
      value={newUsername}
      onChange={setNewUsername}
      onSubmit={handleSubmit}
      fontSize="2em"
      fontFamily="Oswald"
      isPreviewFocusable={false}
    >
      {({ isEditing }) => (
        <>
          {isEditing ? (
            <EditableInput size="lg" />
          ) : (
            <EditablePreview size="lg" />
          )}
          <EditableControls />
        </>
      )}
    </Editable>
  );
}

export default CustomControlsExample;
