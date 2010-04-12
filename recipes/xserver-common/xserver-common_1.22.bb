DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r11"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh "
SRC_URI_append_angstrom = " file://kdrive-1.4-fixes.patch;patch=1 \
                            file://xorg-fixes.patch;patch=1 \
			    file://gta-xorg-fixes.patch;patch=1 \
                            file://default.xmodmap \
                            file://98keymap-fixup "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

do_install_append_angstrom() {
        install -m 0644 ${WORKDIR}/default.xmodmap ${D}/etc/X11/
	install -m 0755 ${WORKDIR}/98keymap-fixup  ${D}/etc/X11/Xinit.d/
}

SRC_URI[md5sum] = "658badd22689cdde536050f740ec8319"
SRC_URI[sha256sum] = "70a767f1109bf70353c58b0fb54626a1300fd0724017196bfd17d13a582ddd62"
