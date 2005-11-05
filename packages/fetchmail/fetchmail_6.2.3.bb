SECTION = "console/network"
LICENSE = "GPL"
DESCRIPTION = "Fetchmail is a free, full-featured, robust, \
well-documented remote-mail retrieval and forwarding utility \
intended to be used over on-demand TCP/IP links \
(such as SLIP or PPP connections)."

SRC_URI = "http://catb.org/~esr/fetchmail/fetchmail-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}
