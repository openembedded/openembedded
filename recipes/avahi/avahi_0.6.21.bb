require avahi.inc

PR = "r10"

SRC_URI += "file://dbus-pre-1.1.1-support.patch;patch=1"
SRC_URI += "file://avr32-ipv6-fix.patch;patch=1"

SRC_URI[md5sum] = "9cc68f79c50c9dd9e419990c3c9b05b9"
SRC_URI[sha256sum] = "d817c35f43011861476eab02eea14edd123b2bc58b4408d9d9b69b0c39252561"
