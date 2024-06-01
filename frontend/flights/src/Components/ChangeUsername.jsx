// import { Editable, EditableInput, EditablePreview, useEditableControls, ButtonGroup, IconButton, Flex } from "@chakra-ui/react";
// import { CheckIcon, CloseIcon, EditIcon } from "@chakra-ui/icons";

// function CustomControlsExample({ changeUsername, setChangeUsername }) {
//   /* Here's a custom control */
//   function EditableControls() {
//     const {
//       isEditing,
//       getSubmitButtonProps,
//       getCancelButtonProps,
//       getEditButtonProps,
//     } = useEditableControls();

//     return isEditing ? (
//       <ButtonGroup justifyContent='center' size='sm'>
//         <IconButton icon={<CheckIcon />} {...getSubmitButtonProps()} />
//         <IconButton icon={<CloseIcon />} {...getCancelButtonProps()} />
//       </ButtonGroup>
//     ) : (
//       <Flex justifyContent='center'>
//         <IconButton size='sm' icon={<EditIcon />} {...getEditButtonProps()} />
//       </Flex>
//     )
//   }

//   return (
// <Editable
//   textAlign='center'
//   value={changeUsername}
//   onChange={setChangeUsername}
//    fontSize= '2em'  // Increase the font size here
//   isPreviewFocusable={false}
// >
//   {({ isEditing }) => (
//     <>
//       {isEditing ? <EditableInput size="lg" /> : <EditablePreview size="lg" />}
//       <EditableControls />
//     </>
//   )}
// </Editable>
//   )
// }

// export default CustomControlsExample;