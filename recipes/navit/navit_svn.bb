PV = "0.1.0+svnr${SRCPV}"
PR = "r0"

DEPENDS_shr += " librsvg-native"

RDEPENDS = " navit-icons"

require navit.inc

EXTRA_OECONF_shr += " --enable-cache-size=20971520"

S = "${WORKDIR}/navit"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

do_configure_prepend() {
  #Remove xpm building
  sed -i 's/\(.*SUBDIRS.*\) xpm\( \|$\)\(.*\)/\1\2\3/g' ${S}/navit/Makefile.am
}

EXTRA_AUTORECONF = " -I m4"
