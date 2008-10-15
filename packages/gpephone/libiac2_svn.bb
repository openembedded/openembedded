DESCRIPTION = "LiPS IPC library."
SECTION = "gpe/libs"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ gtk-doc dbus-glib"
PV = "0.0+svnr-${SRCREV}"
PR = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN} \
           file://disable-tests.patch;patch=1;pnum=0"

EXTRA_OECONF = "--enable-gui --enable-test=no  --with-cuint=no"

S = ${WORKDIR}/${PN}

do_stage () {
        autotools_stage_all
}
