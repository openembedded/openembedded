DESCRIPTION = "Various tools relating to the Simple Network Management Protocol"
HOMEPAGE = "http://www.net-snmp.org/"
LICENSE = "BSD"
DEPENDS = "openssl"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz \
	file://uclibc-fix.patch;patch=1 \
	file://init \
	file://snmpd.conf \
	file://snmptrapd.conf"

inherit autotools

PARALLEL_MAKE = ""
EXTRA_OECONF = "--enable-shared --disable-manuals --with-defaults"
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

do_configure() {
	# Additional flag based on target endiness (see siteinfo.bbclass)
	ENDIANESS="${@base_conditional('SITEINFO_ENDIANESS', 'le', '--with-endianness=little', '--with-endianness=big', d)}"
	oenote Determined endianess as: $ENDIANESS
	oe_runconf $ENDIANESS
}

do_install_append() {
	install -d ${D}${sysconfdir}/snmp
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/snmpd
	install -m 644 ${WORKDIR}/snmpd.conf ${D}${sysconfdir}/snmp/
	install -m 644 ${WORKDIR}/snmptrapd.conf ${D}${sysconfdir}/snmp/
}

PACKAGES = "net-snmp-dbg net-snmp-doc net-snmp-dev net-snmp-libs net-snmp-mibs net-snmp-server net-snmp-client"
FILES_net-snmp-libs = "${libdir}/*"
FILES_net-snmp-mibs = "${datadir}/snmp/mibs"
FILES_net-snmp-server = "${sbindir}/* ${sysconfdir}"
FILES_net-snmp-client = "${bindir}/* ${datadir}/snmp/"
FILES_net-snmp-dbg += "${libdir}/.debug/ ${sbindir}/.debug/ ${bindir}/.debug/"
RDEPENDS_net-snmp-server += "net-snmp-mibs"
RDEPENDS_net-snmp-client += "net-snmp-mibs"

pkg_postinst_net-snmp-server() {
if test "x$D" != "x"; then
	D="-r $D"
else
	D="-s"
fi
update-rc.d $D snmpd defaults
}

pkg_postrm_net-snmp-server() {
if test "x$D" != "x"; then
	D="-r $D"
else
	/etc/init.d/snmpd stop
fi
update-rc.d $D snmpd remove
}

CONFFILES_${PN}_nylon = "${sysconfdir}/snmp/snmpd.conf ${sysconfdir}/snmp/snmptrapd.conf"
