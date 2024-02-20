const API_URL = "http://localhost:8080";

export async function createUser(user: { username: string; password: string }) {
  const resp = await fetch(`${API_URL}/api/users`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });
  //   console.log("hit", resp.json());
  if (!resp.ok) {
    console.log("no ok");
    throw new Error("Failed to create user");
  }
  console.log("hi");
  const newUser: UserCredentials | null = await resp.json();
  console.log(newUser);
  if (!newUser) {
    console.log(newUser);
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
