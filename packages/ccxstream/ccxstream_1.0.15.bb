DESCRIPTION = "XStream Server"
DEPENDS = "readline"
LICENSE = "GPL-2"
PR = "r2"

SRC_URI = "http://surfnet.dl.sourceforge.net/sourceforge/xbplayer/${P}.tar.gz \
	file://ccxstream-termcap.patch;patch=1 \
	file://ccxstream.init \
	file://ccxstream.conf"

inherit autotools

do_install() {
	# add startup and sample config
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/ccxstream.init ${D}${sysconfdir}/init.d/ccxstream
	install -m 0644 ${WORKDIR}/ccxstream.conf ${D}${sysconfdir}/ccxstream.conf
	install -m 0755 ccxstream ${D}${sbindir}/ccxstream || exit 1
}
