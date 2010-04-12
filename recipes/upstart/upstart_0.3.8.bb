require upstart.inc

SRC_URI = "http://upstart.ubuntu.com/download/0.3/upstart-${PV}.tar.bz2 \
file://autoconf_version.patch;patch=1"

PR = "r1"


SRC_URI[md5sum] = "5cdd2dc3a3f02089c9450edf4e8f4941"
SRC_URI[sha256sum] = "9a2a37455ad4e9dd2856b5a0f15adb1a3f84439f60d0f63b041584a2666e9835"
