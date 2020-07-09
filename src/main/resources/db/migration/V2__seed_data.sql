insert into roles
    (id, name, code)
values ('db127d6b-f2f3-4115-b20a-5b5f67c384aa', 'Developer', 'dev'),
       ('eb52cd63-7e9c-4684-8c20-b3e60504133d', 'Project Manager', 'pm'),
       ('b23abb19-faad-44de-9324-8ec18aa331da', 'Tester', 'qa'),
       ('0a36f5af-c63e-4cfd-930a-6d56754d7b79', 'DevOps', 'devops'),
       ('8222cfc9-a213-47c9-a314-42479023b796', 'Team Lead', 'tl');

insert into offices
    (id, address, city)
values ('9f47213e-814d-483a-9a56-fd7c9438a0f4', 'Chornovola 59', 'Lviv'),
       ('29825547-2d2e-4108-b34e-838341964652', 'Klovsky Spusk 7', 'Kiyv');

insert into projects
    (id, name, description)
values ('95a46088-b143-483d-a86c-3d6be6fd2e6d', 'Facebook', 'Social network for all people'),
       ('ccb9f16b-e852-4ffb-b5e4-87247d978fd9', 'Uber', 'Automated taxi service'),
       ('e2eceb99-7388-47bb-9f14-339f3392efbd', 'Windows', 'Operating System for newbies');

insert into technologies
    (id, name, description, link)
values ('b280ecd5-243f-4b55-ba4e-4777ef49453b', 'Java', 'Language for microwaves', 'https://www.java.com'),
       ('a099b732-23ba-49aa-9b94-a9541b1c18b7', 'JavaScript', 'HTML is a programming language',
        'https://developer.mozilla.org/'),
       ('b6c3b74f-b7e6-4718-92fc-e9491ee51d0b', '.NET', 'Microsoft one love', 'https://docs.microsoft.com/');

insert into teams
    (id, area, name, room, technology_id, project_id)
values ('953f401c-7ba7-4523-805e-6fee70e2cb14', 'frontend', 'Hipsters', 'green', 'a099b732-23ba-49aa-9b94-a9541b1c18b7',
        '95a46088-b143-483d-a86c-3d6be6fd2e6d'),
       ('5d538bc8-0644-42de-b1eb-d8afaf47871e', 'backend', 'Geeks', 'red', 'b280ecd5-243f-4b55-ba4e-4777ef49453b',
        '95a46088-b143-483d-a86c-3d6be6fd2e6d'),
       ('6ec4bcdc-7121-4dcf-b186-616cbb5c488c', 'mobile', 'Hackers', 'yellow', 'a099b732-23ba-49aa-9b94-a9541b1c18b7',
        'ccb9f16b-e852-4ffb-b5e4-87247d978fd9'),
       ('2591bf93-d4e4-4fce-95b6-c730c7ef5fdd', 'backend', 'Nerds', 'brown', 'b280ecd5-243f-4b55-ba4e-4777ef49453b',
        'ccb9f16b-e852-4ffb-b5e4-87247d978fd9'),
       ('99abe5fc-8a24-4d2e-91b7-af68cb67fb5e', 'desktop', 'Olds', 'orange', 'b6c3b74f-b7e6-4718-92fc-e9491ee51d0b',
        'e2eceb99-7388-47bb-9f14-339f3392efbd');

insert into users
    (id, experience, first_name, last_name, office_id, team_id)
values ('1d14354d-586b-4f90-84dd-9d439cb36e52', 3, 'Anayah', 'Lawson', '29825547-2d2e-4108-b34e-838341964652',
        '953f401c-7ba7-4523-805e-6fee70e2cb14'),
       ('a9212bcd-9410-4f2c-a51e-cad095d6982b', 4, 'Avleen', 'Allman', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '5d538bc8-0644-42de-b1eb-d8afaf47871e'),
       ('e1ed2f0f-b402-4208-b39b-ff8d2fbf6164', 2, 'Lilli', 'Guerra', '29825547-2d2e-4108-b34e-838341964652',
        '953f401c-7ba7-4523-805e-6fee70e2cb14'),
       ('5422df61-f6dc-496d-a9bf-5c7352275d24', 5, 'Celeste', 'Kaye', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '5d538bc8-0644-42de-b1eb-d8afaf47871e'),
       ('df14aac7-861e-42e0-a6ed-49b9713d4d11', 1, 'Maximilian', 'Wilkins', '29825547-2d2e-4108-b34e-838341964652',
        '953f401c-7ba7-4523-805e-6fee70e2cb14'),
       ('754375e4-0acc-49f3-922e-db29837d7f82', 6, 'Luka', 'Peterson', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '5d538bc8-0644-42de-b1eb-d8afaf47871e'),
       ('7d9df9e7-845c-470c-b481-5b08bddaeae3', 4, 'Danica', 'Galvan', '29825547-2d2e-4108-b34e-838341964652',
        '953f401c-7ba7-4523-805e-6fee70e2cb14'),
       ('d393d58e-3940-42fb-bd9e-8a3f2161fe2e', 5, 'Asa', 'Yu', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '5d538bc8-0644-42de-b1eb-d8afaf47871e'),
       ('6942b4e2-275a-470a-ba13-47c56b8bebab', 2, 'Oakley', 'Villa', '29825547-2d2e-4108-b34e-838341964652',
        '6ec4bcdc-7121-4dcf-b186-616cbb5c488c'),
       ('f06a9e20-9328-48f1-bc50-502edc951bba', 6, 'Jonty', 'Hall', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '2591bf93-d4e4-4fce-95b6-c730c7ef5fdd'),
       ('b179cb7d-0c99-4a27-92b3-069bf6cd3036', 3, 'Laith', 'Hunt', '29825547-2d2e-4108-b34e-838341964652',
        '6ec4bcdc-7121-4dcf-b186-616cbb5c488c'),
       ('bfed9e9e-34c1-436a-9e7e-1a1dfc6d87b7', 4, 'Lilly', 'Rose', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '2591bf93-d4e4-4fce-95b6-c730c7ef5fdd'),
       ('1371bb37-d3c5-4a3b-9d06-184479900392', 4, 'Ela', 'Hartley', '29825547-2d2e-4108-b34e-838341964652',
        '6ec4bcdc-7121-4dcf-b186-616cbb5c488c'),
       ('57de387c-d076-422a-9c6c-361f38681fcd', 3, 'Martina', 'Alvarado', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '2591bf93-d4e4-4fce-95b6-c730c7ef5fdd'),
       ('b73234a4-7bb8-471b-9a2e-cfc29c490e24', 2, 'Jared', 'Bentley', '29825547-2d2e-4108-b34e-838341964652',
        '6ec4bcdc-7121-4dcf-b186-616cbb5c488c'),
       ('99a568b0-ac71-458c-8e5e-b94902947b88', 5, 'Elora', 'Brown', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '2591bf93-d4e4-4fce-95b6-c730c7ef5fdd'),
       ('fa2dbeb6-7077-4bb5-ac84-1693c3739ede', 1, 'Arwa', 'Bain', '29825547-2d2e-4108-b34e-838341964652',
        '99abe5fc-8a24-4d2e-91b7-af68cb67fb5e'),
       ('6be0f9a6-d778-4513-914d-cb1be8702d56', 1, 'Sheena', 'Dalton', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '99abe5fc-8a24-4d2e-91b7-af68cb67fb5e'),
       ('f4c58cc6-45df-4e82-b665-d255660d685f', 5, 'Amiee', 'King', '29825547-2d2e-4108-b34e-838341964652',
        '99abe5fc-8a24-4d2e-91b7-af68cb67fb5e'),
       ('5c546180-1652-4222-a22e-868182652aed', 4, 'Kali', 'Chan', '9f47213e-814d-483a-9a56-fd7c9438a0f4',
        '99abe5fc-8a24-4d2e-91b7-af68cb67fb5e');

insert into user2role
    (user_id, role_id)
values ('1d14354d-586b-4f90-84dd-9d439cb36e52', 'db127d6b-f2f3-4115-b20a-5b5f67c384aa'),
       ('a9212bcd-9410-4f2c-a51e-cad095d6982b', 'db127d6b-f2f3-4115-b20a-5b5f67c384aa'),
       ('e1ed2f0f-b402-4208-b39b-ff8d2fbf6164', 'eb52cd63-7e9c-4684-8c20-b3e60504133d'),
       ('5422df61-f6dc-496d-a9bf-5c7352275d24', 'eb52cd63-7e9c-4684-8c20-b3e60504133d'),
       ('df14aac7-861e-42e0-a6ed-49b9713d4d11', 'b23abb19-faad-44de-9324-8ec18aa331da'),
       ('754375e4-0acc-49f3-922e-db29837d7f82', '0a36f5af-c63e-4cfd-930a-6d56754d7b79'),
       ('7d9df9e7-845c-470c-b481-5b08bddaeae3', '8222cfc9-a213-47c9-a314-42479023b796'),
       ('d393d58e-3940-42fb-bd9e-8a3f2161fe2e', '8222cfc9-a213-47c9-a314-42479023b796'),
       ('6942b4e2-275a-470a-ba13-47c56b8bebab', 'db127d6b-f2f3-4115-b20a-5b5f67c384aa'),
       ('f06a9e20-9328-48f1-bc50-502edc951bba', 'db127d6b-f2f3-4115-b20a-5b5f67c384aa'),
       ('b179cb7d-0c99-4a27-92b3-069bf6cd3036', 'eb52cd63-7e9c-4684-8c20-b3e60504133d'),
       ('bfed9e9e-34c1-436a-9e7e-1a1dfc6d87b7', 'eb52cd63-7e9c-4684-8c20-b3e60504133d'),
       ('1371bb37-d3c5-4a3b-9d06-184479900392', 'b23abb19-faad-44de-9324-8ec18aa331da'),
       ('57de387c-d076-422a-9c6c-361f38681fcd', '0a36f5af-c63e-4cfd-930a-6d56754d7b79'),
       ('b73234a4-7bb8-471b-9a2e-cfc29c490e24', '8222cfc9-a213-47c9-a314-42479023b796'),
       ('99a568b0-ac71-458c-8e5e-b94902947b88', '8222cfc9-a213-47c9-a314-42479023b796'),
       ('fa2dbeb6-7077-4bb5-ac84-1693c3739ede', 'db127d6b-f2f3-4115-b20a-5b5f67c384aa'),
       ('6be0f9a6-d778-4513-914d-cb1be8702d56', 'eb52cd63-7e9c-4684-8c20-b3e60504133d'),
       ('f4c58cc6-45df-4e82-b665-d255660d685f', 'b23abb19-faad-44de-9324-8ec18aa331da'),
       ('5c546180-1652-4222-a22e-868182652aed', '8222cfc9-a213-47c9-a314-42479023b796');
