#!/bin/sh

modprobe -q vfat >/dev/null 2>&1
modprobe -q ext2 >/dev/null 2>&1
modprobe -q ext3 >/dev/null 2>&1
