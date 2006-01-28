SECTION = "console/utils"
DESCRIPTION = "User-space keyboard daemon for external keyboards"
MAINTAINER = "Paul Eggleton <paule@handhelds.org>"
HOMEPAGE = "http://handhelds.org/moin/moin.cgi/kbdd"
LICENSE = "GPLv2"
DEPENDS = "virtual/kernel"
RRECOMMENDS_${PN} = "${@linux_module_packages('keybdev uinput', d)}"
SRC_URI = "${HANDHELDS_CVS};module=apps/kbdd;date=${SRCDATE} \
           file://kbdd.init \
           file://kbdd.conf \
           file://kbdd-modules"

#Remove the dash below when 0.8 changes in PV
PV="0.10+cvs${SRCDATE}"
PR="r5"

inherit update-rc.d linux_modules

S = "${WORKDIR}/kbdd"
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
