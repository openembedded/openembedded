DESCRIPTION = "orrery"
SECTION = "x11/scientific"
PV = "2.4"

inherit autotools

SRC_URI = "http://projects.openmoko.org/frs/download.php/581/orrery_2.4_clean.tar.gz \
           file://datadir.patch;patch=1 \
           file://Makefile.am.patch;patch=1"
S = "${WORKDIR}/files"

do_install_append() {
		    install -d ${D}${datadir}/applications
		    install -m 0644 ${S}/orrery.desktop ${D}${datadir}/applications
		    install -d ${D}${datadir}/orrery
		    cp -a ${S}/data/* ${D}${datadir}/orrery
		    rm ${D}${datadir}/orrery/icons/orrery.png
		    install -d ${D}${datadir}/icons
		    install ${S}/data/icons/orrery.png ${D}${datadir}/icons
}

FILES_${PN} += "\
	    ${datadir}/applications/orrery.desktop \
	    ${datadir}/orrery \
	    ${datadir}/icons"

