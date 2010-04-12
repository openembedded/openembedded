require pulseaudio.inc

PR = "${INC_PR}.1"

# this is not correct (see below)
SRC_URI += "\
  file://disable-using-glibc-tls.patch;patch=1 \
  file://fix-dbus-without-hal.patch;patch=1 \
  file://fix-shm.patch;patch=1 \
"            

# problems w/ pulseaudio 0.9.9 atm:
# 1.) needs libltdl >= 1.5.24 (yes, any older version will NOT work at runtime)
# 2.) doesn't build w/ glibc TLS support (hence patched out)
# 3.) fails with hierarchical pthread stuff w/ gst-pulse (hence patched out)

SRC_URI[md5sum] = "8fa6f7a9611bb194d94311764022b197"
SRC_URI[sha256sum] = "9caab8f9be8a371aea7cd0241aab7ffd4b1043fbc4a8f62736faea4229f11f7d"
