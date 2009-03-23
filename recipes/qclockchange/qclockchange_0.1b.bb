DESCRIPTION = "Program that allows you to set the CCCR registers on PXA Zauruses."
SECTION = "opie/settings"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "piro <piro400@occn.zaq.ne.jp>"
HOMEPAGE = "http://piro.sytes.net/~piro/zaurus/"
APPTYPE="binary"
PR = "r0"

SRC_URI = "http://piro.sytes.net/~piro/zaurus/etc/qclockchange-${PV}.tar.gz \
	   file://qclockchange.png \
	   file://qclockchange.desktop "

inherit palmtop

do_install() {
	install -d ${D}${palmtopdir}/bin/ \
               ${D}${palmtopdir}/pics \
               ${D}${palmtopdir}/apps/Settings

	install -m 0755 bin/qclockchange ${D}${palmtopdir}/bin/qclockchange
	install -m 0644 ${WORKDIR}/qclockchange.png ${D}${palmtopdir}/pics/qclockchange.png
	install -m 0644 ${WORKDIR}/qclockchange.desktop ${D}${palmtopdir}/apps/Settings/qclockchange.desktop
}
