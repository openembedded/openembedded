DESCRIPTION = "XStream Server"

LICENSE = "GPL-2"

SRC_URI = "http://surfnet.dl.sourceforge.net/sourceforge/xbplayer/${P}.tar.gz \
	file://ccxstream-termcap.patch;patch=1 \
	file://ccxstream.init \
	file://ccxstream.conf"

inherit autotools

do_install() {
	# add startup and sample config
	mkdir -p ${D}${sysconfdir}/init.d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/ccxstream.init ${D}${sysconfdir}/init.d/ccxstream
	install -m 0644 ${WORKDIR}/ccxstream.conf ${D}${sysconfdir}/ccxstream.conf
	install -m 0755 ccxstream ${D}/usr/sbin/ccxstream || exit 1
}
