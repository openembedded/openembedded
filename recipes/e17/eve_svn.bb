DESCRIPTION = " Enlightenment webbrowser"
LICENSE = "GPL"
DEPENDS = "webkit-efl evas ecore edje"
PV = "0.2.0.0+svnr${SRCPV}"
SRCREV = "${EFL_SRCREV}"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=eve;proto=http \
           file://default.theme.remove.min.size.patch \
"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
"

S = "${WORKDIR}/eve"

FILES_${PN} += "${datadir}/icons/eve.png"
