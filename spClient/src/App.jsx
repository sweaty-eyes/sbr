import Appbar from './components/Appbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Welcome from './components/Welcome';
import CreateUser from './components/CreateUser';
import Login from './components/Login';
import ShowUser from './components/ShowUser';

function App() {
	return (
		<div>
			<Router>
				<Appbar />
				<br />
				<Routes>
					<Route path="/" exact element={<Welcome />} />
					<Route path="/add" element={<CreateUser />} />
					<Route path="/login" element={<Login />} />
					<Route path="/customer/:id" element={<ShowUser />} />
				</Routes>
			</Router>
		</div>
	);
}

export default App;
