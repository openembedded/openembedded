DESCRIPTION = "Epdf is the glue between EFL and libpoppler"
LICENSE = "MIT BSD"
DEPENDS = "poppler evas ecore"
PV = "0.1.0+svnr${SRCPV}"
PR = "r4"
SRCREV = "${EFL_SRCREV}"

inherit efl

EXTRA_OECONF = "\
    --enable-poppler \
    --disable-ewl \
    --disable-mupdf \
"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/PROTO;module=epdf;proto=http;scmdata=keep"

# Some upgrade path tweaking, as in evas
AUTO_LIBNAME_PKGS = ""

