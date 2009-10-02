require networkmanager-0.7.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "b9c125fa0a2a9878d9ac0f6140f14f436ddb1723"
PV = "0.7.1+git"
PR_append = ".gitr${SRCREV}"

inherit gnome

SRC_URI = "git://anongit.freedesktop.org/NetworkManager/NetworkManager;protocol=git;branch=NETWORKMANAGER_0_7 \
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

S = "${WORKDIR}/git"

do_install_append () {
	install -d ${D}/etc/NetworkManager/
	install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}/etc/NetworkManager/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d
}

