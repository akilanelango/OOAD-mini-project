import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const StudentDashboard = () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const [courses, setCourses] = useState([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    const fetchCourses = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/courses');
        setCourses(response.data);
      } catch (error) {
        console.error('Error fetching courses:', error);
      }
    };

    fetchCourses();
  }, []);

  const handleEnroll = async (courseId) => {
    const enrollment = {
      userId: user.userId,
      courseId: courseId,
      enrollmentDate: new Date().toISOString().split('T')[0]  // "YYYY-MM-DD"
    };

    try {
      const response = await axios.post('http://localhost:8080/api/enrollments', enrollment);
      console.log('Enrollment successful:', response.data);
      setMessage(`Successfully registered for course ID ${courseId}`);
    } catch (error) {
      console.error('Error during enrollment:', error);
      setMessage(`Enrollment failed for course ID ${courseId}`);
    }
  };

  return (
    <div className="dashboard-container">
      <h1>Welcome Student, {user?.username}!</h1>
      <h2>Available Courses</h2>

      {message && <p style={{ color: 'green' }}>{message}</p>}

      {courses.length > 0 ? (
        <table className="courses-table">
          <thead>
            <tr>
              <th>Course ID</th>
              <th>Name</th>
              <th>Domain</th>
              <th>Year Offered</th>
              <th>Action</th> {/* New column */}
            </tr>
          </thead>
          <tbody>
            {courses.map(course => (
              <tr key={course.courseId}>
                <td>{course.courseId}</td>
                <td>{course.name || 'N/A'}</td>
                <td>{course.domain || 'N/A'}</td>
                <td>{course.yearOffered || 'N/A'}</td>
                <td>
                  <button onClick={() => handleEnroll(course.courseId)}>
                    Register
                  </button>
                </td>
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

export default StudentDashboard;
