DESCRIPTION = "ODE is an Open Source Physics Engine."
SECTION = "libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/opende/ode-${PV}.tgz \
           file://config.h"

do_configure() {
	touch configurator.exe
	chmod a+rx configurator.exe
	install -m 0644 ${WORKDIR}/config.h include/ode/
}

do_compile() {
	oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LD="${LD}" LDFLAGS="${LDFLAGS}" RANLIB="${RANLIB}" AR="${AR} qf " ode-lib
}

do_stage() {
	install -d ${STAGING_INCDIR}/ode/
	install -m 0644 include/ode/*.h ${STAGING_INCDIR}/ode/
	oe_libinstall -C lib -a libode ${STAGING_LIBDIR}
}

do_install() {
	:
}
