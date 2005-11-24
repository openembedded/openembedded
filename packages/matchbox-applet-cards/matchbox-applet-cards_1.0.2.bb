DESCRIPTION = "Panel applet to eject cards (from PdaXrom project)"
LICENSE = "GPL"
DEPENDS = "matchbox-wm libmatchbox"
SECTION = "x11/wm"
PR = "r1"

SRC_URI = "http://212.10.30.205/rc12/src/mb-applet-cards-${PV}.tar.bz2 \
	file://oz-gpe.patch;patch=1 \
	file://gpe-applet-cards \
	file://cf_mount.png \
	file://cf_unmount.png \
	file://sd_mount.png \
	file://sd_unmount.png \
	file://cards.png"
S = "${WORKDIR}/mb-applet-cards-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "${bindir} ${datadir}/applications ${datadir}/pixmaps"

do_install_append() {
	install -m 0755 ${WORKDIR}/gpe-applet-cards ${D}${bindir}/gpe-applet-cards
	install -m 0644 ${WORKDIR}/cf_mount.png ${D}${datadir}/pixmaps/cf_mount.png
	install -m 0644 ${WORKDIR}/cf_unmount.png ${D}${datadir}/pixmaps/cf_unmount.png
	install -m 0644 ${WORKDIR}/sd_mount.png ${D}${datadir}/pixmaps/sd_mount.png
	install -m 0644 ${WORKDIR}/sd_unmount.png ${D}${datadir}/pixmaps/sd_unmount.png
	install -m 0644 ${WORKDIR}/cards.png ${D}${datadir}/pixmaps/cards.png
}
