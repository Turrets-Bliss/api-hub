FROM postgres:17
COPY 01-newdb.sql /docker-entrypoint-initdb.d/
COPY 03-access.sql /docker-entrypoint-initdb.d/


ENV POSTGRES_DB spring_app
ENV POSTGRES_USER nashtech
ENV POSTGRES_PASSWORD nashtech

