DESCRIPTION = "EFL based thumbnail generation library"
LICENSE = "LGPL"
DEPENDS = "eet-native evas ecore edje eet edbus emotion epdf"
PV = "0.1.0+svnr${SRCPV}"
SRCREV = "${EFL_SRCREV}"

inherit efl

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=ethumb;proto=http"

# Some upgrade path tweaking, as in evas
AUTO_LIBNAME_PKGS = ""

FILES_${PN} += "\
    ${bindir}/ethumbd \
    ${libexecdir}/ethumbd_slave \
    ${libdir}/plugins/*.so \
    ${libdir}/plugins/data/*.edj \
"
