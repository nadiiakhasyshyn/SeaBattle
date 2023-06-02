resource "aws_elastic_beanstalk_application" "seabattleapp" {
  name        = "sea-battle-app"
  description = "SeaBattle application"
  tags = {"test": "test-terraform"}

  appversion_lifecycle {
    service_role          = aws_iam_role.beanstalk_service.arn
    max_count             = 128
    delete_source_from_s3 = true
  }
}

resource "aws_s3_bucket" "app-version-bucket" {
  bucket = "sea-battle-test-bucket"
}

resource "aws_s3_object" "bucket-obj" {
  bucket = aws_s3_bucket.app-version-bucket.id
  key    = "springboot-backend-0.0.1-SNAPSHOT.jar"
  source = "../target/SeaBattle-0.0.1-SNAPSHOT.jar"
}

resource "aws_elastic_beanstalk_application_version" "app-version" {
  name        = "1.0"
  application = aws_elastic_beanstalk_application.seabattleapp.name
  description = "application version created by terraform"
  bucket      = aws_s3_bucket.app-version-bucket.id
  key         = aws_s3_object.bucket-obj.id
}

resource "aws_elastic_beanstalk_environment" "develop-env" {
  name                = "SeaBattle"
  application         = aws_elastic_beanstalk_application.seabattleapp.name
  solution_stack_name = "64bit Amazon Linux 2 v3.4.8 running Corretto 17"
  version_label       = aws_elastic_beanstalk_application_version.app-version.name

  setting {
        namespace = "aws:autoscaling:launchconfiguration"
        name      = "IamInstanceProfile"
        value     = aws_iam_instance_profile.beanstalk_instance_profile.name
    }

  setting {
        namespace = "aws:autoscaling:launchconfiguration"
        name      = "DisableIMDSv1"
        value     = true
    }

  setting {
        namespace = "aws:autoscaling:launchconfiguration"
        name      = "InstanceType"
        value     = "t2.micro"
    }

  setting {
        namespace = "aws:elasticbeanstalk:application:environment"
        name      = "SERVER_PORT"
        value     = "5000"
    }

  setting {
        namespace = "aws:elasticbeanstalk:environment"
        name      = "EnvironmentType"
        value     = "SingleInstance"
    }

  setting {
        namespace = "aws:elasticbeanstalk:environment"
        name      = "ServiceRole"
        value     = aws_iam_role.beanstalk_service.name
    }

  setting {
        namespace = "aws:rds:dbinstance"
        name      = "HasCoupledDatabase"
        value     = true
    }
  setting {
        namespace = "aws:rds:dbinstance"
        name      = "DBDeletionPolicy"
        value     = "Delete"
    }
  setting {
        namespace = "aws:rds:dbinstance"
        name      = "DBPassword"
        value     = var.db_password
    }

  setting {
        namespace = "aws:rds:dbinstance"
        name      = "DBUser"
        value     = var.db_user
    }

  setting {
        namespace = "aws:rds:dbinstance"
        name      = "DBInstanceClass"
        value     = "db.t2.micro"
    }

  setting {
        namespace = "aws:rds:dbinstance"
        name      = "DBEngine"
        value     = "mysql"
    }

  setting {
        namespace = "aws:rds:dbinstance"
        name      = "DBAllocatedStorage"
        value     = "5"
    }
}

resource "aws_ssm_parameter" "ssm_backend_url_parameter" {
  name  = var.ssm_parameter_backend_url
  type  = "String"
  value = aws_elastic_beanstalk_environment.develop-env.cname
}