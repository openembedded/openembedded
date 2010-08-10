require pidgin.inc
PR = "${INC_PR}.0"

DEPENDS += "farsight2 libidn"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pidgin/pidgin-${PV}.tar.bz2 \
  file://sanitize-configure.ac.patch \
  file://pidgin.desktop-set-icon.patch \
  file://purple-OE-branding-25.patch \
  file://pidgin-cross-python-265.patch \
"

SRC_URI[md5sum] = "c23d85bb6a197dd841d1b5585148327d"
SRC_URI[sha256sum] = "8ab5f126f384197727db8f61306663325c2779c25e54e61ff95366448a0861c0"

EXTRA_OECONF += "\
  --disable-gtkspell \
  --disable-meanwhile \
  --disable-nm \
  --disable-screensaver \
"
