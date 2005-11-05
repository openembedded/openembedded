DESCRIPTION = "Checkers"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
AUTHOR = "Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Crossword.html"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/crossword_V0.0.3.tar.gz \
	   file://crossword.patch;patch=1"

PV = "0.0.3"
S = "${WORKDIR}/crossword_V${PV}"

APPNAME = "crossword"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	
}

pkg_postinst() {
#!/bin/sh

MIMEFILE=/opt/QtPalmtop/etc/mime.types

grep -q application/puz $MIMEFILE 2>/dev/null || echo -e "application/crossword\t\tpuz tpz" >> $MIMEFILE
}

inherit opie
