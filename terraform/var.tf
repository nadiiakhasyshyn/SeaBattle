variable "db_user" {
  type = string
  default = "springuser"
}

variable "db_password" {
  type = string
  default = "ThePassword"
}

variable "frontend-bucket_name" {
  type = string
  default = "seabattle-frontend-bucket"
}
variable "ssm_parameter_backend_url" {
  type = string
  default = "seabattle_backend_url"
}

