#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see COPYING.MIT)
#
# Filename: mplayer-common.bb
# Date: 26-Mar-06

DESCRIPTION = "Preconfigured mplayer preferences"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

######################################################################################

PV = "0.0.1"
PR = "r2"

PACKAGE_ARCH = "all"

######################################################################################

SRC_URI = "file://mplayer.conf"

######################################################################################

FILES_${PN} = "${sysconfdir}/mplayer"

######################################################################################

do_install() {
	install -d "${D}${sysconfdir}/mplayer"

	install -m 0644 ${WORKDIR}/mplayer.conf "${D}${sysconfdir}/mplayer"
}
