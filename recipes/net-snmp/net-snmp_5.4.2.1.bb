require net-snmp.inc
PR = "${INC_PR}.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz \
        file://configure-tail.patch;patch=1 \
        file://CVE-2008-6123.patch;patch=1 \
        file://init \
        file://snmpd.conf \
        file://snmptrapd.conf"

EXTRA_OECONF = "--enable-shared --disable-manuals --with-defaults \
                --disable-embedded-perl --with-perl-modules=no"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

do_configure_prepend() {
        gnu-configize -f
        # We better change sources and re-autoconf here, but
        # required autoconf is too new for us.
        sed -e '/echo.*\".*\\\\.*\"/s/echo/echo -e/g' \
            -e 's/tail -1/tail -n 1/g'                \
            -i configure

        #The tarball for v5.4.2.1 is missing config.sub
        cp ${STAGING_DATADIR_NATIVE}/gnu-config/config.sub ${S}
}

PARALLEL_MAKE = ""
CCACHE = ""
