LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/gEDA ${datadir}/icons"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"
inherit autotools pkgconfig

EXTRA_OECONF = "--disable-update-desktop-database"

do_patch_prepend() {
        import bb
        if bb.data.getVar('PREFERRED_VERSION_gtk+', d, 1) and
        bb.data.getVar('PREFERRED_VERSION_gtk+', d, 1).split('.')[0] <= '2' and 
        bb.data.getVar('PREFERRED_VERSION_gtk+', d, 1).split('.')[1] < '18':
            SRC_URI_append = "file://gattrib-gtk218.patch;patch=1"
}
