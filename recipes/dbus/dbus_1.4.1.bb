include dbus.inc
PR = "${INC_PR}.0"

BBCLASSEXTEND = "native"

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
  \
  file://tmpdir.patch \
  file://add-configurable-reply-timeouts.patch \
  file://dbus-1.init \
"            

SRC_URI[md5sum] = "99cb057700c0455fb68f8d57902f77ac"
SRC_URI[sha256sum] = "caa1a0ded2d0f2e95c1d4ec7e3c8bd44834928c5b0ed41a7189963f3593983bd"
