require dt.inc

PR = "${INC_PR}.1"

SRC_URI_append_linux-uclibc = " file://no_aio.patch;patch=1 "
SRC_URI_append_linux-uclibcgnueabi = " file://no_aio.patch;patch=1 "

do_install() {
	install -d ${D}${bindir}
	install -m 0755 dt ${D}${bindir}
}

SRC_URI[md5sum] = "5776233a2d301a50b314306538257a45"
SRC_URI[sha256sum] = "2f27fda643093e07161d128a9cc23cf30c0387f87cd911b904d84217f60a9a2a"
