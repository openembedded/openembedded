require networkmanager-0.7.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"
DEFAULT_PREFERENCE_shr = "1"

SRCREV = "0.8.3.999"
PV = "0.8.3.999"
#PR_append = ".gitr${SRCREV}"

inherit gnome

SRC_URI = "git://anongit.freedesktop.org/NetworkManager/NetworkManager;protocol=git;branch=NM_0_8"

S = "${WORKDIR}/git"

SRC_URI += " \
    file://remove-gtk-doc-make.patch \
    file://nm-system-settings.conf \
    file://NetworkManager \
    file://gtk-doc.make \
    file://0001-respect-libnl-flags-also-in-backends-ip6-manager.patch \
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

