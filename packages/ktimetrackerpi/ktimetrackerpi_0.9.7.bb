DESCRIPTION = "Time tracking program"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
HOMEPAGE = "http://www.pi-sync.net"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/ktimetracker_pi097.tar.gz"

S = "${WORKDIR}/ktimetracker_pi"

inherit palmtop

EXTRA_QMAKEVARS_POST += "QMAKE_UIC=${STAGING_BINDIR}/uic QMAKE_MOC=${STAGING_BINDIR}/moc QMAKE_RPATH=-Wl,-rpath-link, OBJECTS_DIR=obj/ MOC_DIR=moc/ TARGET=${S}/dest/ktpi HEADERS-=kphone/qptrlisth HEADERS+=kphone/qptrlist.h LIBS+=-lstdc++"
QMAKE_PROFILES= "ktimetracker_piE.pro"

do_configure_prepend() {
	mkdir ${S}/dest/
}

do_install() {
    install -d ${D}${palmtopdir}/bin \
               ${D}${palmtopdir}/apps/1Pim \
               ${D}${palmtopdir}/pics/

    install -m 0644 ${S}/ktimetracker.png ${D}${palmtopdir}/pics/
    install -m 0644 ${S}/ktimetracker.desktop ${D}${palmtopdir}/apps/1Pim/

    install -m 0755 ${S}/dest/ktpi ${D}${palmtopdir}/bin/ktpi
}
