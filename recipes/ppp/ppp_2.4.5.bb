SECTION = "console/network"
DESCRIPTION = "Point-to-Point Protocol (PPP) daemon"
HOMEPAGE = "http://samba.org/ppp/"
DEPENDS = "libpcap"
LICENSE = "BSD GPLv2"
PR = "r1"
# Not well tested
DEFAULT_PREFERENCE = "-1"

PARALLEL_MAKE = ""

SRC_URI = "http://ppp.samba.org/ftp/ppp/ppp-${PV}.tar.gz \
        file://ppp-2.4.4-mppe-mppc.1.1.patch \
        file://makefile.patch \
        file://cifdefroute.patch \
        file://pppd-resolv-varrun.patch \
        file://enable-ipv6.patch \
        file://makefile-remove-hard-usr-reference.patch \
        file://ldflags.patch \
	file://pon \
	file://poff \
	file://init \
	file://ip-up \
	file://ip-down \
	file://08setupdns \
	file://92removedns"

inherit autotools

TARGET_CC_ARCH += " ${LDFLAGS}" 
EXTRA_OEMAKE = "STRIPPROG=${STRIP} MANDIR=${D}${datadir}/man/man8 INCDIR=${D}${includedir} LIBDIR=${D}${libdir}/pppd/${PV} BINDIR=${D}${sbindir}"
EXTRA_OECONF = "--disable-strip"

do_install_append () {
	make INCDIR=${D}/${includedir} install-devel
	make install-etcppp ETCDIR=${D}/${sysconfdir}/ppp
	mkdir -p ${D}${bindir}/ ${D}${sysconfdir}/init.d
	mkdir -p ${D}${sysconfdir}/ppp/ip-up.d/
	mkdir -p ${D}${sysconfdir}/ppp/ip-down.d/
	mkdir -p ${D}${sysconfdir}/ppp/peers/
 	install -m 0755 ${WORKDIR}/pon ${D}${bindir}/pon
	install -m 0755 ${WORKDIR}/poff ${D}${bindir}/poff
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ppp
	install -m 0755 ${WORKDIR}/ip-up ${D}${sysconfdir}/ppp/
	install -m 0755 ${WORKDIR}/ip-down ${D}${sysconfdir}/ppp/
	install -m 0755 ${WORKDIR}/08setupdns ${D}${sysconfdir}/ppp/ip-up.d/
	install -m 0755 ${WORKDIR}/92removedns ${D}${sysconfdir}/ppp/ip-down.d/
	rm -rf ${D}/${mandir}/man8/man8
}

CONFFILES_${PN} = "${sysconfdir}/ppp/pap-secrets ${sysconfdir}/ppp/chap-secrets ${sysconfdir}/ppp/options"
PACKAGES =+ "ppp-oa ppp-oe ppp-radius ppp-winbind ppp-minconn ppp-password ppp-tools"
FILES_${PN}        = "${sysconfdir} ${bindir} ${sbindir}/chat ${sbindir}/pppd"
FILES_${PN}_nylon  = "${sysconfdir} ${bindir} ${sbindir}/chat ${sbindir}/pppd ${sbindir}/tdbread"
FILES_${PN}-dbg += "${libdir}/pppd/${PV}/.debug"
FILES_${PN}-oa       = "${libdir}/pppd/${PV}/pppoatm.so"
FILES_${PN}-oe       = "${sbindir}/pppoe-discovery ${libdir}/pppd/${PV}/rp-pppoe.so"
FILES_${PN}-radius   = "${libdir}/pppd/${PV}/radius.so ${libdir}/pppd/${PV}/radattr.so ${libdir}/pppd/${PV}/radrealms.so"
FILES_${PN}-winbind  = "${libdir}/pppd/${PV}/winbind.so"
FILES_${PN}-minconn  = "${libdir}/pppd/${PV}/minconn.so"
FILES_${PN}-password = "${libdir}/pppd/${PV}/pass*.so"
FILES_${PN}-tools    = "${sbindir}/pppstats ${sbindir}/pppdump"
DESCRIPTION_ppp-oa       = "Plugin for PPP needed for PPP-over-ATM"
DESCRIPTION_ppp-oe       = "Plugin for PPP needed for PPP-over-Ethernet"
DESCRIPTION_ppp-radius   = "Plugin for PPP that are related to RADIUS"
DESCRIPTION_ppp-winbind  = "Plugin for PPP to authenticate against Samba or Windows"
DESCRIPTION_ppp-minconn  = "Plugin for PPP to specify a minimum connect time before the idle timeout applies"
DESCRIPTION_ppp-password = "Plugin for PPP to get passwords via a pipe"
DESCRIPTION_ppp-tools    = "The pppdump and pppstats utitilities"
RDEPENDS_ppp_minconn    += "libpcap0.8"

pkg_postinst_${PN}() {
if test "x$D" != "x"; then
	exit 1
else
	chmod u+s ${sbindir}/pppd
fi
}

SRC_URI[md5sum] = "4621bc56167b6953ec4071043fe0ec57"
SRC_URI[sha256sum] = "43317afec9299f9920b96f840414c977f0385410202d48e56d2fdb8230003505"

