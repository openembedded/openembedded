require net-snmp.inc
PR = "${INC_PR}.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz \
	file://uclibc-fix.patch;patch=1 \
	file://init \
	file://snmpd.conf \
	file://snmptrapd.conf"

inherit autotools

PARALLEL_MAKE = ""
EXTRA_OECONF = "--enable-shared --disable-manuals --with-defaults"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

CONFFILES_${PN}_nylon = "${sysconfdir}/snmp/snmpd.conf ${sysconfdir}/snmp/snmptrapd.conf"
CCACHE = ""


SRC_URI[md5sum] = "8080555ab3f90011f25d5122042d9a8d"
SRC_URI[sha256sum] = "1fca69e934c3d526e308450cc5af2478d440e012922dd0bb10388fcf093ef32e"
