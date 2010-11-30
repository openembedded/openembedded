# the binaries are statically linked against klibc
require kexec-tools_${PV}.inc

PR = "r3"
inherit klibc

FILESPATHPKG =. "kexec-tools-${PV}:"

SRC_URI += "file://elf.patch \
            file://errno.patch \
            file://string.patch \
            file://syscall.patch \
            file://other.patch \
            "

S = "${WORKDIR}/kexec-tools-${PV}"

EXTRA_OECONF = " --without-zlib"

PACKAGES =+ "kexec-klibc kdump-klibc"

CFLAGS += "-I${STAGING_DIR_HOST}${base_libdir}/klibc/include -I${STAGING_DIR_HOST}${base_libdir}/klibc/include/bits32"

FILES_kexec-klibc = "${sbindir}/kexec"
FILES_kdump-klibc = "${sbindir}/kdump"
