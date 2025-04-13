import React, {useState, useEffect} from 'react'
import { API_BASE_URL } from '../../utils/api'

const HomePage = () => {
  const [items, setItems] = useState([])
  const [loading, setLoading] = useState(true)

  const fetchAllItems = async () => {
    setLoading(true);
    try {
      const res = await fetch(`${API_BASE_URL}/v1/store/items/all`)
      const data = await res.json()
      setItems(data.items || [])
    } catch (error) {
      console.error("Failed to fetch items:", error)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    console.log("here")
    fetchAllItems()
  }, [])

  if (loading) return <p>Loading items...</p>

  return (
    <div>homePage</div>
  )
}

export default HomePage