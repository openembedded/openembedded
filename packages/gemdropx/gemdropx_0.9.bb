DESCRIPTION = "Classic arcade puzzle game Qtopia/Opie - based on SDL"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://www.newbreedsoftware.com/gemdropx/"
DEPENDS = "virtual/libqpe libsdl-qpe"
PR = "r3"

SRC_URI = "ftp://ftp.billsgames.com/unix/x/gemdropx/src/gemdropx-${PV}.tar.gz \
           file://directories.patch;patch=1 \
           file://icon.png"

inherit palmtop

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/SDL LIBS+=-lSDL LIBS+=-lSDL_mixer \
			LIBS+=-lSDLmain LIBS+=-lSDL_image LIBS+=-lpthread"

do_configure_prepend() {
        qmake -project -o gemdropx.pro
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Games \
		   ${D}${palmtopdir}/pics \
		   ${D}${palmtopdir}/share/gemdropx
        install -D -m 0755 gemdropx ${D}${palmtopdir}/bin/gemdropx
	install -D -m 0644 ${WORKDIR}/icon.png ${D}${palmtopdir}/pics/gemdropx.png
	cp -pPR data/* ${D}${palmtopdir}/share/gemdropx

	echo "[Desktop Entry]" >${D}${palmtopdir}/apps/Games/gemdropx.desktop
	echo "Comment=Puzzle game" >>${D}${palmtopdir}/apps/Games/gemdropx.desktop
	echo "Exec=gemdropx" >>${D}${palmtopdir}/apps/Games/gemdropx.desktop
	echo "Icon=gemdropx" >>${D}${palmtopdir}/apps/Games/gemdropx.desktop
	echo "Type=Application" >>${D}${palmtopdir}/apps/Games/gemdropx.desktop
	echo "Name=GemdropX" >>${D}${palmtopdir}/apps/Games/gemdropx.desktop
}
