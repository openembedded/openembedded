DESCRIPTION = "Astronomical application which displays the night sky"
HOMEPAGE    = "http://projects.openmoko.org/projects/orrery/"
SECTION = "x11/scientific"
PV = "2.7"
PR = "r0"
inherit autotools

SRC_URI = "http://projects.openmoko.org/frs/download.php/923/orrery_2.7_clean.tar.gz;name=tarball \
           file://orrery.png \
          "

SRC_URI[tarball.md5sum]    = "bd62a33e7554ee1030313dfcdefcda8b"
SRC_URI[tarball.sha256sum] = "645166a5e05b2064ab630534a514697fc47b681951e7fe1d635c259cbdf7a5e6"
S = "${WORKDIR}/orrery"

do_install_append() {
		    install -d ${D}${datadir}/orrery
		    cp -a ${S}/data/* ${D}${datadir}/orrery
		    install -d ${D}${datadir}/icons
		    install -m 0755 ${WORKDIR}/orrery.png ${D}${datadir}/icons
}

FILES_${PN} += "\
	    ${datadir}/icons/orrery.png"

