DESCRIPTION = "Hildon widget library"
LICENSE = "LGPL"

DEPENDS = "gconf-dbus esound gtk+"

PV = "1.0.17+svnr${SRCREV}"

SRC_URI = "svn://stage.maemo.org/svn/maemo/projects/haf/trunk;module=hildon-1;proto=https \
           file://buttonbox.patch;patch=1;maxrev=14173 "
S = "${WORKDIR}/hildon-1"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--with-maemo-gtk=no"


do_stage() {
        autotools_stage_all
}

