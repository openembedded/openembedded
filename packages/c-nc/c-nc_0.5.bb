DESCRIPTION = "A Mastermind style game in GTK+"
SECTION = "x11/games"
LICENSE = "GPLv2"
HOMEPAGE = "http://freshmeat.net/projects/c-nc/"
DEPENDS = "gtk+"
AUTHOR = "Alexandru Scvortov <scvalex@gmail.com>"
PV = "0.5"

inherit autotools

SRC_URI = "http://c-nc.googlecode.com/files/c-nc-${PV}.tar.gz"

do_install() {
	install -d ${D}${bindir} ${D}${docdir}/c-nc
	install -m 0755 ${S}/c-nc ${D}${bindir}
	install -d ${D}${datadir}/applications/
	install -m 0755	${S}/c-nc.desktop ${D}${datadir}/applications/
}

