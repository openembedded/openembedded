# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: MIT (see COPYING.MIT)

DESCRIPTION = "Preconfigured mplayer preferences"

PV = "0.0.1"
PR = "r4"

SRC_URI = "file://mplayer.conf"

# Yes, really /usr/etc!!!
do_install() {
	install -d "${D}/usr${sysconfdir}/mplayer"

	install -m 0644 ${WORKDIR}/mplayer.conf "${D}/usr${sysconfdir}/mplayer"
}

FILES_${PN} = "/usr${sysconfdir}/mplayer"
PACKAGE_ARCH = "all"

