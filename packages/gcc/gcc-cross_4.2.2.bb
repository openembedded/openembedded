require gcc-${PV}.inc
require gcc-package-target.inc
require gcc-cross.inc
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"
PR = "r6"

DEPENDS += "gmp-native mpfr-native"

# cross build
require gcc3-build-cross.inc
# cross packaging
require gcc-package-cross.inc
SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "
# Do not build libssp libmudflap and libgomp
# We might need them for some beefy targets 
EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_DIR_NATIVE}${layout_exec_prefix}"
