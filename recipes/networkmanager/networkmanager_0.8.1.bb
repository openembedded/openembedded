require networkmanager-0.7.inc

PR = "r3"

DEFAULT_PREFERENCE = "-1"

SRC_URI += " \
    file://remove-gtk-doc-make.patch \
    file://10-dont_require_ifup_for_lo.patch \ 
    file://nm-system-settings.conf \
    file://NetworkManager \
    file://gtk-doc.make \
    file://0001-respect-libnl-flags-also-in-backends-ip6-manager.patch \
"

SRC_URI[md5sum] = "96e551149dda8f6e0a5621f77468ba79"
SRC_URI[sha256sum] = "dc126fbe3199d47899c4781e4fff32cee404dc7c728c6ade9eaa899bd80f19fa"

S = "${WORKDIR}/NetworkManager-${PV}"

EXTRA_OECONF += " --with-dhclient=${base_sbindir}/dhclient \
                  --with-iptables=${sbindir}/iptables \
"

do_configure_prepend() {
    cp ${WORKDIR}/gtk-doc.make ${S}/
    echo "EXTRA_DIST = version.xml" > gnome-doc-utils.make
    sed -i -e 's:man \\:man:' -e s:docs::g ${S}/Makefile.am
    sed -i -e /^docs/d ${S}/configure.ac
}

do_install_append () {
	install -d ${D}/etc/NetworkManager/
	install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}/etc/NetworkManager/NetworkManager.conf
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d
	
	# Install an empty VPN folder as nm-connection-editor will happily segfault without it :o.
	# With or without VPN support built in ;).
	install -d ${D}/etc/NetworkManager/VPN
}

FILES_${PN} += " ${datadir}/polkit-1/"
RRECOMMENDS_${PN} += "iptables"

