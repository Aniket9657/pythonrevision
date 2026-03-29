import { useState } from "react";

export default function Chat() {
  const [input, setInput] = useState("");
  const [messages, setMessages] = useState([]);

  const sendMessage = async () => {
    if (!input) return;

    setMessages([...messages, { role: "user", text: input }]);

    try {
      const res = await fetch(`http://127.0.0.1:8000/chat?q=${input}`);
      const data = await res.json();

      setMessages(prev => [...prev, { role: "bot", text: data.response }]);
    } catch (err) {
      console.error(err);
    }

    setInput("");
  };

  return (
    <div style={{ padding: "20px" }}>
      <div style={{ height: "60vh", overflowY: "auto" }}>
        {messages.map((m, i) => (
          <p key={i} style={{ textAlign: m.role === "user" ? "right" : "left" }}>
            {m.text}
          </p>
        ))}
      </div>

      <input
        value={input}
        onChange={(e) => setInput(e.target.value)}
        style={{ width: "70%" }}
      />
      <button onClick={sendMessage}>Send</button>
    </div>
  );
}