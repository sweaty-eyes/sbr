import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';

const ShowUser = () => {
	const { id } = useParams();
	const [state, setState] = useState({
		firstName: '',
		lastName: '',
		age: 0,
		email: '',
		password: '',
	});
	useEffect(() => {
		axios
			.get(`http://localhost:3030/api/v1/customers/${id}`)
			.then((data) => setState({ ...data.data }))
			.catch((err) => console.log(err));
	}, [id]);
	return (
		<div className="container    ">
			<div className="card">
				<div className="card-body">
					<h4 className="card-title">{state.firstName}</h4>
					<p className="card-text">{state.email}</p>
				</div>
			</div>
		</div>
	);
};

export default ShowUser;
