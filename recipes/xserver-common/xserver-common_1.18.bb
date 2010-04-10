DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r1"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://ti-osk.patch;patch=1 file://unbreak-simpad.patch;patch=1 file://setDPI.sh "

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

SRC_URI[md5sum] = "72c8b5c4c4aa18abe4f29308d2726e1e"
SRC_URI[sha256sum] = "3e198bf84fac63cd5d93521c1646cf6dc2d959b4c84a16aa9cd1d9ca94ddd212"
