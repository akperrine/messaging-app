import ChatGroups from "../components/ChatGroups";
import MessageRoom from "../components/MessageRoom";
import "./Home.css";

const HomePage: React.FC = ({ onLogout }) => {
  return (
    <div className="home-container">
      <nav>
        <button onClick={onLogout}>Logout</button>
      </nav>
      <div className="home-sub-container">
        <ChatGroups />
        <MessageRoom />
      </div>
    </div>
  );
};

export default HomePage;
