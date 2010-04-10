DESCRIPTION = "NSS module for Multicast DNS name resolution"
HOMEPAGE = "http://0pointer.de/lennart/projects/nss-mdns/"
LICENSE = "GPL"
SECTION = "libs"
PRIORITY = "optional"

RRECOMMENDS_${PN} = "zeroconf"
PR = "r0"

EXTRA_OECONF = "--libdir=/lib"
S = "${WORKDIR}/nss-mdns-${PV}"

SRC_URI = "http://0pointer.de/lennart/projects/nss-mdns/nss-mdns-${PV}.tar.gz"

inherit autotools

pkg_postinst_${PN} () {
        # can't do this offline
        if [ "x$D" != "x" ]; then
                exit 1
        fi
	cat /etc/nsswitch.conf | grep "hosts:\s*files dns$" > /dev/null && {
		cat /etc/nsswitch.conf | sed 's/\(hosts:\s*files \)dns/\1mdns4_minimal [NOTFOUND=return] dns mdns4/' > /tmp/nsswitch.conf
		mv /tmp/nsswitch.conf /etc/nsswitch.conf
	}
}

pkg_prerm_${PN} () {
	cat /etc/nsswitch.conf | grep "hosts:\s*files dns mdns$" > /dev/null && {
		cat /etc/nsswitch.conf | sed 's/\(hosts:\s*files \)mdns4_minimal [NOTFOUND=return] dns mdns4/\1dns/' > /tmp/nsswitch.conf
		mv /tmp/nsswitch.conf /etc/nsswitch.conf
	}
}

SRC_URI[md5sum] = "03938f17646efbb50aa70ba5f99f51d7"
SRC_URI[sha256sum] = "1e683c2e7c3921814706d62fbbd3e9cbf493a75fa00255e0e715508d8134fa6d"
