#!/bin/sh

. /etc/default/rcS

[ "${VERBOSE}" != "no" ] && echo "Populating volatile Filesystems."

tar xzf /etc/var.tar.gz -C /
