DESCRIPTION = "Various tools relating to the Simple Network Management Protocol"
HOMEPAGE = "http://www.net-snmp.org/"
LICENSE = "BSD"
DEPENDS = "openssl"
RDEPENDS_${PN}-server += "net-snmp-mibs"
RDEPENDS_${PN}-client += "net-snmp-mibs"
RDEPENDS_${PN}-dev = "net-snmp-client (= ${DEBPV}) net-snmp-server (= ${DEBPV})"
RRECOMMENDS_${PN}-dbg = "net-snmp-client (= ${DEBPV}) net-snmp-server (= ${DEBPV})"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz \
        file://configure-tail.patch;patch=1 \
        file://init \
        file://snmpd.conf \
        file://snmptrapd.conf"

inherit autotools update-rc.d

EXTRA_OECONF = "--enable-shared --disable-manuals --with-defaults \
                --disable-embedded-perl --with-perl-modules=no"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

do_configure() {
        # Additional flag based on target endiness (see siteinfo.bbclass)
        ENDIANESS="${@base_conditional('SITEINFO_ENDIANESS', 'le', '--with-endianness=little', '--with-endianness=big', d)}"
        oenote Determined endianess as: $ENDIANESS
        libtoolize --force
        oe_runconf $ENDIANESS
}
do_install_append() {
        install -d ${D}${sysconfdir}/snmp
        install -d ${D}${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/snmpd
        install -m 644 ${WORKDIR}/snmpd.conf ${D}${sysconfdir}/snmp/
        install -m 644 ${WORKDIR}/snmptrapd.conf ${D}${sysconfdir}/snmp/
}

PACKAGES = "net-snmp-dbg net-snmp-doc net-snmp-dev net-snmp-libs \
            net-snmp-mibs net-snmp-server net-snmp-client"

FILES_${PN}-libs = "${libdir}/*"
FILES_${PN}-mibs = "${datadir}/snmp/mibs"
FILES_${PN}-server = "${sbindir}/* ${sysconfdir}"
FILES_${PN}-client = "${bindir}/* ${datadir}/snmp/"
FILES_${PN}-dbg += "${libdir}/.debug/ ${sbindir}/.debug/ ${bindir}/.debug/"

CONFFILES_${PN}-server = "${sysconfdir}/snmp/snmpd.conf \
                          ${sysconfdir}/snmp/snmptrapd.conf"

INITSCRIPT_PACKAGES = "${PN}-server"
INITSCRIPT_NAME_${PN}-server = "snmpd"
INITSCRIPT_PARAMS_${PN}-server = "defaults"

LEAD_SONAME = "libnetsnmp.so"

PARALLEL_MAKE = ""
