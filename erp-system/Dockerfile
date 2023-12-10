# Use the official Python image
FROM python:3.8-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Flask application files
COPY ./erp-system /app

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Expose the port the app runs on
EXPOSE 5000

# Run the application
CMD ["python", "app.py"]
