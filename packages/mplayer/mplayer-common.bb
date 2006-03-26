#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: mplayer-common.bb
# Date: 26-Mar-06

DESCRIPTION = "Preconfigured mplayer preferences"
MAINTAINER = "Matthias 'CoreDump' Hentges <oe@hentges.net>"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"

######################################################################################

PV = "0.0.1"
PR = "r0"

######################################################################################

SRC_URI = "file://mplayer.conf"

######################################################################################

FILES_${PN} = "/usr/etc/mplayer"

######################################################################################

do_install() {
	install -d "${D}/usr/etc/mplayer"
	
	install -m 0644 ${WORKDIR}/mplayer.conf "${D}/usr/etc/mplayer"
}
