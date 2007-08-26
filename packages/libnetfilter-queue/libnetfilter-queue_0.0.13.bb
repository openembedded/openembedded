DESCRIPTION = "libnetfilter_queue is a userspace library providing an API to \
packets that have been queued by the kernel packet filter. It is is part of a \
system that deprecates the old ip_queue / libipq mechanism."

SECTION = "devel/libs"
LICENSE = "GPL"
HOMEPAGE = "http://www.netfilter.org/projects/libnetfilter_queue/index.html"
PR = "r0"


# This package requires libtool-cross-1.5.24 which is not the default libtool
# used by OE (25AUG2007)
DEPENDS = "libnfnetlink libtool-cross (>=1.5.24)"

SRC_URI = "http://www.netfilter.org/projects/libnetfilter_queue/files/libnetfilter_queue-${PV}.tar.bz2"

S = "${WORKDIR}/libnetfilter_queue-${PV}"

inherit autotools pkgconfig

do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

