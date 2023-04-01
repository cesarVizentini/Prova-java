INSERT INTO parent (Name)
VALUES
  ('John'),
  ('Paul'),
  ('Mary'),
  ('Lucy'),
  ('Mark');

INSERT INTO child (Name, Father_Id, Mother_Id)
VALUES
  ('John', 1, 3),
  ('Paul', 1, 3),
  ('Lucy', 2, 4),
  ('Claire', 1, 4),
  ('Simon', NULL, 4);