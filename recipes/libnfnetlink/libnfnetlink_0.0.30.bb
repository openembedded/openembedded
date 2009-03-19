DESCRIPTION = "libnfnetlink is the low-level library for netfilter related \
kernel/userspace communication. It provides a generic messaging \
infrastructure for in-kernel netfilter subsystems (such as nfnetlink_log, \
nfnetlink_queue, nfnetlink_conntrack) and their respective users and/or \
management tools in userspace."

SECTION = "devel/libs"
LICENSE = "GPL"
HOMEPAGE = "http://www.netfilter.org/projects/libnfnetlink/index.html"
PR = "r0"

SRC_URI = "http://www.netfilter.org/projects/libnfnetlink/files/libnfnetlink-${PV}.tar.bz2"

inherit autotools pkgconfig

do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_stage() {
	autotools_stage_all
}

