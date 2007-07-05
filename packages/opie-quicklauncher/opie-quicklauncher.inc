DESCRIPTION = "The Opie Quick Launcher Loader"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"

S = "${WORKDIR}/quicklauncher"

inherit opie

do_install() {
	install -d ${D}${bindir}
	install -m 755 quicklauncher ${D}${bindir}/
}
