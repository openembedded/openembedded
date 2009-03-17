DESCRIPTION = "Music Player Daemon (mpd) library"
HOMEPAGE = "http://www.musicpd.org"
SECTION = "libs/multimedia"
LICENSE = "GPLv2"
SRCDATE = "20070120"
PV = "0.0.0+svn${SRCDATE}"

SRC_URI = "svn://svn.musicpd.org/libmpd;module=trunk;proto=https"
S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

do_stage_append() {
    oe_libinstall -C src libmpd ${STAGING_LIBDIR}
    install -d ${STAGING_INCDIR}/libmpd
    cd src
    for i in *.h; do
        install -m 0644 $i ${STAGING_INCDIR}/libmpd/$i
    done
    cd ..
}
