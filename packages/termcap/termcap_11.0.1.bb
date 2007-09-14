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

PACKAGES = "termcap"
FILES_termcap = "${sysconfdir}"

