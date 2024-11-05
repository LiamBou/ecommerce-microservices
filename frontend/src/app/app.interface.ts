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
