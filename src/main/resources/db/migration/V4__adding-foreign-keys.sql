ALTER TABLE topics ADD COLUMN author_id BIGINT;
ALTER TABLE topics ADD CONSTRAINT fk_topics_users FOREIGN KEY (author_id) REFERENCES users(id);

ALTER TABLE answers ADD COLUMN author_id BIGINT;
ALTER TABLE answers ADD CONSTRAINT fk_answers_users FOREIGN KEY (author_id) REFERENCES users(id);
