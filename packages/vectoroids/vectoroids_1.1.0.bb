DESCRIPTION = "Clone of the classic arcade game Asteroids for Qtopia/Opie - based on SDL"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe libsdl-qpe libsdl-image libsdl-mixer"
PR = "r1"

SRC_URI = "ftp://ftp.billsgames.com/unix/x/vectoroids/src/vectoroids-${PV}.tar.gz"

inherit palmtop

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/SDL LIBS+=-lSDL LIBS+=-lSDL_mixer \
   			LIBS+=-lSDLmain LIBS+=-lSDL_image LIBS+=-lpthread LIBS+=-lqpe CONFIG+=qte"

do_configure_prepend() {
        qmake -project vectoroids.pro
}

do_install() {
        install -d ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/share/vectoroids \
        	   ${D}${palmtopdir}/bin
        install -m 0755 vectoroids-${PV} ${D}${palmtopdir}/bin/vectoroids
	install -m 0644 data/images/icon.png ${D}${palmtopdir}/pics/vectoroids.png
	cp -a data/* ${D}${palmtopdir}/share/vectoroids

	echo "[Desktop Entry]" >${D}${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Comment=Asteroids game" >>${D}${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Exec=vectoroids" >>${D}${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Icon=vectoroids" >>${D}${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Type=Application" >>${D}${palmtopdir}/apps/Games/vectoroids.desktop
	echo "Name=Vectoroids" >>${D}${palmtopdir}/apps/Games/vectoroids.desktop
}
