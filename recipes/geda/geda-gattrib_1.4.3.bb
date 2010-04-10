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

SRC_URI[md5sum] = "e1f68401e7ca5fff16292358f0dfd553"
SRC_URI[sha256sum] = "5eb48772d374dad446bfcd69990231fa6c6b52ba9b30048991632557512a7565"
