#!/bin/sh

. /etc/default/devpts

test -c /dev/ptmx || mknod -m 666 /dev/ptmx c 5 2
test -c /dev/ttySAC0 || mknod /dev/ttySAC0 c 204 64
test -c /dev/ttySAC1 || mknod /dev/ttySAC1 c 204 65
test -c /dev/ttySAC2 || mknod /dev/ttySAC2 c 204 66

if [ ! -d /dev/pts ]; then
        mkdir /dev/pts
fi
if [ ! -d /dev/shm ]; then
        mkdir /dev/shm
fi

mount -n -t devpts devpts /dev/pts -ogid=${TTYGRP},mode=${TTYMODE}
mount -n -t tmpfs shmfs /dev/shm -omode=0777
