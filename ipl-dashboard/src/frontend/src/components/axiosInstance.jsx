import axios from 'axios';


const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080', // Replace with the URL of your backend API
  headers: {
    'Content-Type': 'application/json'
  }
});

export default axiosInstance;