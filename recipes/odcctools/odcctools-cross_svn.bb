DESCRIPTION = "cctools for darwin"
HOMEPAGE = "http://code.google.com/p/iphone-dev"
DEPENDS = "cross-linkage bison-native"
PROVIDES = "virtual/${TARGET_PREFIX}binutils"
PV = "0.0+svnr${SRCPV}"
PR = "r2"

SRCREV="280"
SRC_URI = "svn://iphone-dev.googlecode.com/svn/branches;proto=http;module=odcctools-9.2-ld"

S = "${WORKDIR}/odcctools-9.2-ld"

inherit cross autotools

LDFLAGS += "-m32"
CFLAGS += "-m32"
EXTRA_OECONF += "--disable-ld64"

