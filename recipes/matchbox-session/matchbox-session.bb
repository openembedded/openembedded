DESCRIPTION = "Matchbox session support"
RDEPENDS_${PN} = "matchbox-common"
# they do the same in other way
RCONFLICTS_${PN} = "gpe-session-scripts"
PR = "r1"

do_install() {
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        ln -sf ${bindir}/matchbox-session ${D}${sysconfdir}/X11/Xsession.d/90matchbox-session
}

PACKAGE_ARCH = "all"
PACKAGES = "${PN}"

FILES_${PN} = "${sysconfdir}"
