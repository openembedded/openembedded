DESCRIPTION = "Convenient scripts to be used with openmoko toolchain."

PV = "0.0+svnr${SRCPV}"
PE = "1"
PR = "r1"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host;module=toolchain-scripts;proto=http"

S = "${WORKDIR}/toolchain-scripts"

do_install () {
        install -d ${D}/${prefix}
        cp -dr ${S}/* ${D}/${prefix}
        find ${D} -name ".svn" | xargs rm -rf
        rm -rf ${D}/${prefix}/patches
}

PACKAGE_ARCH = "all"

FILES_${PN} = "/*"

inherit sdk
