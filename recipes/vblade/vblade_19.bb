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

SRC_URI[md5sum] = "59d45caa6454388eea60441dcf6631db"
SRC_URI[sha256sum] = "779c8c9e80ce09e8ef1737216c8438c6e614d7001e1a6f312e4a82191e34870e"
