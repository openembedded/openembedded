DESCRIPTION = "gnuZ is a Lemmings style game"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Lukas Fraser"
HOMEPAGE = "http://gnuz.4cows.net/eraser/gnuz/"
DEPENDS = "gnuz-levelmaker-native gnuz-package-native"

SRC_URI = "http://gnuz.4cows.net/eraser/gnuz/gnuz_0.3.tar.gz \
           http://gnuz.4cows.net/eraser/gnuz/gnuz_0.3_levels.tar.gz \
		   file://intro_level.patch;patch=1;pnum=0"

S = "${WORKDIR}/gnuz"

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST += "LIBS+=-lqpe"

inherit palmtop

do_compile_append() {

	cd ${WORKDIR}
	
	for level in *.conf
	do
		if [ $level != 'intro.conf' ] ;then
			${STAGING_BINDIR}/gnuz_levelmaker `basename $level .conf`.lvl $level
		fi
	done
	${STAGING_BINDIR}/gnuz_levelmaker intro intro.conf
	cd ${S}/data/
	${STAGING_BINDIR}/gnuz_package guiimages.dat gui
	${STAGING_BINDIR}/gnuz_package gnuimages.dat gnu
	
	
}

do_install() {

	install -d ${D}${palmtopdir}/apps/Games \
			   ${D}${palmtopdir}/pics \
			   ${D}${palmtopdir}/bin \
			   ${D}${palmtopdir}/share/gnuz/levels

	install -m 0755 gnuz ${D}${palmtopdir}/bin/
	install -m 0644 data/gnuz.desktop ${D}${palmtopdir}/apps/Games/
	install -m 0644 data/gnuz.png ${D}${palmtopdir}/pics/
	install -m 0644 ${WORKDIR}/*.lvl ${D}${palmtopdir}/share/gnuz/levels/
	install -m 0644 ${WORKDIR}/intro ${D}${palmtopdir}/share/gnuz/levels/
	install -m 0644 ${S}/data/*images.dat ${D}${palmtopdir}/share/gnuz/

}
