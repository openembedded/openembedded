DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
SECTION = "console/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
MAINTAINER_nslu2 = "Matthias Goebl <matthias.goebl@goebl.net>"
LICENSE = "GPL"
DEPENDS = "virtual/kernel libx11 libxau libsm ice"
DEPENDS_nslu2 = "virtual/kernel lirc-modules"
RDEPENDS = "lirc-modules"
RDEPENDS_lirc-x = "lirc"
RDEPENDS_lirc-exec = "lirc"
RDEPENDS_lirc-nslu2example = "lirc lirc-exec"
PR = "r1"

SRC_URI = "http://lirc.sourceforge.net/software/snapshots/lirc-0.8.0pre4.tar.bz2 \
           file://lircd.init file://lircmd.init"
SRC_URI_append_nslu2 = " file://lircexec.init \
           file://lircd.conf_nslu2 file://lircrc_nslu2"

S = "${WORKDIR}/lirc-0.8.0pre4"

inherit autotools module-base update-rc.d

INITSCRIPT_NAME = "lircd"
INITSCRIPT_PARAMS = "defaults 20"

include lirc-config.inc

EXTRA_OEMAKE = 'SUBDIRS="daemons tools"'

do_stage() {
        oe_libinstall -so -C tools liblirc_client ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/lirc/
	install -m 0644 tools/lirc_client.h ${STAGING_INCDIR}/lirc/
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/lircd.init ${D}${sysconfdir}/init.d/lircd
	install ${WORKDIR}/lircexec.init ${D}${sysconfdir}/init.d/lircexec
        install -d ${D}${datadir}/lirc/
        cp -pPR ${S}/remotes ${D}${datadir}/lirc/
}

do_install_append_nslu2() {
	install -d ${D}${sysconfdir}
	# These are example configs for RC5 remotes and a NSLU2.
	# As RC5 is very common, it should work for many people out of the box.
        # The timings are for a de-underclocked NSLU2.
	install ${WORKDIR}/lircd.conf_nslu2 ${D}${sysconfdir}/lircd.conf
	install ${WORKDIR}/lircrc_nslu2 ${D}${sysconfdir}/lircrc
}

pkg_postinst_lirc-exec() {
	if test "x$D" != "x"; then D="-r $D"; else D="-s"; fi
	update-rc.d $D lircexec defaults 20
}
pkg_prerm_lirc-exec() {
	if test "x$D" != "x"; then D="-r $D"; else /etc/init.d/lircexec stop; fi
}
pkg_postrm_lirc-exec() {
	update-rc.d $D lircexec remove
}

PACKAGES =+ "lirc-x lirc-exec lirc-remotes"
PACKAGES_prepend_nslu2 = "lirc-nslu2example "

FILES_${PN} = "${bindir} ${sbindir} ${libdir} ${sysconfdir}/init.d"
FILES_lirc-x = "${bindir}/irxevent ${bindir}/xmode2"
FILES_lirc-exec = "${bindir}/irexec ${sysconfdir}/init.d/lircexec"
FILES_lirc-remotes = "${datadir}/lirc/remotes"
FILES_lirc-nslu2example = "${sysconfdir}/lircd.conf ${sysconfdir}/lircrc"
CONFFILES_lirc-nslu2example = "${FILES_lirc-nslu2example}"
