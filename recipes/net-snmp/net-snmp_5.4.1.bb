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


SRC_URI[md5sum] = "6c974df7a5a5b1579f72115e6b045bda"
SRC_URI[sha256sum] = "0ea976722c993c87dede8eb6348e6feb059e3851bbef2de824bf18ac97cdb565"
