require clamav.inc

SRC_URI += "file://fix-llvm-cross-configure.patch \
	    file://fix-libclamav.pc.in.patch"

SRC_URI[clamav-0.96.1.md5sum] = "38e7870db6e9ad0e569518499a6f3651"
SRC_URI[clamav-0.96.1.sha256sum] = "413dd25907059068da2a367d2b330fbc37d5d2764eb3b047214ce754a9ca74ea"

PR = "${INC_PR}.1"

EXTRA_OECONF_append_libc-uclibc = " --disable-llvm"

# Autoreconf breaks on llvm with
# gnu-configize: `configure.ac' or `configure.in' is required
#
# Works good enough without autoreconf
do_configure() {
	oe_runconf
}

FILES_${PN}_append = " ${bindir}/clambc"
