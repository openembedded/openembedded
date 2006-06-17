DESCRIPTION = "Classic arcade puzzle game - SDL edition."
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://www.newbreedsoftware.com/gemdropx/"
PR = "r4"

APPIMAGE = "${WORKDIR}/gemdropx.png"

SRC_URI = "ftp://ftp.billsgames.com/unix/x/gemdropx/src/gemdropx-${PV}.tar.gz \
           file://gemdropx.png"

inherit qmake sdl

EXTRA_QMAKEVARS_POST += "CONFIG-=qt \
                         INCLUDEPATH+=${STAGING_INCDIR}/SDL \
                         LIBS+=-lSDL \
                         LIBS+=-lSDL_mixer \
			 LIBS+=-lSDL_image \
                         LIBS+=-lpthread \
                         DEFINES+=DATA_PREFIX=\\"\"${datadir}/gemdropx/\\"\""

do_configure_prepend() {
        qmake -project -nopwd gemdropx.c -o gemdropx.pro
}

do_install() {
        install -d ${D}${bindir}
	install -m 0755 gemdropx ${D}${bindir}/gemdropx
	install -d ${D}${datadir}/gemdropx/
	cp -pPR data/* ${D}${datadir}/gemdropx/

}
