MAINTAINER = "Matthias 'CoreDump' Hentges <coredump@handhelds.org>"
DESCRIPTION = "Displays a list of available ROMs for use with snes9x."
SECTION = "opie/shell"
PRIORITY = "optional"
LICENSE = "GPL"

RDEPENDS = "opie-sh"


PR = "r1"

FILES_${PN} = "/opt/QtPalmtop"

SRC_URI = "file://snes.desktop \
           file://snes.png \
	   file://opie-sh-snes.sh"
	   

do_install() {

	for dir in apps apps/Games bin pics
	do
		install -d ${D}/opt/QtPalmtop/$dir
	done
	
	install -m 755 ${WORKDIR}/opie-sh-snes.sh ${D}/opt/QtPalmtop/bin
	install -m 644 ${WORKDIR}/*.png ${D}/opt/QtPalmtop/pics
	install -m 644 ${WORKDIR}/*.desktop ${D}/opt/QtPalmtop/apps/Games
}	   
