import React, { useState } from 'react';
import { useNavigate } from 'react-router';
import axios from 'axios';

const CreateUser = () => {
	const [state, setState] = useState({
		firstName: '',
		lastName: '',
		age: 0,
		email: '',
		password: '',
	});
	const handleChange = (event) => {
		const { name, value } = event.target;
		setState((prevState) => ({ ...prevState, [name]: value }));
	};
	const saveCustomer = async (customer) => {
		await axios
			.post('http://localhost:3030/api/v1/customers/add', customer)
			.then((data) => console.log(data.data))
			.catch((err) => console.log(err));
	};
	const navigate = useNavigate();
	const handleFormSubmit = (event) => {
		event.preventDefault();
		saveCustomer(state);
		navigate('/');
	};
	return (
		<div className="container">
			<h1 className="display-2">Create User</h1>
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
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label className="form-label">First Name</label>
					<input
						type="text"
						required
						name="firstName"
						id="firstName"
						className="form-control"
						placeholder="First Name"
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label className="form-label">Last Name</label>
					<input
						type="text"
						required
						name="lastName"
						id="lastName"
						className="form-control"
						placeholder="Last Name"
						onChange={handleChange}
					/>
				</div>
				<div className="mb-3">
					<label className="form-label">Age</label>
					<input
						type="number"
						required
						name="age"
						id="age"
						className="form-control"
						placeholder="Age"
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

export default CreateUser;
