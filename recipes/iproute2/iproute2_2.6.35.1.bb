require iproute2.inc

PR = "${INC_PR}.0"

# There is no tarball for v2.6.35.1, but there is a tag.
SRCREV = "v${PV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/shemminger/iproute2.git;protocol=git \
	   file://configure-cross.patch \
	  "

S = "${WORKDIR}/git"

do_configure () {
    ./configure ${STAGING_DIR_TARGET}
}

FILES_${PN} += "${base_libdir}/tc/*.so"
FILES_${PN}-dbg += "${base_libdir}/tc/.debug"
