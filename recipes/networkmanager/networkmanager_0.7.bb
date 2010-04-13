require networkmanager-0.7.inc

PV = "0.7"
PR = "r10"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/NetworkManager/0.7/NetworkManager-0.7.0.tar.bz2 \
	file://remove-gtk-doc-make.patch;patch=1 \
	file://008-BACKEND-debian-fallback-to-generic-loopback.loom.patch;patch=1 \
	file://02-dbus_access_network_manager.patch;patch=1 \
	file://add_probe_for_v250_modems.patch;patch=1 \
	file://cx3110_bring_up.patch;patch=1 \
	file://nm-system-settings.conf \
	file://NetworkManager \
"

SRC_URI_append_mamona += " file://disable_wireless_by_default.patch;patch=1 "

S = "${WORKDIR}/NetworkManager-0.7.0"

do_install_append () {
        install -d ${D}/etc/NetworkManager/
        install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}/etc/NetworkManager/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d
}


SRC_URI[md5sum] = "64f780e7f95c252eaaed0201c3d9a4ca"
SRC_URI[sha256sum] = "281234116b99b4c4b45fde038a435a0d26b7ee55beac0c351186b3f12c301659"
