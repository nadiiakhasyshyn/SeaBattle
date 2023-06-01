resource "aws_iam_role" "beanstalk_service" {
    name = "beanstalk-service"
    assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "elasticbeanstalk.amazonaws.com"
      },
      "Action": "sts:AssumeRole",
      "Condition": {
        "StringEquals": {
          "sts:ExternalId": "elasticbeanstalk"
        }
      }
    }
  ]
}
EOF
}

resource "aws_iam_role" "beanstalk_ec2" {
  name = "beanstalk-ec2"
  assume_role_policy = <<EOF
{
  "Version": "2008-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "ec2.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
EOF
}

resource "aws_iam_instance_profile" "beanstalk_instance_profile" {
  name = "beanstalk_instance_profile"
  role = aws_iam_role.beanstalk_ec2.name
}

resource "aws_iam_role_policy_attachment" "attachment_beanstalk" {
  for_each = toset([
    "arn:aws:iam::aws:policy/service-role/AWSElasticBeanstalkEnhancedHealth",
    "arn:aws:iam::aws:policy/AWSElasticBeanstalkManagedUpdatesCustomerRolePolicy",
  ])

  role       = aws_iam_role.beanstalk_service.name
  policy_arn = each.value
}

resource "aws_iam_role_policy_attachment" "attachment_ec2" {
  for_each = toset([
    "arn:aws:iam::aws:policy/AmazonEC2FullAccess",
    "arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier",
    "arn:aws:iam::aws:policy/AdministratorAccess-AWSElasticBeanstalk"
  ])

  role       = aws_iam_role.beanstalk_ec2.name
  policy_arn = each.value
}