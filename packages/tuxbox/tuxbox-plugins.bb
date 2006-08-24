DEPENDS = "curl libpng freetype dreambox-dvbincludes libtuxtxt"
DESCRIPTION = "tuxbox plugins"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins;method=ext \
	   file://disable_nonworking.diff;patch=1;pnum=1 \
           file://game_names.diff;patch=1;pnum=1"

SRCDATE = "20060301"
PV = "0.0+cvs${SRCDATE}"
PR = "r0"

CFLAGS_append = " -DOE"
CFLAGS_append_dm7020 = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"
CFLAGS_append_dm600pvr = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"
CXXFLAGS_append = " -DOE"
CXXFLAGS_append_dm7020 = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"
CXXFLAGS_append_dm600pvr = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

PACKAGES = "tuxbox-plugins-dev tuxbox-plugin-tuxtxt tuxbox-plugin-tuxmail \
	tuxbox-plugin-tuxcom tuxbox-plugin-mines tuxbox-plugin-pacman \
	tuxbox-plugin-tetris tuxbox-plugin-snake tuxbox-plugin-yahtzee \
	tuxbox-plugin-master tuxbox-plugin-tank tuxbox-plugin-lemmings \
	tuxbox-plugin-lcdcirc tuxbox-plugin-satfind tuxbox-plugin-vierg \
	tuxbox-plugin-soko tuxbox-plugin-solitair tuxbox-plugin-sol \
	tuxbox-plugin-fx2 tuxbox-plugin-vnc"

FILES_tuxbox-plugin-tuxtxt = "/usr/lib/tuxbox/plugins/tuxtxt.so /usr/lib/tuxbox/plugins/tuxtxt.cfg \
	/usr/share/fonts/tuxtxt.ttf /usr/share/fonts/tuxtxt.otb /etc/tuxbox/tuxtxt"
FILES_tuxbox-plugin-tuxmail = "/usr/lib/tuxbox/plugins/tuxmail.so /usr/lib/tuxbox/plugins/tuxmail.cfg \
	/etc/tuxbox/tuxmail/tuxmail.conf /usr/bin/tuxmaild /etc/init.d/tuxmail"
FILES_tuxbox-plugin-tuxcom = "/usr/lib/tuxbox/plugins/tuxcom.so /usr/lib/tuxbox/plugins/tuxcom.cfg"
FILES_tuxbox-plugin-mines = "/usr/lib/tuxbox/plugins/mines.so /usr/lib/tuxbox/plugins/mines.cfg"
FILES_tuxbox-plugin-pacman = "/usr/lib/tuxbox/plugins/pacman.so /usr/lib/tuxbox/plugins/pacman.cfg"
FILES_tuxbox-plugin-tetris = "/usr/lib/tuxbox/plugins/tetris.so /usr/lib/tuxbox/plugins/tetris.cfg"
FILES_tuxbox-plugin-snake = "/usr/lib/tuxbox/plugins/snake.so /usr/lib/tuxbox/plugins/snake.cfg"
FILES_tuxbox-plugin-yahtzee = "/usr/lib/tuxbox/plugins/yahtzee.so /usr/lib/tuxbox/plugins/yahtzee.cfg"
FILES_tuxbox-plugin-master = "/usr/lib/tuxbox/plugins/master.so /usr/lib/tuxbox/plugins/master.cfg"
FILES_tuxbox-plugin-tank = "/usr/lib/tuxbox/plugins/tank.so /usr/lib/tuxbox/plugins/tank.cfg"
FILES_tuxbox-plugin-lemmings = "/usr/lib/tuxbox/plugins/lemmings.so /usr/lib/tuxbox/plugins/lemmings.cfg"
FILES_tuxbox-plugin-lcdcirc = "/usr/lib/tuxbox/plugins/lcdcirc.so /usr/lib/tuxbox/plugins/lcdcirc.cfg"
FILES_tuxbox-plugin-satfind = "/usr/lib/tuxbox/plugins/satfind.so /usr/lib/tuxbox/plugins/satfind.cfg"
FILES_tuxbox-plugin-vierg = "/usr/lib/tuxbox/plugins/vierg.so /usr/lib/tuxbox/plugins/vierg.cfg"
FILES_tuxbox-plugin-soko = "/usr/lib/tuxbox/plugins/soko.so /usr/lib/tuxbox/plugins/soko.cfg \
	/usr/share/tuxbox/sokoban/1.xsb /usr/share/tuxbox/sokoban/11.xsb /usr/share/tuxbox/sokoban/7.xsb \
	/usr/share/tuxbox/sokoban/8.xsb /usr/share/tuxbox/sokoban/albe-01.xsb /usr/share/tuxbox/sokoban/albe-02.xsb \
	/usr/share/tuxbox/sokoban/albe-03.xsb /usr/share/tuxbox/sokoban/albe-04.xsb /usr/share/tuxbox/sokoban/albe-05.xsb \
	/usr/share/tuxbox/sokoban/albe-06.xsb /usr/share/tuxbox/sokoban/albe-07.xsb /usr/share/tuxbox/sokoban/albe-08.xsb \
	/usr/share/tuxbox/sokoban/albe-09.xsb /usr/share/tuxbox/sokoban/albe-10.xsb /usr/share/tuxbox/sokoban/albe-12.xsb \
	/usr/share/tuxbox/sokoban/albe-13.xsb"
FILES_tuxbox-plugin-solitair = "/usr/lib/tuxbox/plugins/solitair.so /usr/lib/tuxbox/plugins/solitair.cfg"
FILES_tuxbox-plugin-sol = "/usr/lib/tuxbox/plugins/sol.so /usr/lib/tuxbox/plugins/sol.cfg"
FILES_tuxbox-plugin-fx2 = "/usr/lib/tuxbox/plugins/libfx2.so"
FILES_tuxbox-plugin-vnc = "/usr/lib/tuxbox/plugins/vnc.so /usr/lib/tuxbox/plugins/vnc.cfg /etc/tuxbox/vnc.conf"

S = "${WORKDIR}/plugins"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"
EXTRA_OECONF_append_dm7020 = " --with-boxtype=dm7020"
# checkme!
EXTRA_OECONF_append_dm600pvr = " --with-boxtype=dm7020"

do_install_append() {
	install -d ${D}/etc/tuxbox/tuxtxt/
	install -d ${D}/etc/init.d/
	install ${S}/tuxmail/daemon/tuxmail ${D}/etc/init.d
}

do_stage() {
	install -d ${STAGING_INCDIR}/tuxbox
	install -m 0644 ${S}/include/plugin.h ${STAGING_INCDIR}/tuxbox/
}
