DESCRIPTION = "NSD is an authoritative only, high performance, simple and opensource name server"
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://www.nlnetlabs.nl/downloads/nsd/nsd-${PV}.tar.gz"
LICENSE = "nsd"
inherit autotools

do_install() {
	oe_runmake 	configdir=${D}${sysconfdir}/nsd              \
			pidfile=${D}${localstatedir}/run/nsd.pid        \
			zonesfile=${D}${sysconfdir}/nsd/nsd.zones    \
			dbfile=${D}${sysconfdir}/nsd/nsd.db          \
			configfile=${D}${sysconfdir}/nsd/nsdc.conf   \
			zonesdir=${D}${sysconfdir}/nsd \
			prefix=${D}${prefix} \
			exec_prefix=${D}${exec_prefix} \
			sbindir=${D}${sbindir} \
			mandir=${D}${mandir} \
			install
}

