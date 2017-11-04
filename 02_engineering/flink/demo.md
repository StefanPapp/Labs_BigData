#open three terminals
nc -l 9000

#terminal 2
in flink dir
tail -f log/flink-*-jobmanager-*.out

#terminal 3
in flink dir
bin/start_local.sh
bin/flink run examples/streaming/SocketWindowWordCount.jar \
  --hostname localhost \
  --port 9000
