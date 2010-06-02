DESCRIPTION = "RoadMap is a program that provides car navigation for Linux and UNIX." 
AUTHOR = "Paul Fox <pgf@foxharp.boston.ma.us>"
HOMEPAGE = "http://roadmap.digitalomaha.net/maps.html"
LICENSE = "GPL"
DEPENDS = "expat"

FILES_${PN} += "${datadir}/roadmap"

do_compile() {
        oe_runmake runtime ${TOOLS} icons
}

do_install() {
        oe_runmake install
        install -m 0644 ${WORKDIR}/usdir.rdm ${D}${datadir}/roadmap/
}

RRECOMMENDS_${PN} = "gpsd flite"
FILES_${PN} += "${datadir}/roadmap"
