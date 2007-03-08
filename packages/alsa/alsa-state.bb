#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: alsa-state.bb
# Date: 20070308 (YMD)

DESCRIPTION = "Default ALSA configuration"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "<homepage>"
LICENSE = "GPL"

######################################################################################

PV = "0.0.1"
PR = "r0"

######################################################################################

SRC_URI = "file://asound.state"

FILES_${PN} = "/etc/*"

######################################################################################

do_install() {
	install -d ${D}${sysconfdir}
	
	install -m 0644 ${WORKDIR}/asound.state ${D}${sysconfdir}
}


pkg_postinst_${PN}() {
	if test -x /usr/sbin/alsactl
	then
		/usr/sbin/alsactl -f ${sysconfdir}/asound.state restore
	fi
}
