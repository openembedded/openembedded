require pidgin.inc
PR = "${INC_PR}.0"

DEPENDS += "farsight2 libidn"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pidgin/pidgin-${PV}.tar.bz2;name=pidgin \
  file://sanitize-configure.ac.patch;patch=1 \
  file://pidgin.desktop-set-icon.patch;patch=1 \
  file://purple-OE-branding-25.patch;patch=1 \
  file://pidgin-cross-python-265.patch;patch=1 \
"

SRC_URI[pidgin.md5sum] = "b37ab6c52db8355e8c70c044c2ba17c1"
SRC_URI[pidgin.sha256sum] = "6ebbe9d339246dfebb244e4c855c4feb678f120d1024ef2ee269e2fde77b2ad9"

EXTRA_OECONF += "\
  --disable-gtkspell \
  --disable-meanwhile \
  --disable-nm \
  --disable-screensaver \
"
