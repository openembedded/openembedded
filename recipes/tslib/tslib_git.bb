SRC_URI = "git://github.com/kergoth/tslib.git;protocol=git"
S = "${WORKDIR}/git"
SRCREV = "5243db505b109df3001f"
PV = "1.0+gitr${SRCPV}"
PR = "${INC_PR}.2"

DEFAULT_PREFERENCE = "-1"

# move this to tslib.inc when upstream releases a new version which includes support for
# the palmpre machine
SRC_URI_append_palmpre = " \
  file://include-cy8mrln-header.patch \
"
EXTRA_OECONF_palmpre = " \
   --enable-shared \
   --enable-cy8mrln-palmpre \
   --enable-input \
   --disable-h3600 \
   --disable-corgi \
   --disable-collie \
   --disable-mk712 \
   --disable-artic2 \
   --disable-ucb1x00 \
   --disable-tatung \
"

include tslib.inc
