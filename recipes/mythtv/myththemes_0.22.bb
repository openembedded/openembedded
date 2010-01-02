DEPENDS = "mythtv"
inherit qmake2

PV = "0.22"
PR = "r0"

FILES_${PN} =+ "${datadir}"

SRC_URI = "ftp://ftp.osuosl.org/pub/mythtv/myththemes-0.22.tar.bz2"

S = "${WORKDIR}/myththemes-0.22"

do_configure() {
        ${S}/configure  --qmake=qmake2 --sysroot=${STAGING_DIR_HOST} --prefix=${prefix} 
}

do_install () {
        oe_runmake install INSTALL_ROOT=${D}
}

