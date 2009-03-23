DESCRIPTION = "Pluginable bootup menu."
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "http://www.cosmicpenguin.net/pub/bootmenu/bootmenu-${PV}.tar.gz \
	   file://compile.patch;patch=1"

EXTRA_OEMAKE = ""

do_compile () {
	oe_runmake -C src 'CC=${CC}' 'CFLAGS=${CFLAGS}' 'LDFLAGS=${LDFLAGS}'
}

do_install () {
	oe_runmake -C src 'PLUGINDIR=${datadir}/bootmenu' 'PREFIX=${bindir}' 'DESTDIR=${D}' install
}
