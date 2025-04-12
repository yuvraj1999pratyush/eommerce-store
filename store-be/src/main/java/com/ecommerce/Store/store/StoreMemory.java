package com.ecommerce.Store.store;

import com.ecommerce.Store.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreMemory {

    List<Item> items = new ArrayList<>();

    public StoreMemory() {
        items.add(new Item("1", "https://example.com/laptop.jpg", "Gaming Laptop", "A high-performance laptop with RTX graphics and 16GB RAM. Perfect for AAA titles and multitasking.", 1200.0, 5));
        items.add(new Item("2", "https://example.com/phone.jpg", "Smartphone", "Sleek design, AMOLED display and fast charging. Powered by the latest octa-core processor.", 800.0, 10));
        items.add(new Item("3", "https://example.com/headphones.jpg", "Wireless Headphones", "Noise cancelling over-ear headphones with 40-hour battery. Enjoy immersive audio anywhere.", 150.0, 20));
        items.add(new Item("4", "https://example.com/smartwatch.jpg", "Smart Watch", "Track your health and fitness with heart-rate monitoring. Features GPS and sleep tracking.", 200.0, 15));
        items.add(new Item("5", "https://example.com/backpack.jpg", "Laptop Backpack", "Ergonomic backpack with padded compartments. Water-resistant and ideal for travel or work.", 60.0, 25));
        items.add(new Item("6", "https://example.com/speaker.jpg", "Bluetooth Speaker", "Portable speaker with powerful bass and 360° sound. IPX7 waterproof and 12-hour battery.", 90.0, 18));
        items.add(new Item("7", "https://example.com/keyboard.jpg", "Mechanical Keyboard", "RGB backlit gaming keyboard with blue switches. Offers tactile feedback and fast response.", 110.0, 14));
        items.add(new Item("8", "https://example.com/mouse.jpg", "Wireless Mouse", "Silent click ergonomic mouse with 1600 DPI. Compatible with Windows and macOS.", 25.0, 40));
        items.add(new Item("9", "https://example.com/monitor.jpg", "4K Monitor", "Ultra HD 27-inch monitor with HDR support. Ideal for gaming, editing and productivity.", 350.0, 8));
        items.add(new Item("10", "https://example.com/router.jpg", "Wi-Fi Router", "Dual-band router with long-range coverage. Supports up to 20 connected devices.", 75.0, 12));
        items.add(new Item("11", "https://example.com/mic.jpg", "USB Microphone", "Studio-quality sound for streaming and podcasts. Plug-and-play with mute button.", 130.0, 10));
        items.add(new Item("12", "https://example.com/camera.jpg", "Webcam 1080p", "HD video call experience with auto-focus. Works with Zoom, Skype, Teams, and more.", 50.0, 17));
        items.add(new Item("13", "https://example.com/ssd.jpg", "External SSD 1TB", "High-speed storage with USB 3.2 interface. Compact and shock-resistant design.", 180.0, 6));
        items.add(new Item("14", "https://example.com/harddrive.jpg", "External HDD 2TB", "Reliable backup solution for large files. Plug-and-play with all major OS.", 90.0, 20));
        items.add(new Item("15", "https://example.com/charger.jpg", "Fast Charger", "45W USB-C charger compatible with laptops and phones. Comes with braided cable.", 35.0, 30));
        items.add(new Item("16", "https://example.com/stand.jpg", "Laptop Stand", "Adjustable aluminum stand for ergonomic viewing. Keeps your device cool with ventilation.", 40.0, 22));
        items.add(new Item("17", "https://example.com/deskmat.jpg", "Gaming Desk Mat", "Oversized RGB mouse pad with smooth surface. Adds color and precision to your setup.", 30.0, 16));
        items.add(new Item("18", "https://example.com/stylus.jpg", "Stylus Pen", "Magnetic stylus for tablets with tilt sensitivity. Perfect for drawing and note-taking.", 60.0, 9));
        items.add(new Item("19", "https://example.com/cable.jpg", "USB-C Cable", "Durable nylon braided cable with fast charging. 6ft long for convenience and reach.", 12.0, 50));
        items.add(new Item("20", "https://example.com/light.jpg", "LED Desk Lamp", "Touch-control LED lamp with adjustable brightness. Features eye-care tech and USB port.", 45.0, 13));
    }

    public List<Item> getItems() {
        return items;
    }
}
