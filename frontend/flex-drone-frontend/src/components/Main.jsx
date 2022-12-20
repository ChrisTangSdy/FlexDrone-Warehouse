import { BrowserRouter, Routes, Route } from "react-router-dom";
import Index from "../pages/Home/Index";
import ViewProduct from "../pages/Product/ViewProduct";
import ChangePassword from "../pages/User/changePassword";

import UserProfile from "../pages/User/index.jsx";

export default function Main() {
  return (
    <main className="main-container container-fluid">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Index />} />
          <Route path="/ViewProduct" element={<ViewProduct />} />
          <Route path="/ViewUser" element={<UserProfile />} />
          <Route path="/ChangePassword" element={<ChangePassword />} />
        </Routes>
      </BrowserRouter>
    </main>
  );
}
