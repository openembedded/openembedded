DESCRIPTION = "FusionSound for DirectFB"
DEPENDS = "directfb libmad libvorbis"
SECTION = "libs"
LICENSE = "LGPL"

SRC_URI = "http://www.directfb.org/downloads/Core/FusionSound-${PV}.tar.gz"
S = "${WORKDIR}/FusionSound-${PV}"

inherit autotools pkgconfig

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}/directfb:g'
}

do_stage() {
        autotools_stage_all
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}

FILES_${PN} += "\
  ${libdir}/directfb-1.0-0/interfaces/*/*.so \
  ${libdir}/directfb-1.0-0/snddrivers/*.so \
"

FILES_${PN}-dbg += "\
  ${libdir}/directfb-1.0-0/*/*/.debug/*.so \
  ${libdir}/directfb-1.0-0/*/.debug/*.so \
"

FILES_${PN}-dev += "\
  ${libdir}/directfb-1.0-0/interfaces/*/*.la \
  ${libdir}/directfb-1.0-0/snddrivers/*.la \
"

