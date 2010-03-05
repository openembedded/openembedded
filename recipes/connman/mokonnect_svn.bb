DESCRIPTION = "mokonnect is an e17 frontend to connmand"
HOMEPAGE = "http://www.assembla.com/wiki/show/shrdev"
AUTHOR = "Fate"
LICENSE = "GPLv2"
SECTION = "e/apps"
RDEPENDS = "python-elementary connman connman-plugin-wifi connman-plugin-udhcp"

PV = "0.4+svnr${SRCPV}"
PR = "r3"

SRC_URI = "svn://subversion.assembla.com/svn/shrdev;module=Mokonnect/trunk;proto=http"

S = "${WORKDIR}/Mokonnect/trunk"

do_install() {
	install -d ${D}${datadir}/mokonnect
	for pyfile in *.py
	do
		install -m 644 $pyfile ${D}${datadir}/mokonnect/
	done
	chmod 755 ${D}${datadir}/mokonnect/mokonnect.py

	install -d ${D}${datadir}/applications
	install -m 644 mokonnect.desktop ${D}${datadir}/applications/

	install -d ${D}${datadir}/pixmaps
	install -m 644 mokonnect.png ${D}${datadir}/pixmaps/

	install -d ${D}${bindir}
	ln -sf ${datadir}/mokonnect/mokonnect.py ${D}${bindir}/mokonnect
}

FILES_${PN} = "\
${datadir}/mokonnect \
${datadir}/applications/* \
${datadir}/pixmaps/* \
${bindir}/mokonnect \
"

