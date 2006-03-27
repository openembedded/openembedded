DESCRIPTION = "wxBase is a library for programming \
non-GUI (console) applications using the base wxWidgets functionality."
HOMEPAGE = "http://www.wxwidgets.org/"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "jpeg libpng zlib"


SRC_URI = "http://biolpc22.york.ac.uk/pub/CVS_HEAD/wx-cvs-Gtk.tar.bz2"
#SRC_URI = "${SOURCEFORGE_MIRROR}/wxwindows/wxBase-${PV}.tar.bz2"

S = "${WORKDIR}/wxGTK"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gui --enable-largefile"

LEAD_SONAME = "libwx_base-2.7*" 

do_configure() {
       oe_runconf
}

do_stage() {
       install -d ${STAGING_INCDIR}/wx-2.7/wx
       cp -pr include/wx ${STAGING_INCDIR}/wx-2.7	
       cp -pr lib/libwx* ${STAGING_LIBDIR}
       cp -pr lib/wx     ${STAGING_LIBDIR}
       cp -pr build/bakefiles/wxpresets/presets  ${STAGING_DATADIR}/bakefile
       cp -pr wxwin.m4                           ${STAGING_DATADIR}/aclocal
       ln -sf ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}base-ansi-release-2.7 ${STAGING_BINDIR}/wx-config
       sed -e s,'wxconfdir=".*"','wxconfigdir="${STAGING_LIBDIR}/wx/config"', \
           -e s,'bindir=".*"','bindir="${STAGING_BINDIR}"', \
           -e s,'libdir=".*"','libdir="${STAGING_LIBDIR}"', \
           -e s,'includedir=".*"','includedir="${STAGING_INCDIR}"', \
           -i ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}base-ansi-release-2.7
}

FILES_${PN} += " \
       ${libdir}/wx/config"

FILES_${PN}-dev += " \
       ${libdir}/wx/include \
       ${datadir}/bakefile"

do_install() {
       oe_runmake 'DESTDIR=${D}' install
       ln -sf ${libdir}/wx/config/${TARGET_PREFIX}base-ansi-release-2.7 ${D}${bindir}/wx-config
       install -d ${D}${docdir}/${PN}-${PV}
       install -m 644 -p docs/*.txt      ${D}${docdir}/${PN}-${PV}
       install -m 644 -p docs/*.htm      ${D}${docdir}/${PN}-${PV}	
}
