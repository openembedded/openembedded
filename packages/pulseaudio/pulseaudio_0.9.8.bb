require pulse.inc

DEPENDS += "dbus"

# this is not correct (see below)
SRC_URI += "\
  file://disable-using-glibc-tls.patch;patch=1 \
  file://fix-dbus-without-hal.patch;patch=1 \
"            

PR = "r0"

# problems w/ pulseaudio 0.9.8 atm:
# 1.) needs libltdl >= 1.5.24 (yes, any older version will NOT work at runtime)
# 2.) doesn't build w/ glibc TLS support (hence patched out)
DEFAULT_PREFERENCE = "-1"

