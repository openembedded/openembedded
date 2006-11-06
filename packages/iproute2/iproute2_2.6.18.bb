DESCRIPTION = "kernel routing and traffic control utilities"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "flex-native bison-native"
PR = "r0"

DATE = "061002"
SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}-${DATE}.tar.gz \
           file://iproute2-2.6.15_no_strip.diff;patch=1;pnum=0 \
           file://new-flex-fix.patch;patch=1"

S = "${WORKDIR}/${P}-${DATE}"

EXTRA_OEMAKE = "CC='${CC}' KERNEL_INCLUDE=${STAGING_KERNEL_DIR}/include DOCDIR=${docdir}/iproute2 SUBDIRS='lib tc ip' SBINDIR=/sbin"

do_install () {
        oe_runmake DESTDIR=${D} install
}

FILES_${PN} += "/usr/lib/tc/*"
FILES_${PN}-dbg += "/usr/lib/tc/.debug"
