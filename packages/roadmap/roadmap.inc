DESCRIPTION = "RoadMap is a program that provides car navigation for Linux and UNIX." 
PRIORITY = "optional"
AUTHOR = "Pascal Martin <pascal.martin@iname.com>"
HOMEPAGE = "http://roadmap.digitalomaha.net/maps.html"
LICENSE = "GPL"
RRECOMMENDS = "gpsd flite"
DEPENDS = "expat"

FILES_${PN} += "${datadir}/roadmap"

do_compile() {
        oe_runmake runtime ${TOOLS} icons
}

do_install() {
        oe_runmake install
        install -m 0644 ${WORKDIR}/usdir.rdm ${D}${datadir}/roadmap/
}
