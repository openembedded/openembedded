DEPENDS = "enigma"
DESCRIPTION = "tuxbox plugins (enigma)"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/tuxbox/plugins;method=ext \
	   file://disable_nonworking.diff;patch=1;pnum=1 \
	   file://fix_config_path.diff;patch=1;pnum=1 \
	   file://fix_install_weather_pics.diff;patch=1;pnum=1"

CVSDATE = "20060112"
PV = "0.0+cvs${CVSDATE}"
PR = "r0"

CFLAGS_append = " -I${STAGING_INCDIR}/enigma -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"
CXXFLAGS_append = " -I${STAGING_INCDIR}/enigma -DHAVE_DREAMBOX_HARDWARE -DDREAMBOX"

PACKAGES = "enigma-plugin-dreamdata enigma-plugin-dbswitch \
	enigma-plugin-ngrabstart enigma-plugin-ngrabstop enigma-plugin-getset \
	enigma-plugin-movieplayer enigma-plugin-script enigma-plugin-rss \
	enigma-plugin-weather enigma-plugin-demo"

FILES_enigma-plugin-dreamdata = "/usr/lib/tuxbox/plugins/dreamdata.so /usr/lib/tuxbox/plugins/dreamdata.cfg \
	/etc/tuxbox/dreamdata.xml"
FILES_enigma-plugin-dbswitch = "/usr/lib/tuxbox/plugins/dbswitch.so /usr/lib/tuxbox/plugins/dbswitch.cfg"
FILES_enigma-plugin-ngrabstart = "/usr/lib/tuxbox/plugins/ngrabstart.so /usr/lib/tuxbox/plugins/ngrabstart.cfg"
FILES_enigma-plugin-ngrabstop = "/usr/lib/tuxbox/plugins/ngrabstop.so /usr/lib/tuxbox/plugins/ngrabstop.cfg"
FILES_enigma-plugin-getset = "/usr/lib/tuxbox/plugins/enigma_getset.so /usr/lib/tuxbox/plugins/enigma_getset.cfg"
FILES_enigma-plugin-movieplayer = "/usr/lib/tuxbox/plugins/movieplayer.so /usr/lib/tuxbox/plugins/movieplayer.cfg"
FILES_enigma-plugin-script = "/usr/lib/tuxbox/plugins/script.so /usr/lib/tuxbox/plugins/script.cfg"
FILES_enigma-plugin-rss = "/usr/lib/tuxbox/plugins/rss.so /usr/lib/tuxbox/plugins/rss.cfg \
	/etc/tuxbox/feeds.xml"
FILES_enigma-plugin-weather = "/usr/lib/tuxbox/plugins/weather.so /usr/lib/tuxbox/plugins/weather.cfg \
	/etc/tuxbox/weather.xml /usr/share/tuxbox/weather/*.png"
FILES_enigma-plugin-demo = "/usr/lib/tuxbox/plugins/enigma_demo.so /usr/lib/tuxbox/plugins/enigma_demo.cfg"

S = "${WORKDIR}/plugins"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=native --with-boxtype=dm7020"
