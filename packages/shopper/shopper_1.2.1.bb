DESCRIPTION = "Shopping list manager"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/zaurus-shopper/Shopper-${PV}.tar.gz \
           file://gcc3.patch;patch=1 \
           file://path_fix.patch;patch=1"
S = "${WORKDIR}/Shopper"

inherit palmtop

SHOPPER_DATADIR = "${palmtopdir}/share/shopper"
CXXFLAGS_append += " -DSHOPPER_DATADIR='"${SHOPPER_DATADIR}"' "

QMAKE_PROFILES = "Shopper.pro"

pkg_postinst() {
	/opt/QtPalmtop/bin/qcop QPE/System "linkChanged(QString)" 2>/dev/null
	if [ -n "$D" ]; then false; fi
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/help/html \
               ${D}${SHOPPER_DATADIR}
        install -m 0755 ${S}/Shopper ${D}${palmtopdir}/bin/
        install -m 0644 ${S}/Shopper.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/Shopper.png ${D}${palmtopdir}/pics/
        install -m 0644 ${S}/Shopper.html ${D}${palmtopdir}/help/html/
        install -m 0644 ${S}/shoppinglist.xml ${D}${SHOPPER_DATADIR}/shoppinglist.xml
}
