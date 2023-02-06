import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router';

const Login = () => {
	const [state, setState] = useState({
		email: '',
		password: '',
	});
	const [error, setError] = useState(false);

	const navigate = useNavigate();
	const loginCustomer = async (loginCreds) => {
		await axios
			.post('http://localhost:3030/api/v1/login', loginCreds)
			.then((data) => {
				console.log(data);
				navigate(`/customer/${data.data.id}`);
			})
			.catch((err) => {
				console.log(err);
				resetForm();
				setError(true);
			});
	};
	const resetForm = () => {
		setState({
			email: '',
			password: '',
		});
	};
	const handleChange = (event) => {
		const { name, value } = event.target;
		setState((prevState) => ({ ...prevState, [name]: value }));
	};
	const handleFormSubmit = (event) => {
		event.preventDefault();
		loginCustomer(state);
	};
	const CheckDetails = () => (
		<div className="alert alert-warning " role="alert">
			Check Customer Details
		</div>
	);

	return (
		<div className="container">
			<h1 className="display-3">Login</h1>
			{error && <CheckDetails />}
			<form onSubmit={handleFormSubmit}>
				<div className="mb-3">
					<label className="form-label">Email</label>
					<input
						type="email"
						required
						name="email"
						id="email"
						className="form-control"
						placeholder="email"
						value={state.email}
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label className="form-label">Password</label>
					<input
						type="password"
						required
						name="password"
						id="password"
						className="form-control"
						placeholder="Password"
						value={state.password}
						onChange={handleChange}
					/>
				</div>
				<br />
				<div className="mb-3">
					<input
						type="submit"
						className="btn btn-info"
						value="Create Customer"
					/>
				</div>
			</form>
		</div>
	);
};

export default Login;
