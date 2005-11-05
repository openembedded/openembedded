MAINTAINER = "Matthias 'CoreDump' Hentges <coredump@handhelds.org>"
DESCRIPTION = "Displays a list of available ROMs for use with snes9x."
SECTION = "opie/shell"
PRIORITY = "optional"
LICENSE = "GPL"

RDEPENDS = "opie-sh"


PR = "r2"

FILES_${PN} = "/opt/QtPalmtop"

SRC_URI = "file://snes.desktop \
           file://snes.png \
	   file://opie-sh-snes.sh"
	   

do_install() {

	for dir in apps apps/Games bin pics
	do
		install -d ${D}${palmtopdir}/$dir
	done
	
	install -m 755 ${WORKDIR}/opie-sh-snes.sh ${D}${palmtopdir}/bin
	install -m 644 ${WORKDIR}/*.png ${D}${palmtopdir}/pics
	install -m 644 ${WORKDIR}/*.desktop ${D}${palmtopdir}/apps/Games
}	   
