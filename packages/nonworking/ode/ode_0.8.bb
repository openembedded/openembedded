DESCRIPTION = "ODE is an Open Source Physics Engine."
SECTION = "libs"
HOMEPAGE = "http://www.ode.org"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/opende/ode-src-${PV}.zip \
           file://config.h"

inherit autotools

#do_configure() {
#	touch configurator.exe
#	chmod a+rx configurator.exe
#	install -m 0644 ${WORKDIR}/config.h include/ode/
#}

#do_compile() {
#	oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LD="${LD}" LDFLAGS="${LDFLAGS}" RANLIB="${RANLIB}" AR="${AR} qf " ode-lib
#}

#do_stage() {
#	install -d ${STAGING_INCDIR}/ode/
#	install -m 0644 include/ode/*.h ${STAGING_INCDIR}/ode/
#	oe_libinstall -C lib -a libode ${STAGING_LIBDIR}
#}

#do_install() {
#	:
#}
