SECTION = "x11/network"
DESCRIPTION="WiFi Radar is a Python/PyGTK2  utility for managing WiFi profiles."
HOMEPAGE="http://www.bitbuilder.com/wifi_radar/"
LICENSE = "GPL"

PR = "r2"

PACKAGE_ARCH = "all"

RDEPENDS = "python-core python-pygtk python-re python-io python-pygobject python-pycairo"

SRC_URI="http://wifi-radar.systemimager.org/pub/${PN}-${PV}.tar.bz2 \
        file://wifi-radar.patch;patch=1 \
        file://wifi-radar_destktop.patch;patch=1 "


S = "${WORKDIR}/${PN}-${PV}"

do_install() {
    oe_runmake sbindir=${D}${sbindir} initdir=${D}${sysconfdir}/init.d sysconfdir=${D}${sysconfdir} mandir=${D}${mandir} pixmapsdir=${D}${datadir}/pixmaps appsdir=${D}${datadir}/applications install

    #sbindir 	= /usr/sbin
    #initdir 	= /etc/init.d
    #sysconfdir 	= /etc/wifi-radar
    #mandir 		= /usr/share/man
    #pixmapsdir 	= /usr/share/pixmaps
    #appsdir 	= /usr/share/applications
}

pkg_postinst() {
#!/bin/sh
# post installation script
echo "*******************************************"
echo "Please edit /etc/wifi-radar.conf"
echo "to match your wifi card name (wlan0, eth0, ...)"
echo "*******************************************"
}

SRC_URI[md5sum] = "4ab4cc22d68dd0655ab28b75c7aa6248"
SRC_URI[sha256sum] = "bb94acb9da36e7148dc5090f07f43c816569b0b5d671135fd661b2376f19d719"
