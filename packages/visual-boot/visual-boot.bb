#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: visual-boot.bb
# Date: 25-Jun-06

DESCRIPTION = "<description>"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

PV = "0.0.1"
PR = "r0"

######################################################################################

SRC_URI = "file://visual-boot*"

######################################################################################

do_install() {
	install -d ${D}/usr/share/visual-boot
	install -d ${D}/etc/init.d
	
	install -m 0644 ${WORKDIR}/*.raw.gz ${D}/usr/share/visual-boot
	install -m 0755 ${WORKDIR}/visual-boot.init ${D}/etc/init.d/visual-boot
	
	ln -s /etc/init.d/visual-boot ${D}/etc/init.d/visual-boot-mountall
	ln -s /etc/init.d/visual-boot ${D}/etc/init.d/visual-boot-networking
	ln -s /etc/init.d/visual-boot ${D}/etc/init.d/visual-boot-apm	
	ln -s /etc/init.d/visual-boot ${D}/etc/init.d/visual-boot-bt	
	ln -s /etc/init.d/visual-boot ${D}/etc/init.d/visual-boot-x11
	ln -s /etc/init.d/visual-boot ${D}/etc/init.d/visual-boot-zaurusd		
}

######################################################################################

pkg_postinst() {
	update-rc.d visual-boot-mountall start 34 S .
	update-rc.d visual-boot-networking start 39 S .
	update-rc.d visual-boot-apm start 19 5 .
	update-rc.d visual-boot-bt start 22 5 .
	update-rc.d visual-boot-x11 start 98 5 .
	update-rc.d visual-boot-zaurusd start 99 5 .
	
}

pkg_postrm() {
	update-rc.d -f visual-boot-mountasll remove
	update-rc.d -f visual-boot-networking remove
	update-rc.d -f visual-boot-apm remove
	update-rc.d -f visual-boot-bt remove
	update-rc.d -f visual-boot-x11 remove
	update-rc.d -f visual-boot-zaurusd remove
}
