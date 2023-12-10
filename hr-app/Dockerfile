# Use the official Node.js base image
FROM node:14-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Express application files
COPY ./hr-app /app

# Install dependencies
RUN npm install

# Expose the port the app runs on
EXPOSE 3000

# Run the application
CMD ["node", "index.js"]
