DESCRIPTION = "A Qtopia/Opie Input Method plugin for the Flexis FX100 Keyboard."
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.Vanille.de/mirror/flexis-zaurus-${PV}.tar.bz2"
S = "${WORKDIR}/flexis-zaurus"

inherit palmtop

EXTRA_QMAKEVARS_POST += "CONFIG-=qtopia"

do_install() {
	oe_libinstall libqflexis ${D}${palmtopdir}/plugins/inputmethods/
}

SRC_URI[md5sum] = "e7737236f1eccadd4cf8cfcc0c82e005"
SRC_URI[sha256sum] = "ca7653a03f562057098c9fb956de34021a14017c2a44eedd3ab0963dc877e7e5"
