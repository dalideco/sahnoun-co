provider "aws" {
  region = "eu-central-1"
}



resource "aws_instance" "ec2_instance" {
  instance_type               = "t2.small"
  ami                         = "ami-06dd92ecc74fdfb36"
  user_data                   = <<-EOF
        #!/bin/bash
        # Install docker
        apt-get update
        apt-get install -y apt-transport-https ca-certificates curl software-properties-common
        curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
        add-apt-repository \
        "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
        $(lsb_release -cs) \
        stable"
        apt-get update
        apt-get install -y docker-ce
        usermod -aG docker ubuntu

        # Install docker-compose
        curl -L https://github.com/docker/compose/releases/download/1.21.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
        chmod +x /usr/local/bin/docker-compose

        # cd to home directory
        cd /home/ubuntu

        # Install git
        apt-get install -y git

        # Fetch the repo
        git clone https://github.com/MedNoun/sahnoun-co.git

        # Change directory to the repo
        cd sahnoun-co.git

        # Switch to user ubuntu
        su ubuntu
        
        # Run docker-compose up -d
        docker-compose up -d
  EOF
  associate_public_ip_address = true
  security_groups             = [aws_security_group.instance_sg.name]
  tags = {
    Name = "Urbanisation" # Replace with your desired instance name
  }
}

resource "aws_security_group" "instance_sg" {
  name        = "instance_sg"
  description = "Security group for EC2 instance"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 3001
    to_port     = 3001
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 3000
    to_port     = 3000
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 5000
    to_port     = 5000
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

output "public_dns" {
  value = aws_instance.ec2_instance.public_dns
}

