require networkmanager-0.7.inc

PR = "r1"

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


S = "${WORKDIR}/NetworkManager-${PV}"

do_install_append () {
	install -d ${D}/etc/NetworkManager/
	install -m 0644 ${WORKDIR}/nm-system-settings.conf ${D}/etc/NetworkManager/
	install -m 0755 ${WORKDIR}/NetworkManager ${D}/etc/init.d
	
	# Install an empty VPN folder as nm-connection-editor will happily segfault without it :o.
	# With or without VPN support built in ;).
	install -d ${D}/etc/NetworkManager/VPN
}


SRC_URI[md5sum] = "12f12b2586043c21c3508b05e7994ba2"
SRC_URI[sha256sum] = "a62a0f45d156cb190dd2ee3176aa3af4bf7b35c23a09ac65a309c9dc5af87826"
