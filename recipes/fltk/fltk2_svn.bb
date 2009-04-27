DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zlib jpeg libpng libxext libxft"

SVNREL = "6671"
PV = "1.9.9+svnr${SVNREL}"

SRC_URI = "\
  http://ftp.easysw.com/pub/fltk/snapshots/fltk-2.0.x-r6671.tar.bz2 \
  file://fix-it-damnit.patch;patch=1 \
"
S = "${WORKDIR}/fltk-2.0.x-r6671"

inherit autotools_stage binconfig

EXTRA_OECONF = "\
  --enable-shared \
  --enable-xdbe \
  --enable-xft \
  --disable-gl \
  --x-includes=${STAGING_INCDIR} \
  --x-libraries=${STAGING_LIBDIR} \
"

do_configure() {
	gnu-configize
	oe_runconf
}

do_install () {
	sed -i "s|^STRIP.*=.*$|STRIP = ${STRIP}|" makeinclude
	sed -i "s|^bindir.*=.*$|bindir = ${D}${bindir}|" makeinclude
	oe_runmake install \
		prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		datadir="${STAGING_DATADIR}"
		
	# add missing links
	ln -sf ./libfltk2.so.2.0 ${D}${libdir}/libfltk2.so.2
	ln -sf ./libfltk2_images.so.2.0 ${D}${libdir}/libfltk2_images.so.2
}

PACKAGES =+ "${PN}-fluid ${PN}-images"
FILES_${PN}-fluid = "${bindir}/fluid2"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-images = "${libdir}/libfltk2_images*.so.*"
FILES_${PN}-dev += "${bindir}/fltk2-config"
