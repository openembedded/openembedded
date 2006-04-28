SECTION = "base"
DESCRIPTION = "kernel routing and traffic control utilities"
LICENSE = "GPL"
DEPENDS = "flex-native bison-native"

DATE="060323"
SRC_URI="http://developer.osdl.org/dev/iproute2/download/${P}-${DATE}.tar.gz \
	file://iproute2-2.6.15_no_strip.diff;patch=1;pnum=0"
PR="r0"
S="${WORKDIR}/${P}-${DATE}"
	
EXTRA_OEMAKE = "CC='${CC}' KERNEL_INCLUDE=${STAGING_KERNEL_DIR}/include DOCDIR=${docdir}/iproute2 SUBDIRS='lib tc ip' SBINDIR=/sbin"

do_install () {
	oe_runmake DESTDIR=${D} install
}
