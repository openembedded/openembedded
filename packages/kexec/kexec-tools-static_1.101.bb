require kexec-tools.inc

PR = "r0"

SRC_URI += "file://kexec-static.patch;patch=1"
S = "${WORKDIR}/kexec-tools-${PV}"

PACKAGES =+ "kexec-static kdump-static"

FILES_kexec-static = "${sbindir}/kexec"
FILES_kdump-static = "${sbindir}/kdump"

