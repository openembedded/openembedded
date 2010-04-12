# the binaries are statical linked against dietlibc
require kexec-tools2.inc

SRC_URI += "file://dietlibc.patch;patch=1"

inherit dietlibc

PR = "r0"

S = "${WORKDIR}/kexec-tools-${PV}"

PACKAGES =+ "kexec-dietlibc kdump-dietlibc"

FILES_kexec-dietlibc = "${sbindir}/kexec"
FILES_kdump-dietlibc = "${sbindir}/kdump"

SRC_URI[md5sum] = "a7710a89fb0096002bccc57ab202a874"
SRC_URI[sha256sum] = "95f352870df977271d912b6093f034bd3345e47a157493db96d1047b7654564d"
