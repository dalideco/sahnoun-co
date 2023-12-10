# Use a base image with Python
FROM python:3.9-slim

# Set the working directory in the container
WORKDIR /app

# Copy the requirements file to the container
COPY erp-system/requirements.txt .

# Install the Python dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Install gunicorn
RUN pip install gunicorn

# Copy the Flask app code to the container
COPY ./erp-system .

# Expose the port that the Flask app will run on
EXPOSE 5000

# Set the command to run the Flask app using a WSGI server (e.g., gunicorn)
CMD ["gunicorn", "app:app", "-b", "0.0.0.0:5000"]
