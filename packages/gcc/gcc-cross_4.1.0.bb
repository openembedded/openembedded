require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"
PR = "r5"

DEPENDS += "gmp-native mpfr-native"

# cross build
require gcc3-build-cross.inc
# cross packaging
require gcc-package-cross.inc

EXTRA_OECONF += "--with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
