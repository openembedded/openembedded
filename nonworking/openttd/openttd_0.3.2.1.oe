DESCRIPTION = "Open Transport Tycoon Clone for SDL."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe libsdl-qpe libsdl-image libsdl-mixer"

SRC_URI = "${SOURCEFORGE_MIRROR}/openttd/openttd-${PV}.tbz"

do_compile() {
	oe_runmake WITH_ZLIB=1 UNIX=1 MANUAL_CONFIG=1
}

do_install() {
        install -d ${D}/${palmtopdir}/apps/Games \
        	   ${D}/${palmtopdir}/pics \
        	   ${D}/${palmtopdir}/share/vectoroids \
        	   ${D}/${palmtopdir}/bin
        install -m 0755 vectoroids-${PV} ${D}/${palmtopdir}/bin/vectoroids
	install -m 0644 data/images/icon.png ${D}/${palmtopdir}/pics/vectoroids.png
	cp -a data/* ${D}/${palmtopdir}/share/vectoroids

	echo "[Desktop Entry]" >${D}/${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Comment=Asteroids game" >>${D}/${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Exec=vectoroids" >>${D}/${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Icon=vectoroids" >>${D}/${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Type=Application" >>${D}/${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Name=Vectoroids" >>${D}/${palmtopdir}/apps/Games/vectoroids.desktop
}
