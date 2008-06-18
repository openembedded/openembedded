DESCRIPTION = "Fetchmail is a free, full-featured, robust, \
well-documented remote-mail retrieval and forwarding utility \
intended to be used over on-demand TCP/IP links \
(such as SLIP or PPP connections)."
SECTION = "console/network"

LICENSE = "GPL"

PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/f/${PN}/${PN}_${PV}.orig.tar.gz \
	   file://CVE-2007-4565.patch;patch=1 \
	   "

inherit autotools gettext

FILES_${PN} = "${bindir}/fetchmail"
PACKAGES += "${PN}conf"
FILES_${PN}conf = "${libdir}/python2.5/site-packages/fetchmailconf.py* ${bindir}/fetchmailconf"
rdepends_${PN}conf = "${PN}"
