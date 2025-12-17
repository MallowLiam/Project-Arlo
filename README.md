Arlo — Custom UI

This repository now includes a lightweight React + Vite frontend in `frontend/` that provides a basic UI for interacting with the Arlo backend.

Quick start (Docker Compose):

1. Build and start services:

```bash
docker compose up -d --build
```

2. Open the UI at: http://localhost/

Notes:
- The frontend reads `VITE_API_URL` to call the backend API. It defaults to `http://arlo-ai:8000` inside Docker Compose.
- At runtime the nginx container substitutes `${API_BACKEND_URL}` into the proxy configuration; set it to the backend URL you want nginx to forward `/api/` requests to (defaults to `http://arlo-ai:8000`).
- If your backend API exposes a health endpoint, ensure it's reachable at `/api/health` or update `src/App.jsx` accordingly.
You can set `API_BACKEND_URL` (and `VITE_API_URL` for the build-time bundle) in an `.env` file or directly on the compose command line. Example:

```bash
API_BACKEND_URL=http://arlo-ai:8000 VITE_API_URL=http://arlo-ai:8000 docker compose up -d --build
```
