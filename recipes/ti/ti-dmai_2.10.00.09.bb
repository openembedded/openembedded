require ti-dmai.inc

PV = "2_10_00_09"
PR = "r3"
 
COMPATIBLE_MACHINE = "(dm365-evm|dm355-evm|dm6467-evm)"

SRC_URI_append = "file://doxygen_templates.tar.gz \
                  file://arago-tdox"

SRCREV         = "443"
DMAIBRANCH     = "branches/GITPSP_INT_101009"

do_install_prepend () {
    find ${S} -name .svn -type d | xargs rm -rf
    cp -pPrf ${WORKDIR}/doxygen_templates ${S}
    cp -pPrf ${WORKDIR}/arago-tdox ${S}/tdox
    chmod a+x ${S}/release.sh
    chmod a+x ${S}/tdox
    ${S}/release.sh ${PV}
}
