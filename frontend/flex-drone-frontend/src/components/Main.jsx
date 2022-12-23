import { BrowserRouter, Routes, Route } from "react-router-dom";
import Index from "../pages/Home/Index";
import ViewProduct from "../pages/Product/ViewProduct";
import ChangePassword from "../pages/User/changePassword";
import Login from "../pages/Login/index";
import NavbarMenu from "../components/NavbarMenu";
import SidebarMenu from "../components/SidebarMenu";
import UserProfile from "../pages/User/index";

export default function Main() {
  //temporary placeholder product, will be removed when search function is implemented
  const product = {
    name: "DJI Camera",
    description: "This is a camera.",
    SKU: "DJI-Cam-AZ-P-B-A10-MI-0001",
    price: 199.99,
    category: "Camera",
    externalStock: 100,
    internalStock: 98,
    minStockLevel: 20,
    isPart: true,
    externalNote: "N/A",
    internalNote: "N/A",
  };

  return (
    <div className="main-wrapper">
      <NavbarMenu />
      <SidebarMenu />
      <main className="main-container container-fluid">
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Index />} />
            <Route
              path={`/ViewProduct/${product.SKU}`}
              element={<ViewProduct product={product} />}
            />
            <Route path="/ViewUser" element={<UserProfile />} />
            <Route path="/ChangePassword" element={<ChangePassword />} />
            <Route path="/Login" element={<Login />} />
          </Routes>
        </BrowserRouter>
      </main>
    </div>
  );
}
