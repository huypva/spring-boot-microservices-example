curl -X POST http://localhost:8081/call_service_b -H "Content-Type: application/json" -d '{"id":1, "message":"abc"}'

curl -X POST http://localhost:8081/message_c/1?message=abc
curl -X GET http://localhost:8081/message_c/1

curl -X POST http://localhost:8081/send_message_d -H "Content-Type: application/json" -d '{"id":1, "message":"abc"}'