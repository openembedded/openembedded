DESCRIPTION = "Raw Glue AP, wireless intrusion detection"
AUTHOR = "Laurent Butti"
HOMEPAGE = "http://rfakeap.tuxfamily.org/#Raw_Glue_AP"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "libpcap"

SRC_URI = "http://rfakeap.tuxfamily.org/${P}.tar.gz"

LDFLAGS += "-lpcap"

do_install() {
        install -d ${D}/${sbindir}
        install -m 0755 rglueap ${D}/${sbindir}
}

