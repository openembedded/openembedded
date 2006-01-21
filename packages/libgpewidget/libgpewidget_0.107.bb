LICENSE = "LGPL"
DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc intltool-native"

PACKAGES =+ "libgpewidget-bin"

PARALLEL_MAKE = ""

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"

inherit pkgconfig autotools

FILES_libgpewidget-bin = "${bindir}"

EXTRA_OECONF = "--enable-cairo"

LDFLAGS += " -L${STAGING_LIBDIR}" 

do_configure() {
oe_runconf
# ugly, ugly hack ahead. You may lart me (koen), but blame the gpe people for wanting .107 in the branch
mkdir -p ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libgtk-x11-2.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libgdk-x11-2.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libatk-1.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libgdk_pixbuf-2.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libpangoxft-1.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libpangox-1.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libpango-1.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libgobject-2.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libgmodule-2.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libglib-2.0.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libfreetype.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libfontconfig.so ${STAGING_LIBDIR}/.libs
cp ${STAGING_LIBDIR}/libX11.so ${STAGING_LIBDIR}/.libs
}

do_stage () {
	autotools_stage_all
}

