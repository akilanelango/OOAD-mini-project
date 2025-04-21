// src/pages/Register.js

import React, { useState } from 'react';
import axios from 'axios';
import './Register.css';

const Register = () => {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    role: 'student'
  });

  const [status, setStatus] = useState('');

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  // ✅ Make sure this is marked async!
  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("Within handleSubmit");
    try {
      const response = await axios.post('http://localhost:8080/api/users', formData);
      console.log('Success:', response.data);
      setStatus('Registration successful!');
    } catch (error) {
      console.error('Error:', error);
      setStatus('Registration failed.');
    }
  };

  return (
    <div className="register-container">
      <h2>User Registration</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="username" placeholder="Username" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
        <select name="role" onChange={handleChange}>
          <option value="STUDENT">Student</option>
          <option value="TEACHER">Teacher</option>
          <option value="COE">COE</option>
        </select>
        <button type="submit">Register</button>
      </form>
      {status && <p>{status}</p>}
    </div>
  );
};

export default Register;

