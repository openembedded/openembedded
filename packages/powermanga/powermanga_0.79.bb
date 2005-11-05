DESCRIPTION = "Powermanga is an arcade 2D shoot-em-up game with 41 levels and more than 200 sprites."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Chris Lord <cwiiis@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libsdl-qpe libsdl-mixer"
PR = "r1"

SRC_URI = "http://linux.tlk.fr/games/Powermanga/download/powermanga-0.79.tgz \
	   file://linuxroutines.cpp \
	   file://pda-tweaks.patch;patch=1 \
	   file://powermanga.pro \
	   file://powermanga.png \
	   file://powermanga.desktop"

S = ${WORKDIR}/${PN}-${PV}/

inherit palmtop

do_configure_prepend() {
	mv ${WORKDIR}/linuxroutines.cpp ${S}/src/
	mv ${WORKDIR}/powermanga.pro ${S}/
	rm -f `find ${S}/ -name Makefile\*`
	rm -f `find ${S}/ -name config\*`
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/share/games/powermanga/graphics \
		   ${D}${palmtopdir}/share/games/powermanga/sounds
        install -m 0755 ${S}/src/powermanga ${D}${palmtopdir}/bin/powermanga
	install -m 0644 ${WORKDIR}/powermanga.png ${D}${palmtopdir}/pics/powermanga.png
        install -m 0644 ${WORKDIR}/powermanga.desktop ${D}${palmtopdir}/apps/Games/powermanga.desktop
	install -m 0644 ${S}/graphics/* ${D}${palmtopdir}/share/games/powermanga/graphics/
	install -m 0644 ${S}/sounds/* ${D}${palmtopdir}/share/games/powermanga/sounds/
}
