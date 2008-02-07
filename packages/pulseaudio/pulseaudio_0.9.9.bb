require pulse.inc

DEPENDS += "dbus"

# this is not correct (see below)
SRC_URI += "\
  file://disable-using-glibc-tls.patch;patch=1 \
  file://fix-dbus-without-hal.patch;patch=1 \
"            

PR = "r1"

# problems w/ pulseaudio 0.9.9 atm:
# 1.) needs libltdl >= 1.5.24 (yes, any older version will NOT work at runtime)
# 2.) doesn't build w/ glibc TLS support (hence patched out)
# 3.) hangs, if used with gst-pulse 0.9.7, fails with hierarchical pthread stuff
DEFAULT_PREFERENCE = "-1"

