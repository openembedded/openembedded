DESCRIPTION = "Pluginable bootup menu."
LICENSE="GPL"
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "http://www.cosmicpenguin.net/pub/bootmenu/bootmenu-${PV}.tar.gz"

EXTRA_OEMAKE = ""

do_compile () {
	oe_runmake -C src 'CC=${CC}' 'CFLAGS=${CFLAGS}' 'LDFLAGS=${LDFLAGS}'
}

do_install () {
	oe_runmake -C src 'PLUGINDIR=${datadir}/bootmenu' 'PREFIX=${bindir}' 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "4bc23a411468c7fb579ec6c10d2684e2"
SRC_URI[sha256sum] = "4e329b19c810d2a8dd5b9e98e56cfc5d6389798947e400e5fe541dbc1307278f"
