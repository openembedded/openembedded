DESCRIPTION = "Lightweight Japanese font in 10 point suitable for 320x240 display"
SECTION = "opie/fonts"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.jp/projects/zaurus-ja/"
RPROVIDES = "virtual/japanese-font"
PR = "r2"

SRC_URI = "http://osdn.dl.sourceforge.jp/zaurus-ja/773/unismall-${PV}.tar.gz"

S = "${WORKDIR}"

do_install () {
        install -d ${D}${palmqtdir}/lib/fonts/
	cd unismall*
	for i in *_100_*.qpf; do
		ln -sf $i $(echo $i | sed 's/_100_/_160_/')
	done
	for i in *.qpf; do
		install -m 644 $i ${D}${palmqtdir}/lib/fonts/${i}
	done
}

inherit qpf
