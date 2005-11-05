LICENSE = "GPL"
PR = "r4"

inherit gpe pkgconfig

DEPENDS = "libgpewidget"
SECTION = "gpe"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
SECTION = "gpe"
PRIORITY = "optional"
DESCRIPTION = "A GPE notebook to sketch your notes"
export CVSBUILD = "no"

CFLAGS +="-D_GNU_SOURCE"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://sketchbook-size.patch;patch=1;pnum=0 \
	   file://remove-render.patch;patch=1"

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"

do_compile () {
        oe_runmake PREFIX=${prefix}
        oe_runmake all-desktop PREFIX=${prefix}
}

do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}
