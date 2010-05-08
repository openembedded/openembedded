require ti-dmai.inc

PV = "2_10_00_10"
PR = "r2"
 
COMPATIBLE_MACHINE = "(dm365-evm|dm355-evm|dm6467-evm)"

SRC_URI_append = "file://0001-Correct-DMAI-s-Resize-module-for-DM365.patch;patch=3 \
	file://doxygen_templates.tar.gz \
        file://arago-tdox"

SRCREV         = "452"
DMAIBRANCH     = "branches/GITPSP_INT_101009"

do_install_prepend () {
    find ${S} -name .svn -type d | xargs rm -rf
    cp -pPrf ${WORKDIR}/doxygen_templates ${S}
    cp -pPrf ${WORKDIR}/arago-tdox ${S}/tdox
    chmod a+x ${S}/release.sh
    chmod a+x ${S}/tdox
    ${S}/release.sh ${PV}
}
