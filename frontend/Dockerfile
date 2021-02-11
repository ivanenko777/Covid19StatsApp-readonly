FROM node:14.15.5-alpine

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

EXPOSE 3000

COPY ./frontend/package.json ./
COPY ./frontend/package-lock.json ./

RUN npm install --silent
RUN npm install react-scripts@4.0.2 -g --silent

COPY ./frontend ./

# CMD ["npm", "start"]