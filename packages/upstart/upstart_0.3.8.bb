require upstart.inc

SRC_URI = "http://upstart.ubuntu.com/download/0.3/upstart-${PV}.tar.bz2 \
file://autoconf_version.patch;patch=1"

PR = "r1"

