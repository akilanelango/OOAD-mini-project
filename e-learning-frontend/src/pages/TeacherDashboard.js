import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const TeacherDashboard = () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const [courses, setCourses] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [newCourse, setNewCourse] = useState({
    name: '',
    domain: '',
    yearOffered: '',
    userId: user?.userId
  });

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/courses');
      setCourses(response.data);
    } catch (error) {
      console.error('Error fetching courses:', error);
    }
  };

  const handleCreateClick = () => {
    setShowForm(true);
  };

  const handleChange = (e) => {
    setNewCourse({
      ...newCourse,
      [e.target.name]: e.target.value
    });
  };

  const handleCreateCourse = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/courses', newCourse);
      alert('Course created successfully!');
      setShowForm(false);
      fetchCourses(); // refresh course list
    } catch (error) {
      console.error('Error creating course:', error);
      alert('Failed to create course');
    }
  };

  return (
    <div className="dashboard-container">
      <div className="header-row">
        <h1>Welcome Teacher, {user?.username}!</h1>
        <button className="create-button" onClick={handleCreateClick}>+ Create Course</button>
      </div>

      {showForm && (
        <form className="create-course-form" onSubmit={handleCreateCourse}>
          <h3>Create New Course</h3>
          <input type="text" name="name" placeholder="Course Name" required onChange={handleChange} />
          <input type="text" name="domain" placeholder="Domain" required onChange={handleChange} />
          <input type="number" name="yearOffered" placeholder="Year" required onChange={handleChange} />
          <button type="submit">Submit</button>
        </form>
      )}

      <h2>Courses on the Platform</h2>
      {courses.length > 0 ? (
        <table className="courses-table">
          <thead>
            <tr>
              <th>Course ID</th>
              <th>Name</th>
              <th>Domain</th>
              <th>Year Offered</th>
            </tr>
          </thead>
          <tbody>
            {courses.map(course => (
              <tr key={course.courseId}>
                <td>{course.courseId}</td>
                <td>{course.name || 'N/A'}</td>
                <td>{course.domain || 'N/A'}</td>
                <td>{course.yearOffered || 'N/A'}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No courses found.</p>
      )}
    </div>
  );
};

export default TeacherDashboard;
