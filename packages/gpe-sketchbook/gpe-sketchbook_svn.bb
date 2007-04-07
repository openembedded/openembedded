DESCRIPTION = "A GPE notebook to sketch your notes"
SECTION = "gpe"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libgpewidget"
PV = "0.2.9+svn-${SRCDATE}"

inherit pkgconfig autotools

SRC_URI = "${GPE_SVN} \
	   file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

do_compile () {
        oe_runmake PREFIX=${prefix}
        oe_runmake all-desktop PREFIX=${prefix}
}
do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"

export CVSBUILD = "no"

CFLAGS += "-D_GNU_SOURCE"

DEFAULT_PREFERENCE = "-1"

