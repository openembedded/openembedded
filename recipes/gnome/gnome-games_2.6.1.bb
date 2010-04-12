LICENSE = "GPL"
DEPENDS = "guile gtk+ libgnome libgnomeui librsvg gnome-vfs gconf libglade gnome-common"
PR = "r2"

inherit gnome

PACKAGES =+ "libgdkcardimage libgdkcardimage-data libgdkcardimage-dev"

FILES_libgdkcardimage = "${libdir}/libgdkcardimage.so.*"
FILES_libgdkcardimage-dev = "${libdir}/libgdkcardimage.* ${includedir}/gdkcardimage"
FILES_libgdkcardimage-data = "${datadir}/pixmaps/cards"
DEPENDS_libgdkcardimage = "libgdkcardimage-data"

FILES_${PN}-doc += " ${datadir}/gnome/help"

PACKAGES =+ "gnome-games-sol "
FILES_gnome-games-sol = "${bindir}/sol ${datadir}/applications/sol.desktop ${datadir}/pixmaps/gnome-aisleriot.png ${sysconfdir}/gconf/schemas/aisleriot.schemas ${datadir}/sol-games"

PACKAGES =+ "gnome-games-gnometris "
FILES_gnome-games-gnometris = "${bindir}/gnometris ${datadir}/pixmaps/gnometris ${datadir}/pixmaps/gnome-gtetris.png ${datadir}/applications/gnometris.desktop ${sysconfdir}/gconf/schemas/gnometris.schemas"

PACKAGES =+ "gnome-games-gnomine"
FILES_gnome-games-gnomine = "${bindir}/gnomine ${datadir}/pixmaps/gnomine ${datadir}/pixmaps/gnome-gnomine.png ${datadir}/applications/gnomine.desktop ${sysconfdir}/gconf/schemas/gnomine.schemas"

EXTRA_OECONF = "--disable-schemas-install"

SRC_URI[archive.md5sum] = "6ea145547bfd8aa828b22cbbe34cbedf"
SRC_URI[archive.sha256sum] = "d7a823601f569589437d671d12b1b12f53abc08aeb7d25280bb3242299353086"
