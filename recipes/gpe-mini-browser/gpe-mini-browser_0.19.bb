require gpe-mini-browser.inc

SRC_URI = "http://gpe.linuxtogo.org/download/source/gpe-mini-browser-${PV}.tar.gz"
DEPENDS = "osb-nrcit sqlite libgpewidget"
RRECOMMENDS = "gdk-pixbuf-loader-gif gdk-pixbuf-loader-png gdk-pixbuf-loader-jpeg"

PR = "r1"

S = "${WORKDIR}/gpe-mini-browser-${PV}"

inherit autotools

do_install() {
		install -d ${D}/usr/share/applications
		install -m 0644 ${S}/gpe-mini-browser.desktop ${D}/usr/share/applications/gpe-mini-browser.desktop
		install -d ${D}/usr/share/pixmaps
		install -m 0644 ${S}/gpe-mini-browser.png ${D}/usr/share/pixmaps/gpe-mini-browser.png
		autotools_do_install
}

pkg_postinst_${PN}-doc () {
        #!/bin/sh
	if [ "x$D" != "x" ]; then
        if [ -e /etc/gpe/gpe-help.conf ]; then
                echo gpe-mini-browser= /usr/share/doc/gpe/gpe-mini-browser.html >> /etc/gpe/gpe-help.conf
        else
                 echo [Help] >> /etc/gpe/gpe-help.conf
                 echo gpe-mini-browser= /usr/share/doc/gpe/gpe-mini-browser.html >> /etc/gpe/gpe-help.conf
        fi
        if [ -x /usr/bin/gpe-helpindex ]; then
                echo generating help-index
                gpe-helpindex
        else
                echo not generating index for gpe-mini-browser
        fi
	fi
}

pkg_postrm_${PN}-doc () {
        #!/bin/sh
        if [ -e /etc/gpe/gpe-help.conf ]; then
                sed '/^\<gpe-mini-browser\>/d' /etc/gpe/gpe-help.conf > /tmp/gpe-help.conf
                mv /tmp/gpe-help.conf /etc/gpe/gpe-help.conf
        fi
        if [ -x /usr/bin/gpe-helpindex ]; then
                echo generating help-index
                gpe-helpindex
        else
                echo not generating index for gpe-mini-browser
        fi
}


SRC_URI[md5sum] = "922640f40f67d15892d9ea8ec6c8ffea"
SRC_URI[sha256sum] = "ece034b916a7760cfb854baab474b7931246bdb078c814366bf90a9fbff246af"
