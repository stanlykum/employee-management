import React from 'react';

const Button = ({ children, onClick, className, ...rest }) => {
  return (
    <button
      onClick={onClick}
      className={`btn ${className}`}
      {...rest}
    >
      {children}
    </button>
  );
};

export default Button;