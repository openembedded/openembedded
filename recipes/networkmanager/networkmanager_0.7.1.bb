require networkmanager-0.7.inc

PR = "r1"

SRC_URI += " \
	file://remove-gtk-doc-make.patch;patch=1 \
	file://008-BACKEND-debian-fallback-to-generic-loopback.loom.patch;patch=1 \
	file://02-dbus_access_network_manager.patch;patch=1 \
	file://cx3110_bring_up.patch;patch=1 \
	file://nm-system-settings.conf \
	file://NetworkManager \
"

S = "${WORKDIR}/NetworkManager-${PV}"

do_install_append () {
	install -d ${D}/etc/NetworkManager/
	install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}/etc/NetworkManager/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d
}


SRC_URI[md5sum] = "954742cfd47191204d62d8d57f2bc6dd"
SRC_URI[sha256sum] = "7526a31de615a662cb09e915f26e5b151eda364240d983df6232aac8b9333f3a"
