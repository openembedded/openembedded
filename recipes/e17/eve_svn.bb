DESCRIPTION = " Enlightenment Web Browser"
LICENSE = "GPL"
DEPENDS = "evas ecore edje elementary webkit-efl"
PR = "r1"
PV = "0.3.0.0+svnr${SRCPV}"
SRCREV = "${EFL_SRCREV}"

inherit e

SRC_URI = "\
           svn://svn.enlightenment.org/svn/e/trunk;module=eve;proto=http \
           file://default.theme.remove.min.size.patch \
"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
"

FILES_${PN} += "\
        ${datadir}/icons/eve.png \
"
