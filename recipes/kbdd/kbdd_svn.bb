DESCRIPTION = "User-space keyboard daemon for external keyboards"
HOMEPAGE = "http://project.linuxtogo.org/projects/kbdd"
SECTION = "console/utils"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel"
RRECOMMENDS_${PN} = "kernel-module-keybdev kernel-module-uinput"
PV = "0.12+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/kbdd;module=trunk;proto=svn \
           file://kbdd.init \
           file://kbdd.conf \
           file://kbdd-modules"
S = "${WORKDIR}/trunk"

inherit update-rc.d

INITSCRIPT_NAME = "kbdd"
INITSCRIPT_PARAMS = "defaults"

do_compile() {
	oe_runmake CFLAGS="${CFLAGS} -DVERSION=\\\"${PV}\\\""
}

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${docdir}/kbdd/
	install -m 0755 kbdd ${D}${sbindir}/
	install -m 0644 README ${D}${docdir}/kbdd/
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/kbdd.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/kbdd.init ${D}${sysconfdir}/init.d/kbdd
	install -d ${D}${sysconfdir}/modutils
	install -m 0644 ${WORKDIR}/kbdd-modules ${D}${sysconfdir}/modutils/
}

pkg_postinst () {
	update-modules
}

pkg_postrm () {
	update-modules
}
