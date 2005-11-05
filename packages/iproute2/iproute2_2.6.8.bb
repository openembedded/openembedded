SECTION = "base"
DESCRIPTION = "kernel routing and traffic control utilities"
LICENSE = "GPL"

SRC_URI="http://developer.osdl.org/dev/iproute2/download/iproute2-2.6.8-ss040730.tar.gz \
	file://iproute2-2.6.8_no_strip.diff;patch=1;pnum=0"

PR="r1"
	
EXTRA_OEMAKE = "CC='${CC}' KERNEL_INCLUDE=${STAGING_KERNEL_DIR}/include DOCDIR=${docdir}/iproute2 SUBDIRS='lib tc ip' SBINDIR=/sbin"

do_install () {
	oe_runmake DESTDIR=${D} install
}
