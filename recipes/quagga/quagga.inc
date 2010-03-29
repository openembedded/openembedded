DESCRIPTION = "Quagga is a routing software suite, providing \
implementations of OSPFv2, OSPFv3, RIP v1 and v2, RIPv3 and BGPv4 for \
Unix platforms, particularly FreeBSD, Linux, Solaris and NetBSD. \
Quagga is a fork of GNU Zebra which was developed by Kunihiro \
Ishiguro. The Quagga tree aims to build a more involved community \
around Quagga than the current centralised model of GNU Zebra."
HOMEPAGE = "http://www.quagga.net/"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "readline ncurses perl-native"
# Each of the per-protocol packages depends on the main package
RDEPENDS_${PN}-ospfd    = "${PN}"
RDEPENDS_${PN}-ospf6d   = "${PN}"
RDEPENDS_${PN}-bgpd     = "${PN}"
RDEPENDS_${PN}-ripd     = "${PN}"
RDEPENDS_${PN}-ripngd   = "${PN}"
RDEPENDS_${PN}-isisd    = "${PN}"
RDEPENDS_${PN}-ospfclient = "${PN}"
RDEPENDS_${PN}-doc      = ""
RDEPENDS_${PN}-watchquagga = "${PN}"
# the "ip" command from busybox is not sufficient (flush by protocol flushes all routes)
RDEPENDS_${PN}          += "iproute2"

INC_PR = "r3"

QUAGGASUBDIR = ""

# ${QUAGGASUBDIR} is deal with old versions. Set to "/attic" for old
# versions and leave it empty for recent versions.
SRC_URI = "http://www.quagga.net/download${QUAGGASUBDIR}/quagga-${PV}.tar.gz;name=quagga-${PV} \
           file://fix-for-lib-inpath.patch;patch=1 \
           file://quagga.init \
           file://quagga.default \
           file://watchquagga.init \
           file://watchquagga.default \
           file://volatiles.03_quagga"

inherit autotools update-rc.d

# Turn on options and changes paths.
# This matches the layout and configuration of the debian quagga package
EXTRA_OECONF = "--prefix=${prefix} \
                --libexecdir=${libexecdir}/quagga \
                --sbindir=${libdir}/quagga \
                --sysconfdir=${sysconfdir}/quagga \
                --localstatedir=${localstatedir}/run/quagga \
                --enable-exampledir=${docdir}/quagga/examples/ \
                --enable-vtysh \
                --enable-isisd \
                --enable-watchquagga \
                --enable-ospf-te \
                --enable-opaque-lsa \
                --enable-ipv6 \
                --enable-ospfclient=yes \
                --enable-multipath=64 \
                --enable-user=quagga \
                --enable-group=quagga \
                --enable-vty-group=quaggavty \
                --enable-configfile-mask=0640 \
                --enable-logfile-mask=0640 \
                --enable-rtadv \
                --enable-tcp-md5"

do_install () {
        # Install init script and default settings
        install -m 0755 -d ${D}${sysconfdir}/default ${D}${sysconfdir}/init.d \
                           ${D}${sysconfdir}/quagga ${D}${sysconfdir}/default/volatiles
        install -m 0644 ${WORKDIR}/quagga.default ${D}${sysconfdir}/default/quagga
        install -m 0644 ${WORKDIR}/watchquagga.default ${D}${sysconfdir}/default/watchquagga
        install -m 0755 ${WORKDIR}/quagga.init ${D}${sysconfdir}/init.d/quagga
        install -m 0755 ${WORKDIR}/watchquagga.init ${D}${sysconfdir}/init.d/watchquagga
        install -m 0644 ${WORKDIR}/volatiles.03_quagga  ${D}${sysconfdir}/default/volatiles/volatiles.03_quagga
        # Install quagga
        oe_runmake install DESTDIR=${D} prefix=${prefix} \
                libexecdir=${libexecdir}/quagga \
                sbindir=${libdir}/quagga \
                sysconfdir=${sysconfdir}/quagga \
                localstatedir=${localstatedir}/run/quagga
}

# Split into a main package and seperate per-protocol packages
PACKAGES = "${PN}-dbg ${PN} \
            ${PN}-ospfd ${PN}-ospf6d ${PN}-bgpd ${PN}-ripd ${PN}-ripngd ${PN}-isisd \
            ${PN}-ospfclient ${PN}-watchquagga ${PN}-dev ${PN}-doc"

FILES_${PN}-ospfd       = "${libdir}/quagga/ospfd /usr/lib/libospf.so.*"
FILES_${PN}-ospf6d      = "${libdir}/quagga/ospf6d"
FILES_${PN}-bgpd        = "${libdir}/quagga/bgpd"
FILES_${PN}-ripd        = "${libdir}/quagga/ripd"
FILES_${PN}-ripngd      = "${libdir}/quagga/ripngd"
FILES_${PN}-isisd       = "${libdir}/quagga/isisd"
FILES_${PN}-ospfclient  = "${libdir}/quagga/ospfclient /usr/lib/libospfapiclient.so.*"
FILES_${PN}-dev         = "/usr/include /usr/lib/lib*.so /usr/lib/*.la /usr/lib/*.a"
FILES_${PN}-doc         = "/usr/share/doc /usr/share/man /usr/share/info"
FILES_${PN}-watchquagga = "${libdir}/quagga/watchquagga ${sysconfdir}/default/watchquagga \
                           ${sysconfdir}/init.d/watchquagga"
FILES_${PN}             = "${bindir}/vtysh ${libdir}/quagga/zebra /usr/lib/libzebra*.so.* \
                           ${sysconfdir}/default/volatiles/volatiles.03_quagga \
                           ${sysconfdir}/quagga \
                           ${sysconfdir}/default/quagga ${sysconfdir}/init.d/quagga"

# Indicate that the default files are configuration files
CONFFILES_${PN} = "${sysconfdir}/default/quagga"
CONFFILES_${PN}-watchquagga = "${sysconfdir}/default/watchquagga"

# Stop the names being rewritten due to the internal shared libraries
DEBIAN_NOAUTONAME_${PN}-ospfd = "1"
DEBIAN_NOAUTONAME_${PN}-ospfclient = "1"

# Main init script starts all deamons
# Seperate init script for watchquagga
INITSCRIPT_PACKAGES                     = "${PN} ${PN}-watchquagga"
INITSCRIPT_NAME_${PN}                   = "quagga"
INITSCRIPT_PARAMS_${PN}                 = "defaults 15 85"
INITSCRIPT_NAME_${PN}-watchquagga       = "watchquagga"
INITSCRIPT_PARAMS_${PN}-watchquagga     = "defaults 90 10"

# Add quagga's user and groups
pkg_postinst_${PN} () {
	set -e
        grep -q quagga: /etc/group || addgroup quagga
        grep -q quaggavty: /etc/group || addgroup quaggavty
        grep -q quagga: /etc/passwd || \
            adduser --disabled-password --home=/var/run/quagga/ --system \
                    --ingroup quagga --no-create-home -g "Quagga routing suite" quagga
	for f in bgpd isisd ospfd ripngd zebra ripd ospf6d; do touch /etc/quagga/$f.conf; done
	chown quagga:quaggavty /etc/quagga
	chown quagga:quagga /etc/quagga/*.conf
	chmod 750 /etc/quagga
	chown 640 /etc/quagga/*.conf
        /etc/init.d/populate-volatile.sh update
}

# Stop apps before uninstall
pkg_prerm_${PN} () {
        ${sysconfdir}/init.d/quagga stop
}

pkg_prerm_${PN}-ospfd () {
        ${sysconfdir}/init.d/quagga stop ospfd
}

pkg_prerm_${PN}-ospf6d () {
        ${sysconfdir}/init.d/quagga stop ospf6d
}

pkg_prerm_${PN}-bgpd () {
        ${sysconfdir}/init.d/quagga stop bgpd
}

pkg_prerm_${PN}-ripd () {
        ${sysconfdir}/init.d/quagga stop ripd
}

pkg_prerm_${PN}-ripngd () {
        ${sysconfdir}/init.d/quagga stop ripngd
}

pkg_prerm_${PN}-isisd () {
        ${sysconfdir}/init.d/quagga stop isisd
}
