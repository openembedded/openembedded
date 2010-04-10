DEPENDS = "libgpewidget sqlite"
LICENSE = "GPL"
DESCRIPTION = "A GPE notebook to sketch your notes"
export CVSBUILD = "no"

inherit gpe pkgconfig

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

SRC_URI[md5sum] = "72d9e5468cf1a53b66a378ee2e85dc1a"
SRC_URI[sha256sum] = "6335c48b8cf61ad49d01470354fa9e2a9ec072871cd9fbbdfd872461d012359a"
