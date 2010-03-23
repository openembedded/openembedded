DESCRIPTION = "GNOME Games"
HOMEPAGE = "http://live.gnome.org/GnomeGames/"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = " guile libggz ggz-client-libs python-pygtk gtk+ libgnome libgnomeui librsvg gnome-vfs gconf libglade gnome-common gnome-python-desktop gnome-python gstreamer virtual/libsdl libsdl-mixer"

inherit gnome distutils-base gconf

PR = "r2"

SRC_URI += "file://ggz-unbreak-m4.patch;patch=1 \
           "

EXTRA_OECONF = "--with-libggz-includes=${STAGING_INCDIR} \
                --with-libggz-libraries=${STAGING_LIBDIR} \
                --with-ggzmod-includes=${STAGING_INCDIR} \
                --with-ggzmod-libraries=${STAGING_LIBDIR} \
	        --enable-scalable \
		INTLTOOL_PERL=${STAGING_BINDIR_NATIVE}/perl \
	       "

# disable help dir and crappy old sdl-macro
do_configure_prepend() {
        if [ -e m4/sdl.m4 ]; then
	   rm m4/sdl.m4
        fi
	for i in $(find ${S} -name "Makefile.am") ; do
		sed -i -e s:help::g $i
	done
}

# copy matchbox icons
do_install_append() {
	install -m 0644 ${D}/${datadir}/icons/hicolor/48x48/apps/* ${D}/${datadir}/pixmaps
}

LDFLAGS += "-lguile -lgmp -lcrypt -lm -lltdl"

FILES_${PN}-doc += " ${datadir}/gnome/help"
FILES_${PN}-dbg += " ${bindir}/.debug ${libdir}/gnome-games/.debug"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_${PN} += "gnome-games-aisleriot gnome-games-blackjack gnome-games-cards gnome-games-glchess gnome-games-glines gnome-games-gnect gnome-games-gnibbles gnome-games-gnobots2 gnome-games-gnometris gnome-games-gnomine gnome-games-gnotravex gnome-games-gnotski gnome-games-gtali gnome-games-iagno gnome-games-mahjongg gnome-games-same-gnome gnome-games-sudoku "

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

PACKAGES =+ "gnome-games-gnometris"
DESCRIPTION_gnome-games-gnometris = "GNOME tetris game"
RDEPENDS_gnome-games-gnometris = "gnome-games-common"
FILES_gnome-games-gnometris = "${bindir}/gnometris \
				${datadir}/pixmaps/gnometris \
				${datadir}/pixmaps/gnome-gnometris.png \
				${datadir}/applications/gnometris.desktop \
				${sysconfdir}/gconf/schemas/gnometris.schemas \
				/var/games/gnometris.scores"

PACKAGES =+ "gnome-games-gnomine"
DESCRIPTION_gnome-games-gnomine = "GNOME minesweeper game"
RDEPENDS_gnome-games-gnomine = "gnome-games-common"
FILES_gnome-games-gnomine = "${bindir}/gnomine \
				${datadir}/pixmaps/gnomine \
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

PACKAGES =+ "gnome-games-blackjack"
DESCRIPTION_gnome-games-blackjack = "GNOME blackjack game"
RDEPENDS_gnome-games-blackjack = "gnome-games-common gnome-games-cards"
FILES_gnome-games-blackjack = "${bindir}/blackjack \
				${datadir}/gnome-games/blackjack \
				${datadir}/pixmaps/gnome-blackjack.png \
				${datadir}/applications/blackjack.desktop \
				${sysconfdir}/gconf/schemas/blackjack.schemas"

PACKAGES =+ "gnome-games-gnect"
DESCRIPTION_gnome-games-gnect = "GNOME four-in-a-row game"
RDEPENDS_gnome-games-gnect = "gnome-games-common"
FILES_gnome-games-gnect = "${bindir}/gnect \
				${datadir}/gnect \
				${datadir}/pixmaps/gnect \
				${datadir}/pixmaps/gnome-gnect.png \
				${datadir}/applications/gnect.desktop \
				${sysconfdir}/gconf/schemas/gnect.schemas"

PACKAGES =+ "gnome-games-same-gnome"
DESCRIPTION_gnome-games-same-gnome = "GNOME block removal game"
RDEPENDS_gnome-games-same-gnome = "gnome-games-common"
FILES_gnome-games-same-gnome = "${bindir}/same-gnome \
				${datadir}/gnome-games/same-gnome/themes/2.10 \
				${datadir}/pixmaps/gnome-samegnome.png \
				${datadir}/applications/same-gnome.desktop \
				${sysconfdir}/gconf/schemas/same-gnome.schemas \
				/var/games/same-gnome.*.scores"

PACKAGES =+ "gnome-games-mahjongg"
DESCRIPTION_gnome-games-mahjongg = "GNOME mahjongg game"
RDEPENDS_gnome-games-mahjongg = "gnome-games-common"
FILES_gnome-games-mahjongg = "${bindir}/mahjongg \
				${datadir}/gnome-games/mahjongg \
				${datadir}/pixmaps/mahjongg \
				${datadir}/pixmaps/gnome-mahjongg.png \
				${datadir}/applications/mahjongg.desktop \
				${sysconfdir}/gconf/schemas/mahjongg.schemas \
				/var/games/mahjongg.*.scores"

PACKAGES =+ "gnome-games-gtali"
DESCRIPTION_gnome-games-gtali = "GNOME yahtzee game"
RDEPENDS_gnome-games-gtali = "gnome-games-common"
FILES_gnome-games-gtali = "${bindir}/gtali \
				${datadir}/pixmaps/gtali \
				${datadir}/pixmaps/gnome-tali.png \
				${datadir}/applications/gtali.desktop \
				${sysconfdir}/gconf/schemas/gtali.schemas \
				/var/games/gtali.*.scores"

PACKAGES =+ "gnome-games-gnotravex"
DESCRIPTION_gnome-games-gnotravex = "GNOME tile matching game"
RDEPENDS_gnome-games-gnotravex = "gnome-games-common"
FILES_gnome-games-gnotravex = "${bindir}/gnotravex \
				${datadir}/pixmaps/gnotravex \
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
				${datadir}/pixmaps/glines \
				${datadir}/pixmaps/gnome-glines.png \
				${datadir}/applications/glines.desktop \
				${sysconfdir}/gconf/schemas/glines.schemas \
				/var/games/glines.*.scores"

PACKAGES =+ "gnome-games-iagno"
DESCRIPTION_gnome-games-iagno = "GNOME reversi game"
RDEPENDS_gnome-games-iagno = "gnome-games-common"
FILES_gnome-games-iagno = "${bindir}/iagno \
				${datadir}/pixmaps/iagno \
				${datadir}/pixmaps/gnome-iagno.png \
				${datadir}/applications/iagno.desktop \
				${sysconfdir}/gconf/schemas/iagno.schemas"

PACKAGES =+ "gnome-games-gnobots2"
DESCRIPTION_gnome-games-gnobots2 = "GNOME robots game"
RDEPENDS_gnome-games-gnobots2 = "gnome-games-common"
FILES_gnome-games-gnobots2 = "${bindir}/gnobots2 \
				${datadir}/pixmaps/gnobots2 \
				${datadir}/gnobots2 \
				${datadir}/pixmaps/gnome-robots.png \
				${datadir}/applications/gnobots2.desktop \
				${sysconfdir}/gconf/schemas/gnobots2.schemas \
				/var/games/gnobots2.*.scores"

PACKAGES =+ "gnome-games-gnibbles"
DESCRIPTION_gnome-games-gnibbles = "GNOME worm game"
RDEPENDS_gnome-games-gnibbles = "gnome-games-common"
FILES_gnome-games-gnibbles = "${bindir}/gnibbles \
				${datadir}/pixmaps/gnibbles \
				${datadir}/gnibbles \
				${datadir}/pixmaps/gnome-gnibbles.png \
				${datadir}/applications/gnibbles.desktop \
				${sysconfdir}/gconf/schemas/gnibbles.schemas \
				/var/games/gnibbles.*.scores"

PACKAGES =+ "gnome-games-glchess"
DESCRIPTION_gnome-games-glchess = "GNOME chess"
RDEPENDS_gnome-games-glchess = "python-pygtk python-codecs \
				python-netclient python-xml \
				gnome-python"
FILES_gnome-games-glchess = "${bindir}/glchess \
				${bindir}/gnome-gnuchess \
				${datadir}/pixmaps/glchess \
				${datadir}/glchess \
				${datadir}/pixmaps/gnome-glchess.png \
				${datadir}/applications/glchess.desktop \
				${sysconfdir}/gconf/schemas/glchess.schemas \
				${PYTHON_SITEPACKAGES_DIR}/glchess"

PACKAGES =+ "gnome-games-sudoku"
DESCRIPTION_gnome-games-sudoku = "GNOME sudoku"
RDEPENDS_gnome-games-sudoku = "python-pygtk python-codecs python-difflib \
				python-xml python-netclient \
				python-textutils python-threading \
				gnome-python gnome-python-desktop"
FILES_gnome-games-sudoku = "${bindir}/gnome-sudoku \
				${datadir}/pixmaps/gnome-sudoku \
				${datadir}/gnome-sudoku \
				${datadir}/pixmaps/gnome-sudoku.png \
				${datadir}/applications/gnome-sudoku.desktop \
				${PYTHON_SITEPACKAGES_DIR}/gnome_sudoku"
