DESCRIPTION = "IRK provides a Qtopia/Opie Input Method plugin that allows you to use external infrared keyboards with the Zaurus. (version with Belkin support instead of Targus)"
SECTION = "opie/inputmethods"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe lirc"
RDEPENDS = "lirc"
RPROVIDES = "irk"
RCONFLICTS = "irk"
RREPLACES = "irk"
PR = "r1"

SRC_URI = "http://kopsisengineering.com/irk-current.tgz \
           file://install-default-conf.patch;patch=1"
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
