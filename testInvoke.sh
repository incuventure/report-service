#!/bin/bash

curl -X POST http://localhost:9090/api/report/render --data @payload.html -o output.pdf
