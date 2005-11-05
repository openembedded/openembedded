DESCRIPTION = "IRK provides a Qtopia/Opie Input Method plugin that allows you to use external infrared keyboards with the Zaurus."
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
HOMEPAGE = "http://angela1.data-uncertain.co.uk/~zaurus/irk.php"
DEPENDS = "virtual/libqpe lirc"
RCONFLICTS = "irk-belkin"
RREPLACES = "irk-belkin"
PR = "r2"
REALV = "0.11.0"

SRC_URI = "http://angela1.data-uncertain.co.uk/~zaurus/irk-${REALV}.tgz"
S = "${WORKDIR}/irk"

inherit palmtop

EXTRA_QMAKEVARS_POST = "CONFIG-=qtopia INCLUDEPATH+=${STAGING_INCDIR}/lirc"

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${palmtopdir}/plugins/inputmethods/
	install -d ${D}/home/root/Settings/

	install chicony.conf ${D}${sysconfdir}/lircd.conf
	install IRK.conf ${D}${sysconfdir}
	oe_libinstall -so libirk ${D}${palmtopdir}/plugins/inputmethods
}

FILES_irk_append=" /etc /home/root"

