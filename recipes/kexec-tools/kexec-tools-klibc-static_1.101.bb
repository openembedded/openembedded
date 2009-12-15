# the binaries are statical linked against klibc
require kexec-tools.inc

PR = "r7"
DEPENDS = "klibc"

SRC_URI += "file://kexec-static.patch;patch=1 \
	    file://kexec-klibc.patch;patch=1 \
	    "
S = "${WORKDIR}/kexec-tools-${PV}"

EXTRA_OECONF = " --without-zlib"

export CC=${TARGET_PREFIX}klcc

PACKAGES =+ "kexec-klibc-static kdump-klibc-static"

FILES_kexec-klibc-static = "${sbindir}/kexec"
FILES_kdump-klibc-static = "${sbindir}/kdump"
