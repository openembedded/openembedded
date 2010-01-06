DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
DEPENDS = "gamin libdlna libupnp virtual/libiconv virtual/libintl"

PV = "1.1a"
PR = "r1"
PR_append = "+hg${NOTQUITESRCREV}"
NOTQUITESRCREV = "2e40e513a4a0"

SRC_URI = "hg://hg.geexbox.org;proto=http;module=ushare;rev=${NOTQUITESRCREV} \
"

S= "${WORKDIR}/ushare"

inherit autotools gettext

# the configure script is hand-crafted, it rejects some of the usual
# configure arguments
do_configure () {
	${S}/configure \
		    --prefix=${prefix} \
		    --bindir=${bindir} \
		    --localedir=${datadir}/locale \
		    --sysconfdir=${sysconfdir} \
		    --disable-strip \
            --enable-fam \
            --cross-compile
}

