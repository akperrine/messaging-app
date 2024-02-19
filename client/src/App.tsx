import React, { useState } from "react";
import AuthComponent from "./pages/AuthComponent";
import HomePage from "./pages/Home";

const App: React.FC = () => {
  const [isLoggedIn, setIsLoggedIn] = useState<boolean>(false);

  const handleLogin = () => {
    setIsLoggedIn(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
  };

  return (
    <div>
      {isLoggedIn ? (
        <div>
          <button onClick={handleLogout}>Logout</button>
          <HomePage />
        </div>
      ) : (
        <AuthComponent onLogin={handleLogin} />
      )}
    </div>
  );
};

export default App;
