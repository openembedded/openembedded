require pidgin.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pidgin/pidgin-${PV}.tar.bz2 \
  file://sanitize-configure.ac.patch \
  file://pidgin.desktop-set-icon.patch \
  file://purple-OE-branding-25.patch \
  file://pidgin-cross-python.patch \
"

EXTRA_OECONF += "\
  --disable-gtkspell \
  --disable-meanwhile \
  --disable-nm \
  --disable-screensaver \
"

SRC_URI[md5sum] = "c207407dca71c6357c82135875e472f0"
SRC_URI[sha256sum] = "2f79da1f127dd05f9404494ebc794f8cda919764fd2424f79df31f3b0f9dfd21"
