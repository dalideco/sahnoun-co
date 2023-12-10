FROM node:alpine AS development

WORKDIR /usr/src/app


COPY accounting_application/package.json ./

COPY accounting_application/package-lock.json ./

RUN npm i

COPY ./accounting_application . 

RUN npm run build

FROM node:alpine as production

WORKDIR /usr/src/app

COPY accounting_application/package.json ./

COPY accounting_application/package-lock.json ./

RUN npm i --only=production

COPY . .

COPY --from=development /usr/src/app/dist ./dist

CMD ["npm", "run", "start:prod"]