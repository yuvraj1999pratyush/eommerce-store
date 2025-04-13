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
        items.add(new Item("1", "https://fastly.picsum.photos/id/2/5000/3333.jpg?hmac=_KDkqQVttXw_nM-RyJfLImIbafFrqLsuGO5YuHqD-qQ", "Gaming Laptop", "A high-performance laptop with RTX graphics and 16GB RAM. Perfect for AAA titles and multitasking.", 1200.0, 5));
        items.add(new Item("2", "https://fastly.picsum.photos/id/7/4728/3168.jpg?hmac=c5B5tfYFM9blHHMhuu4UKmhnbZoJqrzNOP9xjkV4w3o", "Smartphone", "Sleek design, AMOLED display and fast charging. Powered by the latest octa-core processor.", 800.0, 10));
        items.add(new Item("3", "https://fastly.picsum.photos/id/20/3670/2462.jpg?hmac=CmQ0ln-k5ZqkdtLvVO23LjVAEabZQx2wOaT4pyeG10I", "Wireless Headphones", "Noise cancelling over-ear headphones with 40-hour battery. Enjoy immersive audio anywhere.", 150.0, 20));
        items.add(new Item("4", "https://fastly.picsum.photos/id/2/5000/3333.jpg?hmac=_KDkqQVttXw_nM-RyJfLImIbafFrqLsuGO5YuHqD-qQ", "Smart Watch", "Track your health and fitness with heart-rate monitoring. Features GPS and sleep tracking.", 200.0, 15));
        items.add(new Item("5", "https://fastly.picsum.photos/id/26/4209/2769.jpg?hmac=vcInmowFvPCyKGtV7Vfh7zWcA_Z0kStrPDW3ppP0iGI", "Laptop Backpack", "Ergonomic backpack with padded compartments. Water-resistant and ideal for travel or work.", 60.0, 25));
        items.add(new Item("6", "https://fastly.picsum.photos/id/30/1280/901.jpg?hmac=A_hpFyEavMBB7Dsmmp53kPXKmatwM05MUDatlWSgATE", "Bluetooth Speaker", "Portable speaker with powerful bass and 360° sound. IPX7 waterproof and 12-hour battery.", 90.0, 18));
        items.add(new Item("7", "https://fastly.picsum.photos/id/26/4209/2769.jpg?hmac=vcInmowFvPCyKGtV7Vfh7zWcA_Z0kStrPDW3ppP0iGI", "Mechanical Keyboard", "RGB backlit gaming keyboard with blue switches. Offers tactile feedback and fast response.", 110.0, 14));
        items.add(new Item("8", "https://fastly.picsum.photos/id/36/4179/2790.jpg?hmac=OCuYYm0PkDCMwxWhrtoSefG5UDir4O0XCcR2x-aSPjs", "Wireless Mouse", "Silent click ergonomic mouse with 1600 DPI. Compatible with Windows and macOS.", 25.0, 40));
        items.add(new Item("9", "https://fastly.picsum.photos/id/7/4728/3168.jpg?hmac=c5B5tfYFM9blHHMhuu4UKmhnbZoJqrzNOP9xjkV4w3o", "4K Monitor", "Ultra HD 27-inch monitor with HDR support. Ideal for gaming, editing and productivity.", 350.0, 8));
        items.add(new Item("10", "https://fastly.picsum.photos/id/133/2742/1828.jpg?hmac=0X5o8bHUICkOIvZHtykCRL50Bjn1N8w1AvkenF7n93E", "Wi-Fi Router", "Dual-band router with long-range coverage. Supports up to 20 connected devices.", 75.0, 12));
        items.add(new Item("11", "https://fastly.picsum.photos/id/26/4209/2769.jpg?hmac=vcInmowFvPCyKGtV7Vfh7zWcA_Z0kStrPDW3ppP0iGI", "USB Microphone", "Studio-quality sound for streaming and podcasts. Plug-and-play with mute button.", 130.0, 10));
        items.add(new Item("12", "https://fastly.picsum.photos/id/30/1280/901.jpg?hmac=A_hpFyEavMBB7Dsmmp53kPXKmatwM05MUDatlWSgATE", "Webcam 1080p", "HD video call experience with auto-focus. Works with Zoom, Skype, Teams, and more.", 50.0, 17));
        items.add(new Item("13", "https://fastly.picsum.photos/id/20/3670/2462.jpg?hmac=CmQ0ln-k5ZqkdtLvVO23LjVAEabZQx2wOaT4pyeG10I", "External SSD 1TB", "High-speed storage with USB 3.2 interface. Compact and shock-resistant design.", 180.0, 6));
        items.add(new Item("14", "https://fastly.picsum.photos/id/36/4179/2790.jpg?hmac=OCuYYm0PkDCMwxWhrtoSefG5UDir4O0XCcR2x-aSPjs", "External HDD 2TB", "Reliable backup solution for large files. Plug-and-play with all major OS.", 90.0, 20));
        items.add(new Item("15", "https://fastly.picsum.photos/id/20/3670/2462.jpg?hmac=CmQ0ln-k5ZqkdtLvVO23LjVAEabZQx2wOaT4pyeG10I", "Fast Charger", "45W USB-C charger compatible with laptops and phones. Comes with braided cable.", 35.0, 30));
        items.add(new Item("16", "https://fastly.picsum.photos/id/133/2742/1828.jpg?hmac=0X5o8bHUICkOIvZHtykCRL50Bjn1N8w1AvkenF7n93E", "Laptop Stand", "Adjustable aluminum stand for ergonomic viewing. Keeps your device cool with ventilation.", 40.0, 22));
        items.add(new Item("17", "https://fastly.picsum.photos/id/2/5000/3333.jpg?hmac=_KDkqQVttXw_nM-RyJfLImIbafFrqLsuGO5YuHqD-qQ", "Gaming Desk Mat", "Oversized RGB mouse pad with smooth surface. Adds color and precision to your setup.", 30.0, 16));
        items.add(new Item("18", "https://fastly.picsum.photos/id/30/1280/901.jpg?hmac=A_hpFyEavMBB7Dsmmp53kPXKmatwM05MUDatlWSgATE", "Stylus Pen", "Magnetic stylus for tablets with tilt sensitivity. Perfect for drawing and note-taking.", 60.0, 9));
        items.add(new Item("19", "https://fastly.picsum.photos/id/36/4179/2790.jpg?hmac=OCuYYm0PkDCMwxWhrtoSefG5UDir4O0XCcR2x-aSPjs", "USB-C Cable", "Durable nylon braided cable with fast charging. 6ft long for convenience and reach.", 12.0, 50));
        items.add(new Item("20", "https://fastly.picsum.photos/id/7/4728/3168.jpg?hmac=c5B5tfYFM9blHHMhuu4UKmhnbZoJqrzNOP9xjkV4w3o", "LED Desk Lamp", "Touch-control LED lamp with adjustable brightness. Features eye-care tech and USB port.", 45.0, 13));
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemById(String id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void reduceItemStock(String id, int quantity) {
        Item item = getItemById(id);
        if (item != null && item.getQuantity() >= quantity) {
            item.setQuantity(item.getQuantity() - quantity);
        }
    }
}
