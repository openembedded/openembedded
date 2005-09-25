DESCRIPTION = "NSS module for Multicast DNS name resolution"
HOMEPAGE = "http://0pointer.de/lennart/projects/nss-mdns/"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"

RRECOMMENDS_${PN} = "avahi-daemon zeroconf"
PR = "r1"

EXTRA_OECONF = "--libdir=/lib"
S = "${WORKDIR}/nss-mdns-${PV}"

SRC_URI = "http://0pointer.de/lennart/projects/nss-mdns/nss-mdns-${PV}.tar.gz \
	   file://alignment-fix.patch;patch=1"

inherit autotools

pkg_postinst () {
	cat /etc/nsswitch.conf | grep "hosts:\s*files dns$" > /dev/null && {
		cat /etc/nsswitch.conf | sed 's/hosts:\s*files dns/& mdns/' > /tmp/nsswitch.conf
		mv /tmp/nsswitch.conf /etc/nsswitch.conf
	}
}

pkg_prerm () {
	cat /etc/nsswitch.conf | grep "hosts:\s*files dns mdns$" > /dev/null && {
		cat /etc/nsswitch.conf | sed 's/\(hosts:\s*files dns\) mdns/\1/' > /tmp/nsswitch.conf
		mv /tmp/nsswitch.conf /etc/nsswitch.conf
	}
}
