require pidgin.inc
PR = "${INC_PR}.1"

DEPENDS += "farsight2 libidn"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pidgin/pidgin-${PV}.tar.bz2 \
  file://sanitize-configure.ac.patch;patch=1 \
  file://pidgin.desktop-set-icon.patch;patch=1 \
  file://purple-OE-branding-25.patch;patch=1 \
  file://pidgin-cross-python.patch;patch=1 \
  file://status-icon-theme-crash.patch;patch=1 \
"

EXTRA_OECONF += "\
  --disable-gtkspell \
  --disable-meanwhile \
  --disable-nm \
  --disable-screensaver \
"
