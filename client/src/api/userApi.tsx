const API_URL = "http://localhost:8080";

export async function createUser(user: { username: string; password: string }) {
  const resp = await fetch(`${API_URL}/api/users`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  if (!resp.ok) {
    throw new Error("Failed to create user");
  }

  const newUser: UserCredentials | null = await resp.json();

  if (!newUser) {
    throw new Error("Username already taken");
  }
}

export async function login(user: { username: string; password: string }) {
  console.log(user);
  const resp = await fetch(`${API_URL}/api/users/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });

  if (!resp.ok) {
    throw new Error("Incorrect credentials");
  } else {
    const newUser: UserCredentials = await resp.json();
    return newUser;
  }
}
