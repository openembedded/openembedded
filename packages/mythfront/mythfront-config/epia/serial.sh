#!/bin/sh

setserial /dev/ttyS0 uart none
modprobe lirc_serial
modprobe snes232
inputattach --snes232 /dev/ttyS1 &

