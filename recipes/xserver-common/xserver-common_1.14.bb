DESCRIPTION = "Common X11 scripts and support files"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "xmodmap xrandr xdpyinfo"
PR = "r2"

PACKAGE_ARCH = "all"

# we are using a gpe-style Makefile
inherit gpe

SRC_URI_append = " file://setDPI.sh \
                   file://xserver-imageon.patch;patch=1 \
                   file://calibrate-only-if-ts.patch;patch=1"

do_install_append() {
	install -m 0755 "${WORKDIR}/setDPI.sh" "${D}/etc/X11/Xinit.d/50setdpi"
}

SRC_URI[md5sum] = "4cdc10f4c429cfcf5bc6e28fe028cf0f"
SRC_URI[sha256sum] = "260faa13632aee22573f766c0dabed6573e959d1f686c5880b151f393df6d350"
