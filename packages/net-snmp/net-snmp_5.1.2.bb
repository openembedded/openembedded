DESCRIPTION = "Various tools relating to the Simple Network Management Protocol"
HOMEPAGE = "http://www.net-snmp.org/"
LICENSE = "BSD"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
DEPENDS = "openssl"
SRC_URI = "${SOURCEFORGE_MIRROR}/net-snmp/net-snmp-${PV}.tar.gz \
	file://init \
	file://snmpd.conf \
	file://snmptrapd.conf"
	
inherit autotools

EXTRA_OECONF = "--enable-shared --disable-manuals" 
EXTRA_OECONF_mipsel += "--with-endianness=little"

EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

do_configure() {
	oe_runconf
}

do_install_append() {
	install -d ${D}${sysconfdir}/snmp
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/snmpd
	install -m 644 ${WORKDIR}/snmpd.conf ${D}${sysconfdir}/snmp/
	install -m 644 ${WORKDIR}/snmptrapd.conf ${D}${sysconfdir}/snmp/
}

PACKAGES = "net-snmp-doc net-snmp-dev net-snmp-libs net-snmp-mibs net-snmp-server net-snmp-client"
FILES_net-snmp-libs = "${libdir}"
FILES_net-snmp-mibs = "${datadir}/snmp/mibs"
FILES_net-snmp-server = "${sbindir} ${sysconfdir}"
FILES_net-snmp-client = "${bindir} ${datadir}/snmp/"
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
