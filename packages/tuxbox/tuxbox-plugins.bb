DEPENDS = "curl libpng freetype dreambox-dvbincludes libtuxtxt"
DEPENDS_append_dm7020 = " libsigc++-1.2 enigma"
DESCRIPTION = "tuxbox libs"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins;method=ext \
	   file://disable_nonworking.diff;patch=1;pnum=1 \
	   file://fix_config_path.diff;patch=1;pnum=1 \
           file://game_names.diff;patch=1;pnum=1"

CVSDATE = "20060112"
PV = "0.0+cvs${CVSDATE}"
PR = "r0"

CFLAGS_append = " -DOE -I${STAGING_INCDIR}/enigma"
CFLAGS_append_dm7020 = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"
CXXFLAGS_append = " -DOE -I${STAGING_INCDIR}/enigma"
CXXFLAGS_append_dm7020 = " -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

PACKAGES = "tuxbox-plugins-dev tuxbox-plugin-tuxtxt tuxbox-plugin-tuxmail \
	tuxbox-plugin-tuxcom tuxbox-plugin-mines tuxbox-plugin-pacman \
	tuxbox-plugin-tetris tuxbox-plugin-snake tuxbox-plugin-yahtzee \
	tuxbox-plugin-master tuxbox-plugin-tank tuxbox-plugin-lemmings \
	tuxbox-plugin-lcdcirc tuxbox-plugin-satfind tuxbox-plugin-vierg \
	tuxbox-plugin-soko tuxbox-plugin-solitair tuxbox-plugin-sol \
	tuxbox-plugin-fx2 tuxbox-plugin-vnc"

PACKAGES_append_dm7020 = " enigma-plugin-dreamdata enigma-plugin-dbswitch \
	enigma-plugin-ngrabstart enigma-plugin-ngrabstop enigma-plugin-getset \
	enigma-plugin-movieplayer enigma-plugin-script enigma-plugin-rss \
	enigma-plugin-weather enigma-plugin-demo"

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
FILES_enigma-plugin-dreamdata = "/usr/lib/tuxbox/plugins/dreamdata.so /usr/lib/tuxbox/plugins/dreamdata.cfg \
	/etc/tuxbox/dreamdata.xml"
FILES_enigma-plugin-dbswitch = "/usr/lib/tuxbox/plugins/dbswitch.so /usr/lib/tuxbox/plugins/dbswitch.cfg"
FILES_enigma-plugin-ngrabstart = "/usr/lib/tuxbox/plugins/ngrabstart.so /usr/lib/tuxbox/plugins/ngrabstart.cfg"
FILES_enigma-plugin-ngrabstop = "/usr/lib/tuxbox/plugins/ngrabstop.so /usr/lib/tuxbox/plugins/ngrabstop.cfg"
FILES_enigma-plugin-getset = "/usr/lib/tuxbox/plugins/enigma_getset.so /usr/lib/tuxbox/plugins/enigma_getset.cfg"
FILES_enigma-plugin-movieplayer = "/usr/lib/tuxbox/plugins/getset.so /usr/lib/tuxbox/plugins/movieplayer.cfg"
FILES_enigma-plugin-script = "/usr/lib/tuxbox/plugins/script.so /usr/lib/tuxbox/plugins/script.cfg"
FILES_enigma-plugin-rss = "/usr/lib/tuxbox/plugins/rss.so /usr/lib/tuxbox/plugins/rss.cfg \
	/etc/tuxbox/feeds.xml"
FILES_enigma-plugin-weather = "/usr/lib/tuxbox/plugins/weather.so /usr/lib/tuxbox/plugins/weather.cfg \
	/etc/tuxbox/weather.xml"
FILES_enigma-plugin-demo = "/usr/lib/tuxbox/plugins/enigma_demo.so /usr/lib/tuxbox/plugins/enigma_demo.cfg"

S = "${WORKDIR}/plugins"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native"
EXTRA_OECONF_append_dm7020 = " --with-boxtype=dm7020"

do_install_append() {
	install -d ${D}/etc/tuxbox/tuxtxt/
	install -d ${D}/etc/init.d/
	install ${S}/tuxmail/daemon/tuxmail ${D}/etc/init.d
}

do_stage() {
	install -d ${STAGING_INCDIR}/tuxbox
	install -m 0644 ${S}/include/plugin.h ${STAGING_INCDIR}/tuxbox/
}
