DESCRIPTION = "Program that allows you to set the CCCR registers on PXA Zauruses."
SECTION = "opie/settings"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Dylan Taft <soundmanok@yahoo.com>"
AUTHOR = "piro <piro400@occn.zaq.ne.jp>"
HOMEPAGE = "http://www.piro.hopto.org/~piro/pukiwiki/pukiwiki.php?%5B%5B%A5%AB%A1%BC%A5%CD%A5%EB%A5%D1%A5%C3%A5%C1%A4%F2%A4%DE%A4%C8%A4%E1%A4%EB%5D%5D"
APPTYPE="binary"
PR = "r1"

SRC_URI = "http://www.piro.hopto.org/~piro/zaurus/qclockchange-${PV}.tar.gz"

inherit palmtop

do_install() {
	install -d ${D}${palmtopdir}/bin/ \
               ${D}${palmtopdir}/pics \
               ${D}${palmtopdir}/apps/Settings

	install -m 0755 qclockchange ${D}${palmtopdir}/bin/qclockchange
	install -m 0644 ipkg/opt/QtPalmtop/pics/qclockchange.png ${D}${palmtopdir}/pics/qclockchange.png
	install -m 0644 ipkg/opt/QtPalmtop/apps/Settings/qclockchange.desktop ${D}${palmtopdir}/apps/Settings/qclockchange.desktop	
}
