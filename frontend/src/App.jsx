import React, { useEffect, useState } from 'react'
import axios from 'axios'

function App() {
  const [status, setStatus] = useState('unknown')
  const [message, setMessage] = useState('')

  useEffect(() => {
    const url = import.meta.env.VITE_API_URL || '/api/health'
    axios.get(url)
      .then(res => {
        setStatus('online')
        setMessage(JSON.stringify(res.data))
      })
      .catch(err => {
        setStatus('offline')
        setMessage(err.message)
      })
  }, [])

  return (
    <div className="container">
      <header>
        <h1>Arlo — Custom UI</h1>
        <p>Backend status: <strong>{status}</strong></p>
      </header>

      <section className="card">
        <h2>Quick Actions</h2>
        <div className="grid">
          <button onClick={() => alert('Start training clicked')}>Start Training</button>
          <button onClick={() => alert('Stop training clicked')}>Stop Training</button>
          <button onClick={() => alert('View logs clicked')}>View Logs</button>
        </div>
      </section>

      <section className="card">
        <h2>Backend Response</h2>
        <pre>{message}</pre>
      </section>

      <footer>
        <small>Arlo UI — lightweight front-end for interacting with the Arlo backend.</small>
      </footer>
    </div>
  )
}

export default App
