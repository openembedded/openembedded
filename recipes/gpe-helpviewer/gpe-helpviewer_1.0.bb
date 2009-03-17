DESCRIPTION = "A helpviewer based on gtk+webcore"
LICENSE = "GPL"
DEPENDS = "osb-nrcit"
RDEPENDS = "gpe-helpviewer-doc"
PR = "r2"

SRC_URI = "http://stag.mind.be/gpe-helpviewer-${PV}.tar.bz2"

S = "${WORKDIR}/gpe-helpviewer"

inherit autotools

do_install() {
		install -d ${D}${docdir}/gpe
		install -m 0644 ${S}/gpe-helpviewer.html  ${D}${docdir}/gpe/
		install -d ${D}${datadir}/applications
		install -m 0644 ${S}/gpe-helpviewer.desktop ${D}${datadir}/applications/gpe-helpviewer.desktop
		install -d ${D}${datadir}/pixmaps
		install -m 0644 ${S}/gpe-help.png ${D}${datadir}/pixmaps/gpe-help.png
		autotools_do_install
}

pkg_postinst_${PN}-doc () {
        #!/bin/sh
	if [ "x$D" != "x" ]; then
        if [ -e ${sysconfdir}/gpe/gpe-help.conf ]; then
                echo gpe-helpviewer = ${docdir}/gpe/gpe-helpviewer.html >> ${sysconfdir}/gpe/gpe-help.conf
        else
                 echo [Help] >> ${sysconfdir}/gpe/gpe-help.conf
                 echo gpe-helpviewer = ${docdir}/gpe/gpe-helpviewer.html >> ${sysconfdir}/gpe/gpe-help.conf
        fi
        if [ -x ${bindir}/gpe-helpindex ]; then
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
        if [ -e ${sysconfdir}/gpe/gpe-help.conf ]; then
                sed '/^\<gpe-helpviewer\>/d' ${sysconfdir}/gpe/gpe-help.conf > /tmp/gpe-help.conf
                mv /tmp/gpe-help.conf ${sysconfdir}/gpe/gpe-help.conf
        fi
        if [ -x ${bindir}/gpe-helpindex ]; then
                echo generating help-index
                gpe-helpindex
        else
                echo not generating index for gpe-helpviewer
        fi
	fi
}

