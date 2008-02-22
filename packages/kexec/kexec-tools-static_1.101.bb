# the binaries are statical linked against klibc
require kexec-tools.inc

PR = "r1"
DEPENDS = "klibc"

SRC_URI += "file://kexec-klibc.patch;patch=1"
S = "${WORKDIR}/kexec-tools-${PV}"

EXTRA_OECONF = " --without-zlib"

export CC=${TARGET_PREFIX}klcc

# standart oe cflags don't work with klcc
export CFLAGS=""
export CPPFLAGS=""
export LDFLAGS=""

PACKAGES =+ "kexec-klibc kdump-klibc"

FILES_kexec-klibc = "${sbindir}/kexec"
FILES_kdump-klibc = "${sbindir}/kdump"

