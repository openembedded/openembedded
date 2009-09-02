DESCRIPTION = "Brickshooter Game"
HOMEPAGE = "http://bilious.homelinux.org/~paxed/brickshooter/"
AUTHOR = "Pasi Kallinen"
LICENSE = "GPLv2"
SECTION = "other/games"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}"

SRC_URI = "http://bilious.homelinux.org/~paxed/brickshooter/brickshooter-0.04.tar.gz \
	   http://pallas.crash-override.net/~blindcoder/brickshooter.png \
	   file://readyforfr.patch file://brickshooter.desktop"

do_configure() {
}

do_compile() {
	patch -p1 -i ../readyforfr.patch
	make CC="${CC}"
}

do_install() {
	mkdir -p ${D}/usr/share/brickshooter
	mkdir -p ${D}/usr/share/brickshooter/gfx
	mkdir -p ${D}/usr/share/brickshooter/levels
	mkdir -p ${D}/usr/share/brickshooter/snd
	for x in gfx/* levels/* snd/* ; do
		install -m 0644 ${x} ${D}/usr/share/brickshooter/${x}
	done
	install -m 0755 brickshooter ${D}/usr/bin/brickshooter
	install -m 0644 ../brickshooter.png ${D}/usr/share/pixmaps/brickshooter.png
	install -m 0644 ../brickshooter.desktop ${D}/usr/share/applications/brickshooter.desktop
}
