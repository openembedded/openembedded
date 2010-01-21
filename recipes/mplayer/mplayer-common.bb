#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see COPYING.MIT)
#
# Filename: mplayer-common.bb
# Date: 26-Mar-06

DESCRIPTION = "Preconfigured mplayer preferences"

PV = "0.0.1"
PR = "r3"

SRC_URI = "file://mplayer.conf"

do_install() {
	install -d "${D}${sysconfdir}/mplayer"

	install -m 0644 ${WORKDIR}/mplayer.conf "${D}${sysconfdir}/mplayer"
}

FILES_${PN} = "${sysconfdir}/mplayer"
PACKAGE_ARCH = "all"

