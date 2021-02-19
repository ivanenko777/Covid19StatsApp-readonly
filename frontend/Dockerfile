# STAGE 1
FROM node:14.15.5-alpine as build

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

EXPOSE 3000

COPY ./frontend/package.json ./
COPY ./frontend/package-lock.json ./

RUN npm install --silent
RUN npm install react-scripts@4.0.2 -g --silent

COPY ./frontend ./
RUN npm run build

# STAGE 2
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
# CMD ["nginx", "-g", "daemon off;"]