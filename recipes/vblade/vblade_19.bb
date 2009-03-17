DESCRIPTION = "Virtual EtherDrive blade AoE target"
SECTION = "console/network"
PR = "r1"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/aoetools/${PN}-${PV}.tgz \
	   file://cross.patch;patch=1"

inherit autotools

do_install() {
	install -D -m 0755 ${S}/vblade ${D}/${sbindir}/vblade
	install -D -m 0755 ${S}/vbladed ${D}/${sbindir}/vbladed
	install -D -m 0644 ${S}/vblade.8 ${D}/${mandir}/man8/vblade.8
}
