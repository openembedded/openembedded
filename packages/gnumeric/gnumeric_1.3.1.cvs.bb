LICENSE = GPL
SECTION = "x11/utils"
#CVSDATE="20040719"
CVSTAG="GNUMERIC_1_3_1"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/gnumeric"


PR = "r1"
SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=gnumeric;tag=${CVSTAG} \
           file://gnumeric-doc.make.patch;patch=1 \
           file://Makefile.am.patch;patch=1"
	   
DEPENDS = "libgsf1 gtk+ libxml2 libglade libart-lgpl intltool-native libgnomecanvas libgnomeprint libgnomeprintui" 


EXTRA_OECONF = "--without-gnome"

do_configure_prepend() {
	touch xmldocs.make
	intltoolize --automake --debug
#	# aclocal seems to insist on looking in here.  Make sure it exists.
#	mkdir -p ${S}/m4
#	# work around automake lossage with AC_CONFIG_AUX_DIR
#	( cd libmutt; libtoolize --force ; cp ../ltmain.sh . )
}

inherit autotools
