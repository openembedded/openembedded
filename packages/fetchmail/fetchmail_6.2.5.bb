PR = "r1"
SECTION = "console/network"
LICENSE = "GPL"
DESCRIPTION = "Fetchmail is a free, full-featured, robust, \
well-documented remote-mail retrieval and forwarding utility \
intended to be used over on-demand TCP/IP links \
(such as SLIP or PPP connections)."
#NOTE: by default configure sets --enable-nls and this pulls in
# libintl.h in the compile.  gettext disables NLS if USE_NLS=no
# and will remove libintl from DEPENDS, the following line should
# be uncommmented after testing on a system with USE_NLS=yes
#DEPENDS = "virtual/libintl"

SRC_URI = "${DEBIAN_MIRROR}/main/f/${PN}/${PN}_${PV}.orig.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools gettext

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}
