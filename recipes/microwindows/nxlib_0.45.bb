DESCRIPTION = "NXLIB X11 Emulation Library for Nano-X"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "virtual/libx11"
DEPENDS = "microwindows-snapshot"

PR="r0"

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/nxlib-${PV}.tar.gz \
  file://varargs.patch;patch=1 \
 "

EXTRA_OEMAKE = ' \
  CC="${CC}" \
  MWIN=${STAGING_DIR}/${HOST_SYS} \
  X11=${STAGING_DIR}/${HOST_SYS} \
 '

# not sure yet about installation -- uncommenting below over-writes libX11 in staging
#do_install() {
#  oe_runmake install
#}


SRC_URI[md5sum] = "9a1e3b81df0e32189fa873fd6fc086e5"
SRC_URI[sha256sum] = "8e63251e1599474d18912ad82b2e6b0c6c612e7eb9507958ab0f60f92d7ea454"
