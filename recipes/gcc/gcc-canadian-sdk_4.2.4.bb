inherit canadian-sdk

PR = "${INC_PR}.2"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gcc-${PV}"

PACKAGES = "${PN}"

require gcc-${PV}.inc

# Correct gmp / mpfr
DEPENDS = "gmp-canadian mpfr-canadian"

require gcc-configure-canadian-sdk.inc
require gcc-package-sdk.inc

SRC_URI_append = "file://fortran-cross-compile-hack.patch;patch=1 \
		  file://pr22133-mingw-path-fixup.patch;patch=1 \
		  file://pr33281-mingw-host-fragment.patch;patch=1 \
		  file://pr35916-mingw-__USE_MINGW_ACCESS-everywhere.patch;patch=1 \
		  file://canadian-build-modules-configure.patch;patch=1 \
"

EXTRA_OECONF += "--disable-libunwind-exceptions --disable-libssp \
		--disable-libgomp --disable-libmudflap \
		--with-mpfr=${STAGING_LIBDIR}"

