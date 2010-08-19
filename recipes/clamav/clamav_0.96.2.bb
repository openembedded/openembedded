require clamav.inc

SRC_URI += "file://fix-llvm-cross-configure.patch \
	    file://fix-libclamav.pc.in.patch"

SRC_URI[clamav-0.96.2.md5sum] = "a2c2555d86868f91a01d0e2c2403bbec"
SRC_URI[clamav-0.96.2.sha256sum] = "6aa0b0d96ed25ffb4b5aca53f6348978c94771503c299f86e480fef475abcefa"

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
