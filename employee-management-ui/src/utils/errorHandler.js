export const handleErrorResponse = (error) => {
    if (error.response) {
      // The request was made and the server responded with a status code
      // that falls out of the range of 2xx
      if (error.response.status === 404) {
        // Handle 404 Not Found error
        return { message: error.response.data.message };
      } else {
        // Handle other error responses
        return error.response.data;
      }
    } else if (error.request) {
      // The request was made but no response was received
      console.error('No response received from the server');
    } else {
      // Something happened in setting up the request that triggered an error
      console.error('Error', error.message);
    }
  
    // If no specific error data is available, return a default error object
    return { message: 'An unexpected error occurred' };
  };
  