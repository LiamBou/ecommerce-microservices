export interface Order {
  id: number;
  userId: number;
  orderItems: OrderItem[];
  totalAmount: number;
  status: string;
  orderDate: string;
}

export interface OrderItem {
  id: number;
  productId: string;
  quantity: number;
  price: number;
}

export interface Product {
  id: string;
  name: string;
  race: string;
  color: string;
  price: number;
  description: string;
  image: string;
  stockQuantity: number;
}

export interface Stock {
  id: number;
  article_id: string;
  quantity: number;
  createdAt: string;
  updatedAt: string;
}

export interface CartItem {
  product: Product;
  quantity: number;
  totalPrice: number;
}
