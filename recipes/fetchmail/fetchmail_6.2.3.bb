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

SRC_URI[md5sum] = "e131bdb6c3977fd47a3e122c43dcf19d"
SRC_URI[sha256sum] = "d0867cf1dbc58031a6b65375cf899f565569a818400f762dcee3b50de9da9f56"
