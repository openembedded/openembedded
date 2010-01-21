# the binaries are statical linked against klibc
require kexec-tools2.inc

DEFAULT_PREFERENCE = "1"

PR = "r4"
DEPENDS = "klibc"

SRC_URI += "file://kexec-tools-2-headers.patch;patch=1 \
	    file://kexec-tools-2-klibc.patch;patch=1 \
	    "

S = "${WORKDIR}/kexec-tools-${PV}"

EXTRA_OECONF = " --without-zlib"

export CC=${TARGET_PREFIX}klcc

# reset inherited OE flags to avoid e.g. ggdb3 and keep size small
export CFLAGS=""
export CPPFLAGS=""
export LDFLAGS=""

PACKAGES =+ "kexec-klibc-static kdump-klibc-static"

FILES_kexec-klibc-static = "${sbindir}/kexec"
FILES_kdump-klibc-static = "${sbindir}/kdump"
