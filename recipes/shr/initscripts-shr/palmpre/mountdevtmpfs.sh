#!/bin/sh

mount -t devtmpfs -o mode=0755,nr_inodes=0 devtmpfs /dev

# Create additional nodes which devtmpfs does not provide
test -c /dev/fd || ln -s /proc/self/fd /dev/fd
test -c /dev/stdin || ln -s fd/0 /dev/stdin
test -c /dev/stdout || ln -s fd/1 /dev/stdout
test -c /dev/stderr || ln -s fd/2 /dev/stderr
