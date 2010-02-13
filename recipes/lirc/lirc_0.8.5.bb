DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
DESCRIPTION_append_lirc = " This package contains the lirc daemon, libraries and tools."
DESCRIPTION_append_lirc-x = " This package contains lirc tools for X11."
DESCRIPTION_append_lirc-exec = " This package contains a daemon that runs programs on IR signals."
DESCRIPTION_append_lirc-remotes = " This package contains some config files for remotes."
DESCRIPTION_append_lirc-nslu2example = " This package contains a working config for RC5 remotes and a modified NSLU2."
SECTION = "console/network"
PRIORITY = "optional"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPL"
DEPENDS = "virtual/kernel virtual/libx11 libxau libsm libice"
DEPENDS_nslu2 = "virtual/kernel lirc-modules"
RDEPENDS = "lirc-modules"
RDEPENDS_lirc-x = "lirc"
RDEPENDS_lirc-exec = "lirc"
RDEPENDS_lirc-nslu2example = "lirc lirc-exec"
RRECOMMENDS_lirc = "lirc-exec"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz \
           file://lircd.init file://lircmd.init file://lircexec.init"
SRC_URI_append_nslu2 = " file://lircd.conf_nslu2 file://lircrc_nslu2"

S = "${WORKDIR}/lirc-${PV}"

inherit autotools module-base update-rc.d

INITSCRIPT_PACKAGES = "lirc lirc-exec"
INITSCRIPT_NAME = "lircd"
INITSCRIPT_PARAMS = "defaults 20"
INITSCRIPT_NAME_lirc-exec = "lircexec"
INITSCRIPT_PARAMS_lirc-exec = "defaults 21"

require lirc-config.inc

EXTRA_OEMAKE = 'SUBDIRS="daemons tools"'

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install ${WORKDIR}/lircd.init ${D}${sysconfdir}/init.d/lircd
	install ${WORKDIR}/lircexec.init ${D}${sysconfdir}/init.d/lircexec
        install -d ${D}${datadir}/lirc/
        cp -pPR ${S}/remotes ${D}${datadir}/lirc/
	rm -rf ${D}/dev
}

do_install_append_nslu2() {
	install -d ${D}${sysconfdir}
	install ${WORKDIR}/lircd.conf_nslu2 ${D}${sysconfdir}/lircd.conf
	install ${WORKDIR}/lircrc_nslu2 ${D}${sysconfdir}/lircrc
}

PACKAGES =+ "lirc-x lirc-exec lirc-remotes"
PACKAGES_prepend_nslu2 = "lirc-nslu2example "

FILES_${PN}-dbg += "${bindir}/.debug ${sbindir}/.debug"
FILES_${PN} = "${bindir} ${sbindir} ${libdir} ${sysconfdir}/init.d"
FILES_lirc-x = "${bindir}/irxevent ${bindir}/xmode2"
FILES_lirc-exec = "${bindir}/irexec ${sysconfdir}/init.d/lircexec"
FILES_lirc-remotes = "${datadir}/lirc/remotes"
FILES_lirc-nslu2example = "${sysconfdir}/lircd.conf ${sysconfdir}/lircrc"
CONFFILES_lirc-nslu2example = "${FILES_lirc-nslu2example}"
