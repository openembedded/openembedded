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
RRECOMMENDS_alsa-state = "alsa-states"
PV = "0.0.4"
PR = "r2"

SRC_URI = "file://asound.state \
           file://alsa-state "

SRC_URI_append_fic-gta01 = " \
  file://capturehandset.state \
  file://captureheadset.state \
  file://gsmbluetooth.state \
  file://gsmhandset.state \
  file://gsmheadset.state \
  file://stereoout.state"

inherit update-rc.d

INITSCRIPT_NAME = "alsa-state"
INITSCRIPT_PARAMS = "defaults 10"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/alsa-state ${D}${sysconfdir}/init.d
	
	install -m 0644 ${WORKDIR}/*.state ${D}${sysconfdir}
}

PACKAGES += "alsa-states"
FILES_${PN} = "${sysconfdir}/init.d"
FILES_alsa-states = "${sysconfdir}/*.state"
PACKAGE_ARCH_${PN} = "all"
PACKAGE_ARCH_alsa-states = "${MACHINE}"

pkg_postinst_${PN}() {
	if test -z "$D"
	then
		if test -x /usr/sbin/alsactl
		then
			/usr/sbin/alsactl -f ${sysconfdir}/asound.state restore
		fi	
	fi
}

