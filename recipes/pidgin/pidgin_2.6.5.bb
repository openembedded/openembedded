require pidgin.inc
PR = "${INC_PR}.0"

DEPENDS += "farsight2 libidn"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pidgin/pidgin-${PV}.tar.bz2 \
  file://sanitize-configure.ac.patch;patch=1 \
  file://pidgin.desktop-set-icon.patch;patch=1 \
  file://purple-OE-branding-25.patch;patch=1 \
  file://pidgin-cross-python-265.patch;patch=1 \
"

EXTRA_OECONF += "\
  --disable-gtkspell \
  --disable-meanwhile \
  --disable-nm \
  --disable-screensaver \
"

SRC_URI[md5sum] = "90847ed22ec830db5d9768748812b661"
SRC_URI[sha256sum] = "3c459e4093fca679591e35ea34da4a0e45b15f2bb7ca00314a1486dc022f3d0e"
