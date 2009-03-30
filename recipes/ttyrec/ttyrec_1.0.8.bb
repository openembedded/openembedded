#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: ttyrec_1.0.8.bb
# Date: 20070403 (YMD)

DESCRIPTION = "ttyrec is a tty recorder. Recorded data can be played back with the included ttyplay command."
HOMEPAGE = "http://0xcc.net/ttyrec/index.html.en"

######################################################################################

PR = "r0"

######################################################################################

SRC_URI = "http://0xcc.net/ttyrec/${PN}-${PV}.tar.gz \
	   file://Makefile.patch;patch=1"

######################################################################################

inherit autotools

######################################################################################

S = "${WORKDIR}/${PN}-${PV}"

######################################################################################

do_install() {
 	install -d ${D}/usr/bin
	install -d ${D}/usr/share/man/man1 
	
	for binary in ttyrec ttyplay ttytime
	do
        	install -m 0755 ${S}/${binary} ${D}/usr/bin/
		install -m 0644 ${S}/${binary}.1 ${D}/usr/share/man/man1
	done
}
