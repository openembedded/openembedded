#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see http://www.opensource.org/licenses/mit-license.php for a copy of the license)
#
# Filename: oz-bootsplash.bb
# Date: 24-Jun-06

DESCRIPTION = "A simple bootsplash for OpenZaurus"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL"

######################################################################################

PACKAGE_ARCH = "${MACHINE}"
RCONFLICTS = "gpe-bootsplash"
RREPLACES = "gpe-bootsplash"

######################################################################################

PV = "0.0.1" 
PR = "r5"

######################################################################################

SRC_URI = "file://oz-bootsplash.init \
	   file://chvt.init \
	   file://openzaurus-bootsplash*"

######################################################################################

do_install() {
	install -d ${D}/usr/share/oz-bootsplash
	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	install -d ${D}/etc/rc2.d	
	install -d ${D}/etc/rc5.d	
	
	install -m 0644 ${WORKDIR}/*.raw.gz ${D}/usr/share/oz-bootsplash
	install -m 0755 ${WORKDIR}/oz-bootsplash.init ${D}/etc/init.d/oz-bootsplash
	install -m 0755 ${WORKDIR}/chvt.init ${D}/etc/init.d/chvt
	
	ln -sf ../init.d/oz-bootsplash ${D}/etc/rcS.d/S07oz-bootsplash	
	ln -sf ../init.d/chvt ${D}/etc/rc2.d/S99chvt
	ln -sf ../init.d/chvt ${D}/etc/rc5.d/S99chvt

}	   

######################################################################################

inherit update-alternatives

ALTERNATIVE_PATH = "${datadir}/oz-bootsplash/openzaurus-bootsplash.raw.gz"
ALTERNATIVE_LINK = "${datadir}/oz-bootsplash/oz-bootsplash.raw.gz"
ALTERNATIVE_NAME = "openzaurus-bootsplash"
ALTERNATIVE_PRIORITY = "10"
