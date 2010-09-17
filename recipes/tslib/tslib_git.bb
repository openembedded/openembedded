SRC_URI = "git://github.com/kergoth/tslib.git;protocol=git"
S = "${WORKDIR}/git"
SRCREV = "d9ff92d46a1e17361ac1"
PV = "1.0+gitr${SRCPV}"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

# move this to tslib.inc when upstream releases a new version which includes support for
# the palmpre machine
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
