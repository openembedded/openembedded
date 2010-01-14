DEPENDS = "mythtv"
inherit qmake2

PR = "svnr${SRCPV}+r0"
PV = "0.22"

SRCREV = "23062"
SRC_URI = \
"svn://svn.mythtv.org/svn/branches/release-0-22-fixes;module=mythtvthemes;proto=http"

FILES_${PN} =+ "${datadir}"

S = "${WORKDIR}/myththemes-0.22"

do_configure() {
        ${S}/configure  --qmake=qmake2 --sysroot=${STAGING_DIR_HOST} --prefix=${prefix} 
}

do_install () {
        oe_runmake install INSTALL_ROOT=${D}
}

