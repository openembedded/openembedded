DEPENDS = "mythtv"
inherit qmake2

PR = "svnr${SRCPV}+r2"
PV = "0.22"

SRCREV = "23565"
SRC_URI = \
"svn://svn.mythtv.org/svn/branches/release-0-22-fixes;module=myththemes;proto=http"

FILES_${PN} =+ "${datadir}"

S = "${WORKDIR}/myththemes"

do_configure() {
        ${S}/configure  --qmake=qmake2 --sysroot=${STAGING_DIR_HOST} --prefix=${prefix} 
}

do_install () {
        oe_runmake install INSTALL_ROOT=${D}
}

