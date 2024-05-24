import React from 'react';

const Input = ({ label, value, onChange, ...rest }) => {
  return (
    <div className="input-group">
      <label>{label}</label>
      <input
        type="text"
        value={value}
        onChange={onChange}
        {...rest}
      />
    </div>
  );
};

export default Input;