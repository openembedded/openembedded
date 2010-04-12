DESCRIPTION = "EFLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://equinox-project.org/page/documentation"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "zlib jpeg libpng libxext libxft"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/ede/efltk-${PV}.tar.gz \
           file://fix.void.cast.patch;patch=1"
S = "${WORKDIR}/efltk"

inherit autotools binconfig

EXTRA_OECONF = "\
  --enable-shared \
  --enable-xdbe \
  --enable-xft \
  --enable-gl \
  --disable-mysql \
  --disable-unixODBC \
  --x-includes=${STAGING_INCDIR}/freetype2 \
  --x-libraries=${STAGING_LIBDIR} \
"

# yes, this is nasty, but configure is so broken there is no other way
do_configure() {
	gnu-configize
	oe_runconf
	mv -f config.h save
	autotools_do_configure
	mv -f save config.h
}

# more nasties
do_configure_append() {
	sed -i s,/usr/include,${STAGING_INCDIR}, makeinclude
	sed -i s,/usr/include/freetype2,, makeinclude
	sed -i s,/usr/bin/strip,echo, makeinclude
	sed -i s,CONFIGDIR,'"${datadir}/ede/"', src/core/Fl_Config.cpp
}

do_stage() {
    autotools_stage_all
}

do_install () {
	install -d ${D}${libdir}
    oe_runmake install prefix="${D}${prefix}" \
               bindir="${D}${bindir}" \
               libdir="${D}${libdir}" \
               includedir="${D}${includedir}" \
               datadir="${STAGING_DATADIR}"
}

python populate_packages_prepend () {
        if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
                bb.data.setVar('PKG_${PN}', 'libefltk${PV}', d)
}

LEAD_SONAME = "libefltk.so"

FILES_${PN} += "${libdir}/fltk/*.theme"
FILES_${PN}-dbg += "${libdir}/fltk/.debug"

SRC_URI[md5sum] = "f0300fd2fec47d4b05823297032ddb9f"
SRC_URI[sha256sum] = "9636876e3c52f0dde5d6ac097568cad9fe8ea7088e28e27a3aad19b100d4e645"
