DESCRIPTION = "Raw Glue AP"
SECTION = "console/network"
HOMEPAGE = "http://rfakeap.tuxfamily.org/#Raw_Glue_AP"
LICENSE = "GPLv2"
DEPENDS = "libpcap"

SRC_URI = "http://rfakeap.tuxfamily.org/rglueap-${PV}.tar.gz"

LDFLAGS += "-lpcap"

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 rglueap ${D}/${sbindir}
}

