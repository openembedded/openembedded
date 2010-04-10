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


SRC_URI[md5sum] = "61b724a4e1a48d0735fb18d4f68c0506"
SRC_URI[sha256sum] = "13cce714959056d41627ec9442342d46072f9d72ef57554b9d03ebfb353ed2d1"
