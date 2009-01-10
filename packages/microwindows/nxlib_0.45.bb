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

