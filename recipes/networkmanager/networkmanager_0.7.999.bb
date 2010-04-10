require networkmanager-0.7.inc

DEFAULT_PREFERENCE = "-1"

PR = "r3"

SRC_URI += " \
    file://remove-gtk-doc-make.patch;patch=1 \
    file://nm-system-settings.conf \
    file://NetworkManager \
    file://gtk-doc.make \
"


do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
    echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
    sed -i -e 's:man \\:man:' -e s:docs::g ${S}/Makefile.am
    sed -i -e /^docs/d ${S}/configure.ac
}

FILES_${PN} += "  ${datadir}/polkit-1/"

S = "${WORKDIR}/NetworkManager-${PV}"

do_install_append () {
	install -d ${D}/etc/NetworkManager/
	install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}/etc/NetworkManager/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d
	
	# Install an empty VPN folder as nm-connection-editor will happily segfault without it :o.
	# With or without VPN support built in ;).
	install -d ${D}/etc/NetworkManager/VPN
}


SRC_URI[md5sum] = "581cf6ea9ef358df874359cc8cb9af69"
SRC_URI[sha256sum] = "6fa351b3efc78cff4daa1f42386ba8435474bc121b4358a7d08bd7c9fb63aaef"
