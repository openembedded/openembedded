# the binaries are statically linked against dietlibc
require kexec-tools_${PV}.inc

PR = "r0"
inherit dietlibc

FILESPATHPKG =. "kexec-tools-${PV}:"

SRC_URI += "file://dietlibc.patch "

S = "${WORKDIR}/kexec-tools-${PV}"

PACKAGES =+ "kexec-dietlibc kdump-dietlibc"

FILES_kexec-dietlibc = "${sbindir}/kexec"
FILES_kdump-dietlibc = "${sbindir}/kdump"
