DESCRIPTION = "Classic Arcade Shooter for Qt/Embedded based palmtop environments w/ SDL."
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe libsdl-qpe libsdl-mixer libsdl-image"
PR = "r2"

SRC_URI = "ftp://ftp.sonic.net/pub/users/nbs/unix/agenda/aliens/src/aliens_V${PV}.tar.gz"
S = "${WORKDIR}/aliens_V${PV}"

inherit palmtop

EXTRA_QMAKEVARS_POST="INCLUDEPATH+=${STAGING_INCDIR}/SDL LIBS+=-lSDL LIBS+=-lSDL_mixer LIBS+=-lSDL_image LIBS+=-lpthread CONFIG+=qte"

do_compile_prepend() {
	cd images && make && cd ..
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/apps/Games \
        	   ${D}${palmtopdir}/share/aliens
        install -D -m 0755 aliens ${D}${palmtopdir}/bin/aliens
	install -D -m 0644 aliens.png ${D}${palmtopdir}/pics/aliens.png
        install -D -m 0644 aliens.desktop ${D}${palmtopdir}/apps/Games/aliens.desktop
}
