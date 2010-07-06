# the binaries are statical linked against klibc
require kexec-tools.inc

PR = "r9"
DEPENDS = "klibc"

FILESPATHPKG =. "kexec-tools-${PV}:"

SRC_URI += "file://kexec-static.patch \
            file://kexec-klibc.patch \
            "
S = "${WORKDIR}/kexec-tools-${PV}"

EXTRA_OECONF = " --without-zlib"

# reset inherited OE flags to avoid e.g. ggdb3 and keep size small
export CFLAGS=""
export CPPFLAGS=""
export LDFLAGS=""

export CC=${TARGET_PREFIX}klcc

PACKAGES =+ "kexec-klibc-static kdump-klibc-static"

FILES_kexec-klibc-static = "${sbindir}/kexec"
FILES_kdump-klibc-static = "${sbindir}/kdump"

SRC_URI[md5sum] = "b4f7ffcc294d41a6a4c40d6e44b7734d"
SRC_URI[sha256sum] = "280b34fefa12c3d7a3e432c3730fe5d0d56e8d169c28b695cce9ba6d8dbe6e38"
