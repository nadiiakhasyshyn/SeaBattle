data "aws_iam_policy_document" "allow-public-read-policy-document" {
  statement {
    principals {
      type        = "*"
      identifiers = ["*"]
    }
    actions = [
      "s3:GetObject",
      "s3:PutObject",
    ]
    resources = [
      "${aws_s3_bucket.frontend-bucket.arn}/*"
    ]
  }
}

resource "aws_s3_bucket_policy" "allow-public-read-policy" {
  bucket = aws_s3_bucket.frontend-bucket.id
  policy = data.aws_iam_policy_document.allow-public-read-policy-document.json
}

resource "aws_s3_bucket_versioning" "frontend-bucket-versioning" {
  bucket = aws_s3_bucket.frontend-bucket.id
  versioning_configuration {
    status = "Enabled"
  }
}

resource "aws_s3_bucket_website_configuration" "frontend-bucket-website-config" {
  bucket = aws_s3_bucket.frontend-bucket.id
  index_document {
    suffix = "index.html"
  }
  error_document {
    key = "index.html"
  }
}

resource "aws_s3_bucket_ownership_controls" "frontend-bucket-ownership-controls" {
  bucket = aws_s3_bucket.frontend-bucket.id
  rule {
    object_ownership = "BucketOwnerPreferred"
  }
}

resource "aws_s3_bucket_public_access_block" "frontend-bucket-public-access-block" {
  bucket = aws_s3_bucket.frontend-bucket.id

  block_public_acls       = false
  block_public_policy     = false
  ignore_public_acls      = false
  restrict_public_buckets = false
}

resource "aws_s3_bucket_acl" "frontend-bucket-acl" {
  depends_on = [
    aws_s3_bucket_ownership_controls.frontend-bucket-ownership-controls,
    aws_s3_bucket_public_access_block.frontend-bucket-public-access-block
  ]

  bucket = aws_s3_bucket.frontend-bucket.id
  acl    = "public-read"
}

resource "aws_s3_bucket" "frontend-bucket" {
  bucket = var.frontend-bucket_name
  force_destroy = true
}