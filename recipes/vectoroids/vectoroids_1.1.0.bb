DESCRIPTION = "Clone of the classic arcade game Asteroids - SDL edition."
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

APPIMAGE = "data/images/icon.png"
APPNAME = "vectoroids-${PV}"

SRC_URI = "ftp://ftp.billsgames.com/unix/x/vectoroids/src/vectoroids-${PV}.tar.gz"

inherit qmake sdl

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/SDL CONFIG-=qt \
                         LIBS+=-lSDL \
                         LIBS+=-lSDL_mixer \
   			 LIBS+=-lSDL_image \
                         LIBS+=-lpthread \
                         DEFINES+=DATA_PREFIX=\\"\"${datadir}/vectoroids/\\"\""

do_configure_prepend() {
        qmake -project vectoroids.pro
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${APPNAME} ${D}${bindir}
        install -d ${D}${datadir}/vectoroids/
	cp -pPR data/* ${D}${datadir}/vectoroids/
}

SRC_URI[md5sum] = "c63ce56b09aa7da9a6e95d804e9ee314"
SRC_URI[sha256sum] = "8d14dd281767e994108abd77c8e67d5a17718d0ad1e34d37e026911d14697b2e"
