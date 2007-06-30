#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: usb-gadget-mode.bb
# Date: 20070606 (YMD)

DESCRIPTION = "Manage the default USB gadget mode"
SECTION = "console/network"
LICENSE = "GPL"

######################################################################################

PV = "0.0.2"
PR = "r0"

######################################################################################

PACKAGE_ARCH = "${MACHINE_ARCH}"

######################################################################################

SRC_URI = "file://usb-gadget.conf \
	   file://usb-gadget \
	   file://usb-gadget.init"
	   
######################################################################################

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}/default

	install -m 0644 ${WORKDIR}/usb-gadget.conf ${D}${sysconfdir}/default/usb-gadget
	install -m 0755 ${WORKDIR}/usb-gadget.init ${D}${sysconfdir}/init.d/usb-gadget
	install -m 0755 ${WORKDIR}/usb-gadget ${D}${bindir}
}

pkg_postinst() {	
	
	test -n "$D" && opt="-r $D"
	update-rc.d $opt usb-gadget defaults 50
}

pkg_postrm() {
	update-rc.d -f usb-gadget remove
}
