require net-snmp.inc
PR = "${INC_PR}.0"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz \
        file://configure-tail.patch;patch=1 \
        file://init \
        file://snmpd.conf \
        file://snmptrapd.conf"

EXTRA_OECONF = "--enable-shared --disable-manuals --with-defaults \
                --disable-embedded-perl --with-perl-modules=no"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

do_configure_prepend() {
        libtoolize --force
}

PARALLEL_MAKE = ""
CCACHE = ""

