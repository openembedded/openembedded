#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: speechd_0.56.bb
# Date: 20071231 (YMD)

DESCRIPTION = "speechd implements /dev/speech"
HOMEPAGE = "http://www.speechio.org/"
SECTION = "base"
LICENSE = "GPL"

PR = "r0"

######################################################################################


SRC_URI = "http://www.speechio.org/dl/speechd-${PV}.tar.gz"

S = "${WORKDIR}/${PN}"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/bin
	install -d ${D}/etc
	install -d ${D}/usr/share/man/man1
	
	install -m 0755 ${S}/bin/catspeech ${D}/bin/catspeech
	install -m 0755 ${S}/bin/speechd ${D}/bin/speechd
	
	install -m 0644 ${S}/speechdrc ${D}/etc
	
	install -m 0644  ${S}/man/man1/catspeech.1 ${D}/usr/share/man/man1
	install -m 0644  ${S}/man/man1/speechd.1 ${D}/usr/share/man/man1	
}
