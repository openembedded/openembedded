DESCRIPTION = "GPG-Error library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"

DEPENDS += "virtual/libiconv"
DEPENDS_virtclass-native = ""

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/libgpg-error/libgpg-error-${PV}.tar.gz \
	   file://pkgconfig.patch;patch=1"

INC_PR = "r7"

# move libgpg-error-config into -dev package
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/*"

inherit autotools binconfig pkgconfig gettext

BBCLASSEXTEND = "native"
