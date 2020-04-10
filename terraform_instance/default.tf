resource "aws_instance" "myInstance"{
    ami = "ami-08e7548fff4886792"
    instance_type = var.Inst_type
    key_name = "POC-Key"
    iam_instance_profile = "petclinic"
    security_groups = ["${aws_security_group.docker_security.name}"]  
    tags = {
    Name        = "my-docker-server"
  }
}

resource "aws_security_group" "docker_security"{
        name="docker_security"
        ingress{
                from_port=22
                to_port=22
                protocol="tcp"
                cidr_blocks=["0.0.0.0/0"]
        }
        ingress{
                from_port=8080
                to_port=8080
                protocol="tcp"
                cidr_blocks=["0.0.0.0/0"]
        }
        egress{
                from_port=0
                to_port=0
                protocol="-1"
                cidr_blocks=["0.0.0.0/0"]
        }
}
resource "null_resource" "MyExec" {
 provisioner "local-exec" {
   command = <<EOT
    aws ec2 associate-address --instance-id ${aws_instance.myInstance.id} --allocation-id eipalloc-0587a735a9d154569 --region eu-central-1
  EOT
 }
}