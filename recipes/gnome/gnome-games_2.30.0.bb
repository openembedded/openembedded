LICENSE = "GPL"
DEPENDS = "guile libggz ggz-client-libs python-pygtk gtk+ libgnome libgnomeui librsvg gnome-vfs gconf libglade gnome-common gnome-python-desktop gnome-python gstreamer"

inherit gnome distutils-base gconf

SRC_URI[archive.md5sum] = "324acc2f45b1d1f2000cdbd6c596a250"
SRC_URI[archive.sha256sum] = "17f7b3bef00b26963a7155e861730aa427def70dace3358aa9fb4899603ef9da"

EXTRA_OECONF = " \
                --enable-omitgames=quadrapassel,lightsoff,swell-foop,gnibbles \
                --enable-introspection=no \
                --with-libggz-includes=${STAGING_INCDIR} \
                --with-libggz-libraries=${STAGING_LIBDIR} \
                --with-ggzmod-includes=${STAGING_INCDIR} \
                --with-ggzmod-libraries=${STAGING_LIBDIR} \
                --with-ggzcore-includes=${STAGING_INCDIR} \
                --with-ggzcore-libraries=${STAGING_LIBDIR} \
	        --disable-tests \
		INTLTOOL_PERL=${STAGING_BINDIR_NATIVE}/perl \
	       "

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:'I/usr/include'::g -e s:'-I /usr/include -I /usr/local/include'::g $i
	done	
}

# copy matchbox icons
do_install_append() {
	install -d  ${D}/${datadir}/pixmaps
	install -m 0644 ${D}/${datadir}/icons/hicolor/48x48/apps/* ${D}/${datadir}/pixmaps
}

CFLAGS_append = " -lguile -lgmp -lcrypt -lm -lltdl"

FILES_${PN}-doc += " ${datadir}/gnome/help"
FILES_${PN}-dbg += " ${bindir}/.debug ${libdir}/gnome-games/.debug"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_${PN} += "gnome-games-aisleriot gnome-games-cards gnome-games-glchess gnome-games-glines gnome-games-gnect gnome-games-gnobots2 gnome-games-gnomine gnome-games-gnotravex gnome-games-gnotski gnome-games-gtali gnome-games-iagno gnome-games-mahjongg gnome-games-sudoku "

PACKAGES =+ "gnome-games-common"
DESCRIPTION_gnome-games-common = "GNOME games common resources"
FILES_gnome-games-common = "${datadir}/ggz \
				${libdir}/ggz \
				${sysconfdir} \
				${datadir}/gnome-games/icons \
				${datadir}/icons \
				${datadir}/gnome-games/sounds"
# svg is needed for --enable-scalable by nearly all, so put into -common
RDEPENDS_gnome-games-common = "librsvg librsvg-gtk"

PACKAGES =+ "gnome-games-cards"
DESCRIPTION_gnome-games-cards = "GNOME games playing card resources"
FILES_gnome-games-cards = "${datadir}/gnome-games/pixmaps \
				${libdir}/gnome-games/gnome-games-render-cards \
				${datadir}/gnome-games-common/cards"

PACKAGES =+ "gnome-games-gnomine"
DESCRIPTION_gnome-games-gnomine = "GNOME minesweeper game"
RDEPENDS_gnome-games-gnomine = "gnome-games-common"
FILES_gnome-games-gnomine = "${bindir}/gnomine \
				${datadir}/gnome-games/gnomine \
				${datadir}/pixmaps/gnome-mines.png \
				${datadir}/applications/gnomine.desktop \
				${sysconfdir}/gconf/schemas/gnomine.schemas \
				/var/games/gnomine.*.scores"

PACKAGES =+ "gnome-games-aisleriot"
DESCRIPTION_gnome-games-aisleriot = "GNOME solitaire games"
RDEPENDS_gnome-games-aisleriot = "gnome-games-common gnome-games-cards"
FILES_gnome-games-aisleriot = "${bindir}/sol \
				${datadir}/gnome-games/aisleriot \
				${datadir}/pixmaps/gnome-aisleriot.png \
				${datadir}/pixmaps/gnome-freecell.png \
				${datadir}/applications/sol.desktop \
				${datadir}/applications/freecell.desktop \
				${sysconfdir}/gconf/schemas/aisleriot.schemas"

PACKAGES =+ "gnome-games-gnect"
DESCRIPTION_gnome-games-gnect = "GNOME four-in-a-row game"
RDEPENDS_gnome-games-gnect = "gnome-games-common"
FILES_gnome-games-gnect = "${bindir}/gnect \
				${datadir}/gnect \
				${datadir}/gnome-games/gnect \
				${datadir}/pixmaps/gnome-gnect.png \
				${datadir}/applications/gnect.desktop \
				${sysconfdir}/gconf/schemas/gnect.schemas"

PACKAGES =+ "gnome-games-mahjongg"
DESCRIPTION_gnome-games-mahjongg = "GNOME mahjongg game"
RDEPENDS_gnome-games-mahjongg = "gnome-games-common"
FILES_gnome-games-mahjongg = "${bindir}/mahjongg \
				${datadir}/gnome-games/mahjongg \
				${datadir}/pixmaps/gnome-mahjongg.png \
				${datadir}/applications/mahjongg.desktop \
				${sysconfdir}/gconf/schemas/mahjongg.schemas \
				/var/games/mahjongg.*.scores"

PACKAGES =+ "gnome-games-gtali"
DESCRIPTION_gnome-games-gtali = "GNOME yahtzee game"
RDEPENDS_gnome-games-gtali = "gnome-games-common"
FILES_gnome-games-gtali = "${bindir}/gtali \
				${datadir}/gnome-games/gtali \
				${datadir}/pixmaps/gnome-tali.png \
				${datadir}/applications/gtali.desktop \
				${sysconfdir}/gconf/schemas/gtali.schemas \
				/var/games/gtali.*.scores"

PACKAGES =+ "gnome-games-gnotravex"
DESCRIPTION_gnome-games-gnotravex = "GNOME tile matching game"
RDEPENDS_gnome-games-gnotravex = "gnome-games-common"
FILES_gnome-games-gnotravex = "${bindir}/gnotravex \
				${datadir}/gnome-games/gnotravex \
				${datadir}/pixmaps/gnome-tetravex.png \
				${datadir}/applications/gnotravex.desktop \
				${sysconfdir}/gconf/schemas/gnotravex.schemas \
				/var/games/gnotravex.*.scores"

PACKAGES =+ "gnome-games-gnotski"
DESCRIPTION_gnome-games-gnotski = "GNOME blocks puzzle game"
RDEPENDS_gnome-games-gnotski = "gnome-games-common"
FILES_gnome-games-gnotski = "${bindir}/gnotski \
				${datadir}/gnome-games/gnotski \
				${datadir}/pixmaps/gnome-klotski.png \
				${datadir}/applications/gnotski.desktop \
				${sysconfdir}/gconf/schemas/gnotski.schemas \
				/var/games/gnotski.*.scores"

PACKAGES =+ "gnome-games-glines"
DESCRIPTION_gnome-games-glines = "GNOME five-or-more game"
RDEPENDS_gnome-games-glines = "gnome-games-common"
FILES_gnome-games-glines = "${bindir}/glines \
				${datadir}/gnome-games/glines \
				${datadir}/pixmaps/gnome-glines.png \
				${datadir}/applications/glines.desktop \
				${sysconfdir}/gconf/schemas/glines.schemas \
				/var/games/glines.*.scores"

PACKAGES =+ "gnome-games-iagno"
DESCRIPTION_gnome-games-iagno = "GNOME reversi game"
RDEPENDS_gnome-games-iagno = "gnome-games-common"
FILES_gnome-games-iagno = "${bindir}/iagno \
				${datadir}/gnome-games/iagno \
				${datadir}/pixmaps/gnome-iagno.png \
				${datadir}/applications/iagno.desktop \
				${sysconfdir}/gconf/schemas/iagno.schemas"

PACKAGES =+ "gnome-games-gnobots2"
DESCRIPTION_gnome-games-gnobots2 = "GNOME robots game"
RDEPENDS_gnome-games-gnobots2 = "gnome-games-common"
FILES_gnome-games-gnobots2 = "${bindir}/gnobots2 \
				${datadir}/gnome-games/gnobots2 \
				${datadir}/pixmaps/gnome-robots.png \
				${datadir}/applications/gnobots2.desktop \
				${sysconfdir}/gconf/schemas/gnobots2.schemas \
				/var/games/gnobots2.*.scores"

PACKAGES =+ "gnome-games-glchess"
DESCRIPTION_gnome-games-glchess = "GNOME chess"
RDEPENDS_gnome-games-glchess = "python-pygtk python-codecs \
				python-netclient python-xml \
				gnome-python"
FILES_gnome-games-glchess = "${bindir}/glchess \
				${bindir}/gnome-gnuchess \
				${datadir}/glchess \
				${datadir}/pixmaps/gnome-glchess.png \
				${datadir}/applications/glchess.desktop \
				${sysconfdir}/gconf/schemas/glchess.schemas \
				${libdir}/python2.5/site-packages/glchess"

PACKAGES =+ "gnome-games-sudoku"
DESCRIPTION_gnome-games-sudoku = "GNOME sudoku"
RDEPENDS_gnome-games-sudoku = "python-pygtk python-codecs python-difflib \
				python-xml python-netclient \
				python-textutils python-threading \
				gnome-python gnome-python-desktop"
FILES_gnome-games-sudoku = "${bindir}/gnome-sudoku \
				${datadir}/gnome-sudoku \
				${datadir}/pixmaps/gnome-sudoku.png \
				${datadir}/applications/gnome-sudoku.desktop \
				${libdir}/python2.5/site-packages/gnome_sudoku"
