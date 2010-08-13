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

SRC_URI[md5sum] = "e4bbadadae85e5e008690b52dd51f102"
SRC_URI[sha256sum] = "8b5788aa7b8c3fa372e6c5f671592731c86e41322bcc09facb6bbe6127e323f2"

EXTRA_OECONF += "\
  --disable-gtkspell \
  --disable-meanwhile \
  --disable-nm \
  --disable-screensaver \
"
