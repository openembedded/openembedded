require gimp.inc

DEPENDS += "lcms gegl hal"

SRC_URI = "ftp://ftp.gimp.org/pub/gimp/v2.5/gimp-${PV}.tar.bz2 \
          "

do_compile_prepend() {
	for i in ca de fr ja oc ru sv; do
		echo >  ${S}/po/$i.po
	done
}

