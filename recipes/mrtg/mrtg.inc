DESCRIPTION = "The Multi Router Traffic Grapher"
SECTION = "net"
DEPENDS = "gd perl-native"
RDEPENDS = " \
	 gd \
	 net-snmp-server \
	 perl \
	 perl-module-carp-heavy \
	 perl-module-findbin \
	 perl-module-getopt-long \
	 perl-module-io \
	 perl-module-io-socket \
	 perl-module-locale \
	 perl-module-math-bigfloat \
	 perl-module-math-bigint \
	 perl-module-overload \
	 perl-module-pod-text \
	 perl-module-universal \
	 "
LICENSE = "GPL"

PR = "r0"

SRC_URI = "http://oss.oetiker.ch/mrtg/pub/mrtg-${PV}.tar.gz;name=mrtg-${PV}"

inherit autotools

do_configure_prepend() {
	export long_long_format_specifier="%lld"
}

do_install_append() {
	for file in ${bindir}/mrtg ${bindir}/indexmaker ${bindir}/cfgmaker ${bindir}/mrtg-traffic-sum; do
		sed -ri "s,${STAGING_BINDIR_NATIVE},${bindir}," ${D}/$file
	done
	install -d ${D}/etc/mrtg
	install -d ${D}/var/db/mrtg
}

FILES_${PN} += "${libdir}/mrtg2 ${datadir}/mrtg2 ${sysconfdir}/mrtg ${localstatedir}/db/mrtg"