DESCRIPTION = "Clone of the classic Paradroid from C64 for Qtopia/Opie - based on SDL"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://freedroid.sourceforge.net/"
DEPENDS = "virtual/libqpe libsdl-qpe libsdl-image"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/freedroid/freedroid-${PV}.tar.gz \
           file://icon.png"

inherit autotools 

do_compile() {
	oe_runmake pkgdatadir=${palmtopdir}/share/freedroid
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Games \
		   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/share/freedroid/graphics \
		   ${D}${palmtopdir}/share/freedroid/map \
		   ${D}${palmtopdir}/share/freedroid/sound
        install -D -m 0755 src/freedroid ${D}${palmtopdir}/bin/freedroid
	install -D -m 0644 ${WORKDIR}/icon.png ${D}${palmtopdir}/pics/freedroid.png

	cp -a graphics/* ${D}${palmtopdir}/share/freedroid/graphics
	cp -a map/* ${D}${palmtopdir}/share/freedroid/map
	cp -a sound/* ${D}${palmtopdir}/share/freedroid/sound

	echo "[Desktop Entry]" >${D}${palmtopdir}/apps/Games/freedroid.desktop
	echo "Comment=A Paradroid Clone" >>${D}${palmtopdir}/apps/Games/freedroid.desktop
	echo "Exec=freedroid" >>${D}${palmtopdir}/apps/Games/freedroid.desktop
	echo "Icon=freedroid" >>${D}${palmtopdir}/apps/Games/freedroid.desktop
	echo "Type=Application" >>${D}${palmtopdir}/apps/Games/freedroid.desktop
	echo "Name=Freedroid" >>${D}${palmtopdir}/apps/Games/freedroid.desktop
}

FILES_${PN} = ""
FILES_${PN} = "${palmtopdir}/"
