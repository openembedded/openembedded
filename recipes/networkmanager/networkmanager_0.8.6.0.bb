require networkmanager-0.7.inc

PR = "r0"
DEFAULT_PREFERENCE = "-1"

SRC_URI += "http://ftp.gnome.org/pub/GNOME/sources/NetworkManager/0.8/NetworkManager-${PV}.tar.bz2 \
    file://remove-gtk-doc-make.patch \
    file://nm-system-settings.conf \
    file://NetworkManager \
    file://gtk-doc.make \
"

SRC_URI[md5sum] = "dc5766f81a98e76faf2d2a29eed4cee7"
SRC_URI[sha256sum] = "e382d3c123099c701045b9e56a021eb664171ece9a7ae1f2c31ee05b7d4f3a67"

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

