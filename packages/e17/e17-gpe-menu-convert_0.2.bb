DESCRIPTION = "Shell script to convert GPE .desktop files into e17 eap files and menus"
DEPENDS = "edje-utils e-wm"
RDEPENDS += "edje-utils e-wm"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r3"

SRC_URI = "file://e17-gpe-menu-convert.sh"

do_install() {
	install -d ${D}/usr/bin/
	install -m 755 ${WORKDIR}/e17-gpe-menu-convert.sh ${D}/usr/bin/e17-gpe-menu-convert.sh
}

pkg_postinst() {
	/usr/bin/e17-gpe-menu-convert.sh
}
