#!/bin/sh

mount proc -t proc /proc >/dev/null 2>&1

echo 0 > /proc/sys/kernel/printk

