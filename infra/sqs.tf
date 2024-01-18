resource "aws_sqs_queue" "queue_catalog_emit" {
  name                       = "catalog-emit"
  delay_seconds              = 10
  visibility_timeout_seconds = 30
  max_message_size           = 2048  ### in KiB
  message_retention_seconds  = 86400 ### in seconds
  receive_wait_time_seconds  = 2     ### in seconds
  sqs_managed_sse_enabled    = false
}


data "aws_iam_policy_document" "sh_sqs_policy" {
  statement {
    sid    = "catalogemitpolicydocument"
    effect = "Allow"

    principals {
      type        = "AWS"
      identifiers = ["*"]
    }

    actions = [
      "sqs:SendMessage",
      "sqs:ReceiveMessage"
    ]
    resources = [
      aws_sqs_queue.queue_catalog_emit.arn
    ]
  }
}

### Create policy to receive and send messages
resource "aws_sqs_queue_policy" "sh_sqs_policy" {
  queue_url = aws_sqs_queue.queue_catalog_emit.id
  policy    = data.aws_iam_policy_document.sh_sqs_policy.json
}