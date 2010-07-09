DESCRIPTION = "Linux driver examples/test applications"
HOMEPAGE = "http://arago-project.org/git/projects/?p=examples-davinci.git;a=summary"
LICENSE="BSD"

DEPENDS = "virtual/kernel"

require ti-paths.inc

S = "${WORKDIR}/git"

do_compile () {
	cd ${S}/media_ti
    make KERNEL_PATH=${STAGING_KERNEL_DIR} clean
    make KERNEL_PATH=${STAGING_KERNEL_DIR}/include 
}
do_install () {
  	cd ${S}/media_ti
    make ${TARGET} EXEC_DIR=${D}/${installdir}/linux-driver-examples install
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${installdir}/linux-driver-examples/*"
INSANE_SKIP_${PN} = True

