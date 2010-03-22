DESCRIPTION = "SMPEG is a general purpose MPEG video/audio \
player for Linux based on the mpeg_play and SPLAY MPEG decoders."
LICENSE = "LGPL"
SECTION = "libs/multimedia"
DEPENDS = "virtual/libsdl"
PROVIDES = "smpeg"
PV = "0.4.5+svnr${SRCPV}"
PE = "1"
SRCREV = "387"

SRC_URI = "svn://svn.icculus.org/smpeg/;module=trunk"

S = "${WORKDIR}/trunk"

inherit autotools binconfig

EXTRA_OECONF = "--disable-gtktest --disable-opengl-player --without-x \
		--without-gtk --disable-gtk-player"

do_configure_prepend () {
	touch NEWS AUTHORS ChangeLog
	# drop all .m4 which are available in staging
	rm -f acinclude/gtk-2.0.m4 \
	      acinclude/libtool.m4 \
	      acinclude/ltdl.m4 \
	      acinclude/ltoptions.m4 \
	      acinclude/ltsugar.m4 \
	      acinclude/ltversion.m4 \
	      acinclude/lt~obsolete.m4 \
	      acinclude/pkg.m4 \
	      acinclude/sdl.m4 \
	      aclocal.m4 \
	      acinclude.m4
}

PACKAGES =+ "plaympeg "
SECTION_plaympeg = "console/multimedia"
FILES_${PN} = "${libdir}"
FILES_plaympeg = "${bindir}/plaympeg"
FILES_${PN}-dev += "${bindir}"

