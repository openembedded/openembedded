SECTION = "console/network"
DESCRIPTION = "Raw Fake AP"
HOMEPAGE = "http://rfakeap.tuxfamily.org/"
LICENSE = "GPLv2"
DEPENDS = "libpcap"
PV="0.2"
PR ="r1"

SRC_URI = "http://rfakeap.tuxfamily.org/rfakeap-0.2.tar.gz"

#EXTRA_OEMAKE = "CFLAGS='${CFLAGS} -O3'"

oe_compile() { 
	oe_runmake CC="${CC}" CXX="${CXX}" CFLAGS="-O3 ${CFLAGS}" CXXFLAGS="${CXXFLAGS}" LD="${LD}" LDFLAGS="${LDFLAGS}"
}

do_install() {
        install -d ${D}/${sbindir}
	install -d ${D}/${sysconfdir}
        install -m 0755 ${WORKDIR}/${PN}-${PV}/rfakeap           ${D}/${sbindir}
#	install -m 0644 ap_manuf	  ${D}/${sysconfdir}
}
