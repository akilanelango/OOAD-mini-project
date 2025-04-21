import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const COEDashboard = () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const [assessments, setAssessments] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [newAssessment, setNewAssessment] = useState({
    courseId: '',
    title: '',
    totalMarks: ''
  });

  useEffect(() => {
    fetchAssessments();
  }, []);

  const fetchAssessments = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/assessments');
      setAssessments(response.data);
    } catch (error) {
      console.error('Error fetching assessments:', error);
    }
  };

  const handleCreateClick = () => {
    setShowForm(true);
  };

  const handleChange = (e) => {
    setNewAssessment({
      ...newAssessment,
      [e.target.name]: e.target.value
    });
  };

  const handleCreateAssessment = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/assessments', newAssessment);
      alert('Assessment created successfully!');
      setShowForm(false);
      fetchAssessments();
    } catch (error) {
      console.error('Error creating assessment:', error);
      alert('Failed to create assessment');
    }
  };

  return (
    <div className="dashboard-container">
      <div className="header-row">
        <h1>Welcome COE, {user?.username}!</h1>
        <button className="create-button" onClick={handleCreateClick}>+ Create Assessment</button>
      </div>

      {showForm && (
        <form className="create-course-form" onSubmit={handleCreateAssessment}>
          <h3>Create New Assessment</h3>
          <input
            type="number"
            name="courseId"
            placeholder="Course ID"
            required
            onChange={handleChange}
          />
          <input
            type="text"
            name="title"
            placeholder="Assessment Title"
            required
            onChange={handleChange}
          />
          <input
            type="number"
            name="totalMarks"
            placeholder="Total Marks"
            required
            onChange={handleChange}
          />
          <button type="submit">Submit</button>
        </form>
      )}

      <h2>All Assessments</h2>
      {assessments.length > 0 ? (
        <table className="courses-table">
          <thead>
            <tr>
              <th>Assessment ID</th>
              <th>Course ID</th>
              <th>Title</th>
              <th>Total Marks</th>
            </tr>
          </thead>
          <tbody>
            {assessments.map(assess => (
              <tr key={assess.assessmentId}>
                <td>{assess.assessmentId}</td>
                <td>{assess.courseId}</td>
                <td>{assess.title}</td>
                <td>{assess.totalMarks}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No assessments found.</p>
      )}
    </div>
  );
};

export default COEDashboard;
