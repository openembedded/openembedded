include dbus.inc
PR = "${INC_PR}.0"
PV = "1.4.0+gitr${SRCPV}"

BBCLASSEXTEND = "native"

SRCREV = "a96fcb19d1e359207cbda355774851ab1bbbb81d"

SRC_URI = "\
  git://anongit.freedesktop.org/dbus/dbus;protocol=git;branch=master \
  \
  file://tmpdir.patch \
  file://add-configurable-reply-timeouts.patch \
  file://dbus-1.init \
"            

S = "${WORKDIR}/git"

# This needs more testing before pushing as default dbus
DEFAULT_PREFERENCE = "-1"
