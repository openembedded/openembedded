DEPENDS = "sqlite gettext gtk+ glib-2.0 osb-nrcit libgpewidget"
RRECOMMENDS = "gdk-pixbuf-loader-gif gdk-pixbuf-loader-png gdk-pixbuf-loader-jpeg"

SRCREV = "9900"
PV = "0.20+svn${SRCDATE}"
PR = "r0"

inherit autotools

SRC_URI = "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/gpe-mini-browser"

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

require gpe-mini-browser.inc

#DEFAULT_PREFERENCE = "-1"
