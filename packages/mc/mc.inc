DESCRIPTION = "GNU Midnight Commander is a file \
manager for free operating systems."
HOMEPAGE = "http://www.ibiblio.org/mc/"
LICENSE = "GPLv2"
SECTION = "console/utils"
PRIORITY = "optional"
DEPENDS = "ncurses glib-2.0"
RDEPENDS = "ncurses-terminfo"

SRC_URI = "http://www.ibiblio.org/pub/Linux/utils/file/managers/mc/mc-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-glibtest --without-x --without-samba \
--without-nfs --without-gpm-mouse --with-screen=ncurses"

PACKAGES += "${PN}-extfs ${PN}-hilite"
FILES_${PN} = "${bindir}/ ${libdir}/ ${datadir}/mc/*.*"
FILES_${PN}-extfs = "${datadir}/mc/extfs/"
FILES_${PN}-hilite = "${datadir}/mc/syntax/"
RRECOMMENDS_${PN} += "${PN}-extfs ${PN}-hilite"
RDEPENDS_${PN}-extfs = "${PN}"
RDEPENDS_${PN}-hilite = "${PN}"
PACKAGE_ARCH_${PN}-extfs = "all"
PACKAGE_ARCH_${PN}-hilite = "all"


do_configure() {
	gnu-configize
	oe_runconf
}

do_install() {
	cd src
	oe_runmake 'DESTDIR=${D}' install
	cd ../syntax
	oe_runmake 'DESTDIR=${D}' install
	cd ../po
	oe_runmake 'DESTDIR=${D}' install
	cd ../vfs
	oe_runmake 'DESTDIR=${D}' install
	cd ..

        install -m 0644 lib/cedit.menu ${D}${datadir}/mc/
        install -m 0644 lib/edit.indent.rc ${D}${datadir}/mc/
        install -m 0644 lib/edit.spell.rc ${D}${datadir}/mc/
        install -m 0644 lib/mc.charsets ${D}${datadir}/mc/
        install -m 0644 lib/mc.ext ${D}${datadir}/mc/
        install -m 0644 lib/mc.lib ${D}${datadir}/mc/
        install -m 0644 lib/mc.menu ${D}${datadir}/mc/
        install -m 0644 lib/mc.menu.sr ${D}${datadir}/mc/
}
