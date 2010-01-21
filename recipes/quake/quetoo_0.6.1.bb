DESCRIPTION = "Initially a fork of the Quake2Forge project, this engine aims to provide security and performance enhancements."
LICENSE = "GPLv2"

DEPENDS = "libsdl-x11 zlib virtual/libgl"
SRC_URI = "http://tastyspleen.net/~jdolan/quetoo-${PV}.tar.bz2"

PR = "r1"
inherit autotools pkgconfig


EXTRA_OECONF = "\
               --with-games=baseq2 \
	       --with-sdl \
	       --with-zlib \
	       "

do_configure() {
	for i in ctf qmass vanctf ; do
		mkdir -p ${S}/data/$i/sound
		mkdir -p ${S}/data/$i/maps 
		mkdir -p ${S}/src/$i
		touch ${S}/data/$i/Makefile.in
		touch ${S}/data/$i/sound/Makefile.in
		touch ${S}/data/$i/maps/Makefile.in
		touch ${S}/src/$i/Makefile.in	
	done

	sed -i -e s:-Werror::g ${S}/configure
	gnu-configize --force
	oe_runconf
	rm config.log
}

do_install_append() {
	mv ${D}${bindir}/${TARGET_PREFIX}quetoo ${D}${bindir}/quetoo
}

FILES_${PN}-dbg += "${libdir}/quetoo/baseq2/.debug"
