#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: alsa-state.bb
# Date: 20070308 (YMD)

DESCRIPTION = "Default ALSA configuration"
LICENSE = "GPL"

PV = "0.0.4"
PR = "r1"

SRC_URI = "file://asound.state \
	   file://alsa-state"

inherit update-rc.d

INITSCRIPT_NAME = "alsa-state"
INITSCRIPT_PARAMS = "defaults 10"

do_install() {
	install -d ${D}${sysconfdir}/init.d
	
	install -m 0644 ${WORKDIR}/asound.state ${D}${sysconfdir}
	install -m 0755 ${WORKDIR}/alsa-state ${D}${sysconfdir}/init.d
}

FILES_${PN} = "${sysconfdir}/*"

pkg_postinst_${PN}() {
	if test -z "$D"
	then
		if test -x /usr/sbin/alsactl
		then
			/usr/sbin/alsactl -f ${sysconfdir}/asound.state restore
		fi	
	fi
}

