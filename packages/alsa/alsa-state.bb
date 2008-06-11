# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php
#               for a copy of the license)
#
# Filename: alsa-state.bb

DESCRIPTION = "Default ALSA configuration"
LICENSE = "GPL"
PV = "0.1.0"
PR = "r18"

SRC_URI = "\
  file://asound.conf \
  file://asound.state \
  file://alsa-state \
"

inherit update-rc.d

INITSCRIPT_NAME = "alsa-state"
INITSCRIPT_PARAMS = "defaults 10"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/alsa-state ${D}${sysconfdir}/init.d

	install -m 0644 ${WORKDIR}/asound.conf ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/*.state ${D}${sysconfdir}
}

PACKAGES += "alsa-states"

RRECOMMENDS_alsa-state = "alsa-states"
RRECOMMENDS_${PN}_om-gta01 = "openmoko-alsa-scenarios"
RRECOMMENDS_${PN}_om-gta02 = "openmoko-alsa-scenarios"

FILES_${PN} = "${sysconfdir}/init.d ${sysconfdir}/asound.conf"
CONFFILES_${PN} = "${sysconfdir}/asound.conf"

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
