import React, { useState } from 'react';
import logo from './Lorens.jpg';
import './App.css';
import CreateEmployee from './CreateEmployee';
import GetAllEmployees from './GetAllEmployees';

function App() {
    const [showTable, setShowTable] = useState(false);

    const handleGetAllClick = () => {
        setShowTable(true);
    };

    const handleCreateEmployeeClick = () => {
        setShowTable(false);
    };

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <p>This is the beginning</p>
                <button
                    className="App-link"
                    onClick={handleGetAllClick}
                >
                    Get All
                </button>
                <button
                    className="App-link"
                    onClick={handleCreateEmployeeClick}
                >
                    Create Employee
                </button>
            </header>
            <main>
                {showTable ? (
                    <GetAllEmployees />
                ) : (
                    <CreateEmployee />
                )}
            </main>
        </div>
    );
}

export default App;
