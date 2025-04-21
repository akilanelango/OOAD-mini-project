import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Login.css';

const Login = () => {
  const [formData, setFormData] = useState({ username: '', password: '' });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
	e.preventDefault();
	setError('');
	try {
		const response = await axios.post('http://localhost:8080/api/users/login', formData);
		const user = response.data;
		localStorage.setItem('user', JSON.stringify(user));

		// Redirect based on role
		if (user.role === 'STUDENT') navigate('/student-dashboard');
		else if (user.role === 'TEACHER') navigate('/teacher-dashboard');
		else if (user.role === 'COE') navigate('/coe-dashboard');
		else navigate('/login'); // fallback
	} catch (err) {
		setError('Invalid username or password');
	}
	};


  return (
    <div className="login-container">
      <h2>User Login</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="username" placeholder="Username" required onChange={handleChange} />
        <input type="password" name="password" placeholder="Password" required onChange={handleChange} />
        <button type="submit">Login</button>
      </form>
      {error && <p className="error-msg">{error}</p>}
    </div>
  );
};

export default Login;
