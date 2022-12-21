import "./assets/styles.scss";

import React from "react";
import SidebarMenu from "./components/SidebarMenu";
import Main from "./components/Main";

function App() {
  return (
    <div className="main-wrapper">
      <SidebarMenu />
      <Main />
    </div>
  );
}

export default App;
