DESCRIPTION = "IRK provides a Qtopia/Opie Input Method plugin that allows you to use external infrared keyboards with the Zaurus."
SECTION = "opie/inputmethods"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://angela1.data-uncertain.co.uk/~zaurus/irk.php"
DEPENDS = "virtual/libqpe lirc"

S = "${WORKDIR}/irk"

inherit palmtop

EXTRA_QMAKEVARS_POST = "CONFIG-=qtopia INCLUDEPATH+=${STAGING_INCDIR}/lirc"

do_install() {
	install -d ${D}${sysconfdir}/
	install -d ${D}${palmtopdir}/etc/skel/
	install -d ${D}${palmtopdir}/plugins/inputmethods/

	install -m 0644 chicony.conf ${D}${sysconfdir}/lircd.conf
	install -m 0644 IRK.conf ${D}${palmtopdir}/etc/skel/
	oe_libinstall -so libirk ${D}${palmtopdir}/plugins/inputmethods
}

FILES_${PN} += "${sysconfdir}"
