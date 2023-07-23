# Use the official Node.js image as the base image
FROM node:14-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the package.json and package-lock.json files to the container
COPY ../src/frontend/package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application files to the container
COPY src/frontend/ .

# Expose port 3000
EXPOSE 3000

# Start the application
CMD ["npm", "start"]







