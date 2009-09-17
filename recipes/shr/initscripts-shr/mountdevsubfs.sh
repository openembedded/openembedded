#!/bin/sh

. /etc/default/devpts

test -c /dev/ptmx || mknod -m 666 /dev/ptmx c 5 2

if [ -d /dev/pts ]; then
	mount -n -t devpts devpts /dev/pts -ogid=${TTYGRP},mode=${TTYMODE}
fi


if [ -d /dev/shm ]; then
	mount -n -t tmpfs shmfs /dev/shm -omode=0777
fi
