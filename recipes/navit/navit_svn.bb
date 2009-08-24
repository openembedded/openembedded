require navit.inc

PV = "0.1.0+svnrev${SRCREV}"
PR = "r3"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " --enable-cache-size=20971520 --with-svg2png-use-convert"

S = "${WORKDIR}/navit"

SRC_URI = "svn://anonymous@navit.svn.sourceforge.net/svnroot/navit/trunk;module=navit;proto=https"

SRC_URI_append = " \
                  file://navit-svn.xml-so.patch;patch=1 \
                 "

EXTRA_AUTORECONF = " -I m4"
