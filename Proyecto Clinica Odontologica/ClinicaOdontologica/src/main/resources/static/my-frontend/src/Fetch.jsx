import React, { useEffect, useState } from 'react';

export default function Fetch() {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);

  const API_BASE_URL = 'localhost:8080';

  useEffect(() => {
    fetch('/odontologos')
      .then((response) => response.json())
      .then((data) => {
        setItems(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error('Error fetching data: ', error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <div>Loading ...</div>;
  }

  return (
    <div>
      <h1>Item List</h1>
      <ul>
        {items.map((item) => (
          <>
            <li key={item.id}>
              {item.nombre} {item.apellido}
            </li>
          </>
        ))}
      </ul>
    </div>
  );
}
