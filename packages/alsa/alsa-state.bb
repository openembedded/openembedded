# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php
#               for a copy of the license)
#
# Filename: alsa-state.bb

DESCRIPTION = "Default ALSA configuration"
LICENSE = "GPL"
RRECOMMENDS_alsa-state = "alsa-states"
PV = "0.1.0"
PR = "r7"

SRC_URI = " \
  file://asoundrc \
  file://asound.state \
  file://alsa-state "

SRC_URI_append_fic-gta01 = " \
  file://capturehandset.state \
  file://captureheadset.state \
  file://gsmbluetooth.state \
  file://gsmhandset.state \
  file://gsmheadset.state \
  file://gsmspeakerout.state \
  file://stereoout.state \
  file://voip-handset.state \
  file://voip-headset.state"

inherit update-rc.d

INITSCRIPT_NAME = "alsa-state"
INITSCRIPT_PARAMS = "defaults 10"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/alsa-state ${D}${sysconfdir}/init.d

	install -m 0644 ${WORKDIR}/asoundrc ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/*.state ${D}${sysconfdir}
}

PACKAGES += "alsa-states"
FILES_${PN} = "${sysconfdir}/init.d ${sysconfdir}/asoundrc"
FILES_alsa-states = "${sysconfdir}/*.state"
PACKAGE_ARCH_${PN} = "all"
PACKAGE_ARCH_alsa-states = "${MACHINE_ARCH}"

pkg_postinst_${PN}() {
	if test -z "$D"
	then
		if test -x /usr/sbin/alsactl
		then
			/usr/sbin/alsactl -f ${sysconfdir}/asound.state restore
		fi
	fi
}

