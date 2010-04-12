DESCRIPTION = "ODE is an Open Source Physics Engine."
SECTION = "libs"
HOMEPAGE = "http://www.ode.org"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/opende/ode-src-${PV}.zip \
           file://install.patch;patch=1"

inherit autotools binconfig

EXTRA_OECONF = "--disable-demos --enable-soname"

do_configure_append() {
	echo "#define dInfinity DBL_MAX" >>include/ode/config.h
}

do_stage() {
	oe_runmake install \
		bindir=${STAGING_BINDIR_CROSS} \
		libdir=${STAGING_LIBDIR} \
		includedir=${STAGING_INCDIR} \
		datadir=${STAGING_DATADIR}
}

do_install() {
	oe_runmake install \
		bindir=${D}${bindir} \
		libdir=${D}${libdir} \
		includedir=${D}${incdir} \
		datadir=${D}${datadir}
}

FILES_${PN} = "${libdir}/lib*.so*"

SRC_URI[md5sum] = "4c03759b76a0649a6d5108c8e172e1e4"
SRC_URI[sha256sum] = "460d0851b743b1f144ef2a8259004d6774504c95d08e9357a96a296111496feb"
