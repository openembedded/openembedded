require gimp.inc

DEPENDS += "lcms gegl hal"

SRC_URI = "ftp://ftp.gimp.org/pub/gimp/v2.5/gimp-${PV}.tar.bz2 \
          "

do_compile_prepend() {
	for i in ca de fr ja oc ru sv; do
		echo >  ${S}/po/$i.po
	done
}


SRC_URI[md5sum] = "98add4a1ca6af2e20f80ae3f5a84a922"
SRC_URI[sha256sum] = "78d209885768790be6d610d275430e6e775392b6384d326401a7ecc13606c539"
