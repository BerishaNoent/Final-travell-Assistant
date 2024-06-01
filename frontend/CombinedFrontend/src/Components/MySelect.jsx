import React from 'react';
import Select from 'react-select';
import makeAnimated from 'react-select/animated';

const animatedComponents = makeAnimated();

const filterOption = (option, rawInput) => {
    const words = rawInput.split(' ').map(word => word.toLowerCase());
    const optionWords = [
      ...option.label.split(' '),
      ...(option.data.country ? option.data.country.split(' ') : []),
      ...(option.data.region ? option.data.region.split(' ') : [])
    ].map(word => word.toLowerCase());
  
    return words.every(word => optionWords.some(optionWord => optionWord.startsWith(word)));
  };

const MySelect = ({ options, ...props }) => (
  <Select
  className='my-select'
    components={animatedComponents}
    filterOption={filterOption}
    options={options}
    styles={{
        control: (base) => ({
          ...base,
          height: 30,
          minHeight: 30,
          marginTop: '-4px',
        
        }),
        dropdownIndicator: (base) => ({
          ...base,
          marginTop: '-2px',
          height: '30px',
          
        }),
        clearIndicator: (base) => ({
          ...base,
          padding: 2,
          marginTop: '-4px',
        }),
        multiValue: (base) => ({
          ...base,
          marginTop: '-4px',
        }),
        valueContainer: (base) => ({
          ...base,
          padding: '0 6px',
          height: '30px',
          
        }),
        input: (base) => ({
          ...base,
          marginTop: '-15px',
        }),
        indicatorSeparator: () => ({
            display:"none",
          }),
      }}
    {...props}
  />
);

export default MySelect;