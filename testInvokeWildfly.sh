#!/bin/bash

curl -X POST http://localhost:8080/render-service/api/report/render --data @payload.html -o output.pdf
