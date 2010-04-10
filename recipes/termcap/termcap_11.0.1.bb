DESCRIPTION = "Terminal Capabilities File"
SECTION = "base"
HOMEPAGE = "http://www.catb.org/~esr/terminfo/"
LICENSE = "PD"

SRC_URI = "http://www.catb.org/~esr/terminfo/termtypes.tc.gz"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 termtypes.tc ${D}${sysconfdir}/termcap
}

PACKAGES = "${PN}-dbg termcap"
FILES_termcap = "${sysconfdir}"


SRC_URI[md5sum] = "37318885db65314f1bcc2b22751123d3"
SRC_URI[sha256sum] = "c4fa04257fea6e968d4caa28cc18dbbf9eea4769a463296eaca21ceea757a728"
