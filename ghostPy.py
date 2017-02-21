from ghost import Ghost
ghost = Ghost()
with ghost.start() as session:
  page, extra_resources = session.open("http://localhost:5000/")
  print page.http_status
  self.assertEqual(page.http_status,200) 