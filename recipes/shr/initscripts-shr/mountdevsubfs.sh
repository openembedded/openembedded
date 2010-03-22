#!/bin/sh

. /etc/default/devpts

test -c /dev/ptmx || mknod -m 666 /dev/ptmx c 5 2

if [ ! -d /dev/pts ]; then
        mkdir /dev/pts
fi
if [ ! -d /dev/shm ]; then
        mkdir /dev/shm
fi

mount -n -t devpts devpts /dev/pts -ogid=${TTYGRP},mode=${TTYMODE}
mount -n -t tmpfs shmfs /dev/shm -omode=0777
