#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: visual-boot.bb
# Date: 25-Jun-06

DESCRIPTION = "A simple visual boot progress for OpenZaurus"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

PV = "0.0.1"
PR = "r1"

######################################################################################

SRC_URI = "file://visual-boot*"

######################################################################################

do_install() {
	install -d ${D}/usr/share/visual-boot
	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	install -d ${D}/etc/rc5.d

	install -m 0644 ${WORKDIR}/*.raw.gz ${D}/usr/share/visual-boot
	install -m 0755 ${WORKDIR}/visual-boot.init ${D}/etc/init.d/visual-boot

	# We can not use update-rc.d to enable visual-boot right after flashing
	ln -s /etc/init.d/visual-boot ${D}/etc/rcS.d/S34visual-boot-mountall
	ln -s /etc/init.d/visual-boot ${D}/etc/rcS.d/S39visual-boot-networking
	ln -s /etc/init.d/visual-boot ${D}/etc/rc5.d/S19visual-boot-apm
	ln -s /etc/init.d/visual-boot ${D}/etc/rc5.d/S22visual-boot-bt
	ln -s /etc/init.d/visual-boot ${D}/etc/rc5.d/S98visual-boot-x11
	ln -s /etc/init.d/visual-boot ${D}/etc/rc5.d/S99visual-boot-zaurusd

}

