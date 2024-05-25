# Build stage
FROM node:20-alpine as build
WORKDIR /app
COPY package.json ./
COPY package-lock.json ./
RUN npm ci
COPY . ./
RUN npm run build

# Run stage
FROM node:20-alpine
WORKDIR /app
COPY --from=build /app/build /app/build
RUN npm install -g serve
EXPOSE 8800
CMD ["serve", "-s", "/app/build", "-l", "8800"]