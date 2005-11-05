PR = "r2"

DESCRIPTION = "A helpviewer based on gtk+webcore"
LICENSE = "GPL"

SRC_URI = "http://stag.mind.be/gpe-helpviewer-${PV}.tar.bz2"

DEPENDS = "osb-nrcit"
RDEPENDS = "gpe-helpviewer-doc"


S = "${WORKDIR}/gpe-helpviewer"

inherit autotools

do_install() {
		install -d ${D}${docdir}/gpe
		install -m 0644 ${S}/gpe-helpviewer.html  ${D}${docdir}/gpe/
		install -d ${D}/usr/share/applications
		install -m 0644 ${S}/gpe-helpviewer.desktop ${D}/usr/share/applications/gpe-helpviewer.desktop
		install -d ${D}/usr/share/pixmaps
		install -m 0644 ${S}/gpe-help.png ${D}/usr/share/pixmaps/gpe-help.png
		autotools_do_install
}

pkg_postinst_${PN}-doc () {
        #!/bin/sh
	if [ "x$D" != "x" ]; then
        if [ -e /etc/gpe/gpe-help.conf ]; then
                echo gpe-helpviewer = /usr/share/doc/gpe/gpe-helpviewer.html >> /etc/gpe/gpe-help.conf
        else
                 echo [Help] >> /etc/gpe/gpe-help.conf
                 echo gpe-helpviewer = /usr/share/doc/gpe/gpe-helpviewer.html >> /etc/gpe/gpe-help.conf
        fi
        if [ -x /usr/bin/gpe-helpindex ]; then
                echo generating help-index
                gpe-helpindex
        else
                echo not generating index for gpe-helpviewer
        fi
	fi
}

pkg_postrm_${PN}-doc () {
        #!/bin/sh
	if [ "x$D" != "x" ]; then
        if [ -e /etc/gpe/gpe-help.conf ]; then
                sed '/^\<gpe-helpviewer\>/d' /etc/gpe/gpe-help.conf > /tmp/gpe-help.conf
                mv /tmp/gpe-help.conf /etc/gpe/gpe-help.conf
        fi
        if [ -x /usr/bin/gpe-helpindex ]; then
                echo generating help-index
                gpe-helpindex
        else
                echo not generating index for gpe-helpviewer
        fi
	fi
}

