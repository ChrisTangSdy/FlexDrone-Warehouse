import { React } from "react";

export default function ViewProduct({ product }) {
  return (
    <div>
      <h3>{product.name}</h3>
      <p>{product.description}</p>
      <p>SKU: {product.SKU}</p>
      <p>Retail price: ${product.price}</p>
      <p>Category: {product.category}</p>
      <p>External stock: {product.externalStock}</p>
      <p>Internal stock: {product.internalStock}</p>
      <p>Min stock level: {product.minStockLevel}</p>
      <p>Is Part: {`${product.isPart}`}</p>
      <p>External Note: {product.externalNote}</p>
      <p>Internal Note: {product.internalNote}</p>
    </div>
  );
}
