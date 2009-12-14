# the binaries are statical linked against dietlibc
require kexec-tools2.inc

SRC_URI += "file://dietlibc.patch;patch=1"

inherit dietlibc

PR = "r0"

S = "${WORKDIR}/kexec-tools-${PV}"

PACKAGES =+ "kexec-dietlibc kdump-dietlibc"

FILES_kexec-dietlibc = "${sbindir}/kexec"
FILES_kdump-dietlibc = "${sbindir}/kdump"
