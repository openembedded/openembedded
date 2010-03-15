DESCRIPTION = "kernel routing and traffic control utilities"
HOMEPAGE = "http://linux-net.osdl.org/index.php/Iproute2"
SECTION = "base"
LICENSE = "GPLv2"
DEPENDS = "flex-native bison-native"

INC_PR = "r3"

# Set the DATE in the .bb file
SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}-${DATE}.tar.gz"

S = "${WORKDIR}/iproute2-${PV}-${DATE}"

inherit update-alternatives

EXTRA_OEMAKE = "CC='${CC}' \
                KERNEL_INCLUDE=${STAGING_KERNEL_DIR}/include \
                DOCDIR=${docdir}/iproute2 \
                SUBDIRS='lib tc ip' \
                SBINDIR=${base_sbindir}"

do_install () {
        oe_runmake DESTDIR=${D} install
        mv ${D}${base_sbindir}/ip ${D}${base_sbindir}/ip.iproute2
        install -d ${D}${datadir}
        mv ${D}/share/* ${D}${datadir}/ || true
	rm ${D}/share -rf || true
}

FILES_${PN} += "/usr/lib/tc/*"
FILES_${PN}-dbg += "/usr/lib/tc/.debug"

ALTERNATIVE_NAME = "ip"
ALTERNATIVE_PATH = "${base_sbindir}/ip.iproute2"
ALTERNATIVE_LINK = "${base_bindir}/ip"
ALTERNATIVE_PRIORITY = "100"
