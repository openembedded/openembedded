DESCRIPTION = "Themes for mythtv: a full featured personal video recorder system."
HOMEPAGE = "http://www.mythtv.org"
LICENSE = "GPLv2"

DEPENDS = "mythtv"
inherit qmake2

PR = "svnr${SRCPV}+r0"
PV = "0.23"

SRCREV = "27202"
SRC_URI = \
"svn://svn.mythtv.org/svn/branches/release-0-23-fixes;module=myththemes;proto=http"

FILES_${PN} =+ "${datadir}"

S = "${WORKDIR}/myththemes"

do_configure() {
        ${S}/configure  --qmake=qmake2 --sysroot=${STAGING_DIR_HOST} --prefix=${prefix} 
}

do_install () {
        oe_runmake install INSTALL_ROOT=${D}
}

