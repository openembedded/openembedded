DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zlib jpeg libpng libxext libxft xinput"

SRCREV = "6916"
PV = "1.9.9+svnr${SRCPV}"
PR = "r1"

SRC_URI = "\
  svn://svn.easysw.com/public/fltk/fltk;proto=http;module=trunk \
  file://fix-it-damnit.patch;patch=1 \
"
S = "${WORKDIR}/trunk"

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
	autoconf
	oe_runconf
}

TARGET_CC_ARCH += "-DXFT_MAJOR=2"

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
FILES_${PN}-images = "${libdir}/libfltk2_images*.so*"
FILES_${PN}-dev += "${bindir}/fltk2-config"
