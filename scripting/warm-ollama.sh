#!/usr/bin/env bash
set -euo pipefail

COUNT="${COUNT:-5}"
NETWORK="${NETWORK:-hybrid-retrieval-and-ranking-engine_default}"
QUERY="warm+up"

echo "Warming Ollama/vector-service $COUNT times..."
for run in $(seq 1 "$COUNT"); do
  printf "Run %s/%s: " "$run" "$COUNT"
  docker run --rm \
    --network "$NETWORK" \
    curlimages/curl -s -o /dev/null -w "%{time_total}\n" \
    "http://vector-service:8084/api/vector/search?query=$QUERY&topK=1"
done
echo "Warm-up complete"
