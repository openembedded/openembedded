require ti-dmai.inc

PV = "2_20_00_06"
PR = "r2"
 
COMPATIBLE_MACHINE = "dm365-evm"

SRC_URI_append = " \
	file://doxygen_templates.tar.gz \
        file://arago-tdox \
"

SRCREV         = "519"
DMAIBRANCH     = "tags/TAG_2_20_00_06"

do_install_prepend () {
    find ${S} -name .svn -type d | xargs rm -rf
    cp -pPrf ${WORKDIR}/doxygen_templates ${S}
    cp -pPrf ${WORKDIR}/arago-tdox ${S}/tdox
    chmod a+x ${S}/release.sh
    chmod a+x ${S}/tdox
    ${S}/release.sh ${PV}
}

