require networkmanager-0.7.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "9b61ec7c58e8106c28d01b33ad0b263aefb1f347"
PV = "0.8.2+git"
PR_append = ".gitr${SRCREV}"

inherit gnome

SRC_URI = "git://anongit.freedesktop.org/NetworkManager/NetworkManager;protocol=git;branch=NM_0_8"

S = "${WORKDIR}/git"

SRC_URI += " \
    file://remove-gtk-doc-make.patch \
    file://nm-system-settings.conf \
    file://NetworkManager \
    file://gtk-doc.make \
"

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

