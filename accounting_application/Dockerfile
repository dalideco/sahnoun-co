# Use the official Node.js image
FROM node:14-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the NestJS application files
COPY ./accounting_application /app

# Install dependencies
RUN npm install

# Expose the port the app runs on
EXPOSE 3001

# Run the application
CMD ["npm", "start"]
