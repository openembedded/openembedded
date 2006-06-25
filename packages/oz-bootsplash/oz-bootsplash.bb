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

RCONFLICTS = "gpe-bootsplash"
RREPLACES = "gpe-bootsplash"

######################################################################################

PV = "0.0.1" 
PR = "r1"

######################################################################################

SRC_URI = "file://oz-bootsplash.init \
	   file://openzaurus*"
	   
######################################################################################
	   
do_install() {
	install -d ${D}/usr/share/oz-bootsplash
	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	
	install -m 0644 ${WORKDIR}/*.raw.gz ${D}/usr/share/oz-bootsplash
	install -m 0755 ${WORKDIR}/oz-bootsplash.init ${D}/etc/init.d/oz-bootsplash
	
	ln -s /etc/init.d/oz-bootsplash ${D}/etc/rcS.d/S07oz-bootsplash	

}	   

######################################################################################

pkg_postinst() {
	update-alternatives --install /usr/share/oz-bootsplash/oz-bootsplash-qvga-portrait.raw.gz bootsplash-qvga-portrait /usr/share/oz-bootsplash/openzaurus-qvga-portrait.raw.gz 10
	update-alternatives --install /usr/share/oz-bootsplash/oz-bootsplash-vga-portrait.raw.gz bootsplash-vga-portrait /usr/share/oz-bootsplash/openzaurus-vga-portrait.raw.gz 10
	update-alternatives --install /usr/share/oz-bootsplash/oz-bootsplash-vga-landscape.raw.gz bootsplash-vga-landscape /usr/share/oz-bootsplash/openzaurus-vga-landscape.raw.gz 10
}

pkg_postrm() { 
	update-alternatives --remove bootsplash-qvga-portrait /usr/share/oz-bootsplash/openzaurus-qvga-portrait.raw.gz 10
	update-alternatives --remove bootsplash-vga-portrait /usr/share/oz-bootsplash/openzaurus-vga-portrait.raw.gz 10
	update-alternatives --remove bootsplash-vga-landscape /usr/share/oz-bootsplash/openzaurus-vga-landscape.raw.gz 10	
}
