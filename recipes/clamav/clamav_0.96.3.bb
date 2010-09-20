require clamav.inc

SRC_URI += " file://fix-llvm-cross-configure.patch \
	file://fix-libclamav.pc.in.patch"

SRC_URI[clamav-0.96.3.md5sum] = "663274565c4da17abb112ff88895e510"
SRC_URI[clamav-0.96.3.sha256sum] = "db324d50a2d4e71a9b647198a607e56b952eb480f75ad6a28231d1f713736c8b"

PR = "${INC_PR}.0"

EXTRA_OECONF_append_libc-uclibc = " --disable-llvm"

# Autoreconf breaks on llvm with
# gnu-configize: `configure.ac' or `configure.in' is required
#
# Works good enough without autoreconf
do_configure() {
	oe_runconf
}

FILES_${PN}_append = " ${bindir}/clambc"
