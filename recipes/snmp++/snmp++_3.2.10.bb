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

SRC_URI[md5sum] = "6df271fd6a92d7641d7b060dedf7fec6"
SRC_URI[sha256sum] = "7eedc4ece1c82668c06222ef85457206139253e24a50e5b5d2401a41baee28c1"
