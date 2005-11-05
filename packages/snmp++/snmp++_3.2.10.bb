DESCRIPTION = "A C++ SNMP library that supports SNMPv1, SNMPv2c and SNMPv3"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libdes libtomcrypt"
LICENSE = "snmp++"
SRC_URI = "http://www.agentpp.com/snmp++v${PV}.tar.gz"
S = "${WORKDIR}/snmp++/src"

CFLAGS_append = " -I../include"

do_compile() {
	oe_runmake -f Makefile.linux LIBDESDIR=${STAGING_LIBDIR} LIBTOMCRYPTDIR=${STAGING_LIBDIR}
}

do_stage() {
	oe_libinstall -a -C ../lib libsnmp++ ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/snmp++
	install -m 0644 ../include/*.h ${STAGING_INCDIR}/snmp++
}
