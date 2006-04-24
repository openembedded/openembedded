DESCRIPTION = "A Qtopia/Opie Input Method plugin for the Flexis FX100 Keyboard."
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.Vanille.de/mirror/flexis-zaurus-${PV}.tar.bz2"
S = "${WORKDIR}/flexis-zaurus"

inherit palmtop

EXTRA_QMAKEVARS_POST += "CONFIG-=qtopia"

do_install() {
	oe_libinstall libqflexis ${D}${palmtopdir}/plugins/inputmethods/
}
