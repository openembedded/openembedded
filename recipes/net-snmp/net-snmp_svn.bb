require net-snmp.inc
DEPENDS += "libtool libtool-native libtool-cross"
SRCREV = "17367"
PR = "${INC_PR}.0"

S = "${WORKDIR}/net-snmp"

SRC_URI = "svn://net-snmp.svn.sourceforge.net/svnroot/net-snmp/trunk;module=net-snmp;proto=https \
        file://init \
        file://snmpd.conf \
        file://snmptrapd.conf"

EXTRA_OECONF = "--enable-shared --disable-manuals --with-defaults \
                --disable-embedded-perl --with-perl-modules=no GREP=/bin/grep SED=/bin/sed"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

PARALLEL_MAKE = ""
CCACHE = ""

do_configure_prepend() {
    gnu-configize -f
    # We better change sources and re-autoconf here, but
    # required autoconf is too new for us.
    sed -e '/echo.*\".*\\\\.*\"/s/echo/echo -e/g' \
        -e 's/tail -1/tail -n 1/g'                \
        -i configure
}

