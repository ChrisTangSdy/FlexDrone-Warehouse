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
            <Sidebar.Nav.Link href="/" eventKey="menu_title">
              <Sidebar.Nav.Icon>
                <i class="bi bi-house-fill"></i>
              </Sidebar.Nav.Icon>
              <Sidebar.Nav.Title>Home</Sidebar.Nav.Title>
            </Sidebar.Nav.Link>
            <Sidebar.Sub eventKey={0}>
              <Sidebar.Sub.Toggle>
                <Sidebar.Nav.Icon>
                  <i class="bi bi-person-fill"></i>
                </Sidebar.Nav.Icon>
                <Sidebar.Nav.Title>Account</Sidebar.Nav.Title>
              </Sidebar.Sub.Toggle>
              <Sidebar.Sub.Collapse>
                <Sidebar.Nav>
                  <Sidebar.Nav.Link href="/ViewUser" eventKey="menu_title">
                    <Sidebar.Nav.Icon>
                      <i class="bi bi-person-lines-fill"></i>
                    </Sidebar.Nav.Icon>
                    <Sidebar.Nav.Title>User Profile</Sidebar.Nav.Title>
                  </Sidebar.Nav.Link>
                </Sidebar.Nav>
                <Sidebar.Nav>
                  <Sidebar.Nav.Link
                    href="/ChangePassword"
                    eventKey="menu_title"
                  >
                    <Sidebar.Nav.Icon>
                      <i class="bi bi-lock-fill"></i>
                    </Sidebar.Nav.Icon>
                    <Sidebar.Nav.Title>Change Password</Sidebar.Nav.Title>
                  </Sidebar.Nav.Link>
                </Sidebar.Nav>
              </Sidebar.Sub.Collapse>
            </Sidebar.Sub>
          </Sidebar.Nav>
        </Sidebar.Body>
      </Sidebar.Collapse>
    </Sidebar>
  );
}
