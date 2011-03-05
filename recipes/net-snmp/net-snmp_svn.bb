require net-snmp.inc
DEPENDS += "libtool libtool-native libtool-cross"
SRCREV = "20069"
PR = "${INC_PR}.0"

S = "${WORKDIR}/net-snmp"

SRC_URI = "svn://net-snmp.svn.sourceforge.net/svnroot/net-snmp/trunk;module=net-snmp;proto=https \
        file://init \
        file://snmpd.conf \
        file://snmptrapd.conf"

EXTRA_OECONF += "--disable-embedded-perl --with-perl-modules=no GREP=/bin/grep SED=/bin/sed"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

CCACHE = ""
