DESCRIPTION = "A GPE notebook to sketch your notes"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libgpewidget sqlite"
PV = "0.2.9+svnr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

inherit pkgconfig autotools

SRC_URI = "\
  ${GPE_SVN} \
  file://svn-build.patch;patch=1 \
"
S = "${WORKDIR}/${PN}"

export CVSBUILD = "no"
CFLAGS += "-D_GNU_SOURCE"

do_compile () {
        oe_runmake PREFIX=${prefix}
        oe_runmake all-desktop PREFIX=${prefix}
}
do_install () {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install-program
}

FILES_${PN} = "${bindir} ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += " ${datadir}/gpe/pixmaps"
