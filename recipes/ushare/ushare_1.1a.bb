DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
DEPENDS = "libupnp virtual/libiconv virtual/libintl"
SRC_URI = "http://ushare.geexbox.org/releases/ushare-${PV}.tar.bz2"
S = "${WORKDIR}/ushare-${PV}"

inherit autotools gettext

# the configure script is hand-crafted, it rejects some of the usual
# configure arguments
do_configure () {
	${S}/configure \
		    --prefix=${prefix} \
		    --bindir=${bindir} \
		    --localedir=${datadir}/locale \
		    --sysconfdir=${sysconfdir} \
		    --cross-compile
}

