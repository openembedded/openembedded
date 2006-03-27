DESCRIPTION = "wxBase is a library for programming \
non-GUI (console) applications using the base wxWidgets functionality."
HOMEPAGE = "http://www.wxwidgets.org/"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "jpeg libpng zlib"


SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxBase-${PV}.tar.bz2"

S = "${WORKDIR}/wxBase-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-largefile"

LEAD_SONAME = "libwx_base-2.6.so*" 

do_configure() {
       oe_runconf
}

do_stage() {
       install -d ${STAGING_INCDIR}/wx-2.6/wx
       cp -pr include/wx ${STAGING_INCDIR}/wx-2.6	
       cp -pr lib/libwx* ${STAGING_LIBDIR}
       cp -pr lib/wx     ${STAGING_LIBDIR}
       cp -pr build/bakefiles/wxpresets/presets  ${STAGING_DATADIR}/bakefile
       cp -pr wxwin.m4                           ${STAGING_DATADIR}/aclocal		
       ln -sf ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}base-ansi-release-2.6 ${STAGING_BINDIR}/wx-config
       sed -e s,'wxconfdir=".*"','wxconfigdir="${STAGING_LIBDIR}/wx/config"', \
           -e s,'bindir=".*"','bindir="${STAGING_BINDIR}"', \
           -e s,'libdir=".*"','libdir="${STAGING_LIBDIR}"', \
           -e s,'includedir=".*"','includedir="${STAGING_INCDIR}"', \
           -i ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}base-ansi-release-2.6	       
}

FILES_${PN} += " \
       ${libdir}/wx/config"

FILES_${PN}-dev += " \
       ${libdir}/wx/include \
       ${datadir}/bakefile"

do_install() {
       oe_runmake 'DESTDIR=${D}' install
       ln -sf  ${libdir}/wx/config/${TARGET_PREFIX}base-ansi-release-2.6 ${D}${bindir}/wx-config
       install -d ${D}${docdir}/${PN}-${PV}
       install -m 644 -p CHANGES.txt     ${D}${docdir}/${PN}-${PV}
       install -m 644 -p COPYING.LIB     ${D}${docdir}/${PN}-${PV}
       install -m 644 -p LICENCE.txt     ${D}${docdir}/${PN}-${PV}
       install -m 644 -p README.txt      ${D}${docdir}/${PN}-${PV}
}
