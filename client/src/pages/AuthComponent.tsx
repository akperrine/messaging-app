import { createUser, login } from "../api/userApi";
import LoginForm from "../components/LoginForm";
import SignupForm from "../components/SignupForm";

const AuthComponent = ({ onLogin }) => {
  const handleLogin = async (credentials: {
    username: string;
    password: string;
  }) => {
    try {
      await login(credentials);
      onLogin();
    } catch (error) {
      console.log(error);
    }
    console.log("Logging in with:", credentials);
  };

  const handleSignup = async (credentials: {
    username: string;
    password: string;
  }) => {
    try {
      await createUser(credentials);
      onLogin();
    } catch (error) {
      console.log(error);
    }
    console.log("Signing up with:", credentials);
  };

  return (
    <div>
      <h2>Login</h2>
      <LoginForm onLogin={handleLogin} />
      <h2>Signup</h2>
      <SignupForm onSignup={handleSignup} />
    </div>
  );
};

export default AuthComponent;
