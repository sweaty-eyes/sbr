import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';

const Welcome = () => {
	const [date, setDate] = useState(null);
	useEffect(() => {
		const nowDate = new Date();
        setDate(
			nowDate.toLocaleString('en-US', {
				weekday: 'long',
				year: 'numeric',
				month: 'short',
				day: 'numeric',
			})
		);
	}, []);
	return (
		<div>
			<Card className="text-center">
				<Card.Body>
					<Card.Title>Welcome To Customer Management</Card.Title>
					<Card.Text>Create a Customer or Login</Card.Text>
					<Link to="/login">
						<Button variant="secondary">Login</Button>
					</Link>{' '}
					<Link to="/add">
						<Button variant="info">Add Customer</Button>
					</Link>
				</Card.Body>
				<Card.Footer className="text-muted">{date}</Card.Footer>
			</Card>
		</div>
	);
};

export default Welcome;
