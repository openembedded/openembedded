SECTION = "console/utils"
DESCRIPTION = "User-space keyboard daemon for external keyboards"
MAINTAINER = "Paul Eggleton <paule@handhelds.org>"
SRC_URI = "${HANDHELDS_CVS};module=apps/kbdd;date=${CVSDATE}"
HOMEPAGE = "http://handhelds.org/moin/moin.cgi/kbdd"
LICENSE = "GPLv2"

PV="0.6+cvs-${CVSDATE}"

S = "${WORKDIR}/kbdd"
LICENSE = "GPL"
do_compile() {
	oe_runmake CFLAGS="${CFLAGS} -DVERSION=\'${PV}\'"
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${docdir}/kbdd/
	install -m 0755 kbdd ${D}${bindir}/
	install -m 0644 README ${D}${docdir}/kbdd/
}
