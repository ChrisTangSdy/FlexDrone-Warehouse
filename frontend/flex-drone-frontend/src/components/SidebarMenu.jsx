import Sidebar from "react-bootstrap-sidebar-menu";

export default function SidebarMenu() {
  const theme = "dark";
  return (
    <Sidebar variant={theme} bg={theme} expand="sm">
      <Sidebar.Collapse>
        <Sidebar.Header>
          <Sidebar.Brand>FlexDrone Warehouse</Sidebar.Brand>
          <Sidebar.Toggle />
        </Sidebar.Header>
        <Sidebar.Body>
          <Sidebar.Nav>
            <Sidebar.Nav.Link eventKey="menu_title">
              <Sidebar.Nav.Icon>1</Sidebar.Nav.Icon>
              <Sidebar.Nav.Title>Home</Sidebar.Nav.Title>
            </Sidebar.Nav.Link>

            {/* leaving this code in for now in case we want to add submenus to the sidebar
            <Sidebar.Sub eventKey={0}>
              <Sidebar.Sub.Toggle>
                <Sidebar.Nav.Icon />
                <Sidebar.Nav.Title>Submenu</Sidebar.Nav.Title>
              </Sidebar.Sub.Toggle>
              <Sidebar.Sub.Collapse>
                <Sidebar.Nav>
                  <Sidebar.Nav.Link eventKey="sum_menu_title">
                    <Sidebar.Nav.Icon>1.1</Sidebar.Nav.Icon>
                    <Sidebar.Nav.Title>Sub menu item</Sidebar.Nav.Title>
                  </Sidebar.Nav.Link>
                </Sidebar.Nav>
              </Sidebar.Sub.Collapse>
            </Sidebar.Sub> */}
          </Sidebar.Nav>
        </Sidebar.Body>
      </Sidebar.Collapse>
    </Sidebar>
  );
}
