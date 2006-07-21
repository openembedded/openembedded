#
# Populated ${STAGING} using packages
#
# To use it add that line to conf/local.conf:
#
# INHERIT += "packaged-staging"
#


# BUGS:
# * no state saving mechanism is present, so a failed do stage has pstage/ and staging/ swapped
# * doesn't check for existing packages
# * does not distinguish between -native, -cross and other packages
# * is oblivious to CROSSDIR  
# * breaks when a recipe needs stuff from STAGING_DIR to be present during do_stage, broken behaviour IMO

# Summary:
# This class will have two modes of operation:
# LEETVARNAME1: repopulated staging from scratch for each packages
# LEETVARNAME2: append each package to staging

DEPLOY_DIR_PSTAGE 	= "${DEPLOY_DIR}/pstage" 

PSTAGE_BUILD_CMD        = "${IPKGBUILDCMD}"
PSTAGE_INSTALL_CMD      = "ipkg-cl install -f ${DEPLOY_DIR_PSTAGE}/ipkg.conf -force-depends -o "
PSTAGE_PKGNAME 		= "staging-${PN}_${PV}-${PR}_${PACKAGE_ARCH}.ipk"

do_clean_append() {
        """clear the build and temp directories"""
        stagepkg = bb.data.expand("${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}", d)
        if stagepkg == '//': raise bb.build.FuncFailed("wrong DATADIR")
        bb.note("removing " + stagepkg)
        os.system('rm -rf ' + stagepkg)
}


do_stage_prepend() {
#move away the staging dir to avoid relocation troubles

if [ -e ${STAGING_DIR}/pkgmaps/${P}-${PR}.spawn ]; then
        oenote "List of spawned packages found: ${P}.spawn"
        for spawn in `cat ${STAGING_DIR}/${P}-${PR}.spawn | grep -v ${PN}-locale` 
                do ${PSTAGE_INSTALL_CMD} ${STAGING_DIR}  ${DEPLOY_DIR_IPK}/${spawn}_${PV}-${PR}_${PACKAGE_ARCH}.ipk         
        done
        exit 0
fi


if [ -e ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME} ]; then
	oenote "Staging stuff already packaged, using that instead"
	${PSTAGE_INSTALL_CMD} ${STAGING_DIR}  ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}
	exit 0      
fi

mv ${STAGING_DIR} ${TMPDIR}/pstage

mkdir -p ${STAGING_BINDIR}
mkdir -p ${STAGING_LIBDIR}
mkdir -p ${STAGING_INCDIR}
mkdir -p ${STAGING_DATADIR}/aclocal

}

do_stage_append() {

mkdir -p ${DEPLOY_DIR_PSTAGE}
mkdir -p ${STAGING_DIR}/CONTROL
echo "Package: staging-${PN}"           >  ${STAGING_DIR}/CONTROL/control
echo "Version: ${PV}-${PR}"             >> ${STAGING_DIR}/CONTROL/control
echo "Description: ${DESCRIPTION}"      >> ${STAGING_DIR}/CONTROL/control
echo "Section: ${SECTION}"              >> ${STAGING_DIR}/CONTROL/control
echo "Priority: Optional"               >> ${STAGING_DIR}/CONTROL/control
echo "Maintainer: ${MAINTAINER}"        >> ${STAGING_DIR}/CONTROL/control
echo "Architecture: ${PACKAGE_ARCH}"    >> ${STAGING_DIR}/CONTROL/control
echo "Source: ${SRC_URI}"               >> ${STAGING_DIR}/CONTROL/control

if [ -e ${DEPLOY_DIR_PSTAGE}/ipkg.conf ]; then
	rm ${DEPLOY_DIR_PSTAGE}/ipkg.conf
fi

ipkgarchs="all any noarch ${TARGET_ARCH} ${IPKG_ARCHS} ${MACHINE}"
    priority=1
    for arch in $ipkgarchs; do
      echo "arch $arch $priority" >> ${DEPLOY_DIR_PSTAGE}/ipkg.conf
      priority=$(expr $priority + 5)
    done



mkdir -p ${DEPLOY_DIR_PSTAGE}


${PSTAGE_BUILD_CMD} ${STAGING_DIR} ${DEPLOY_DIR_PSTAGE}

rm -rf ${STAGING_DIR}
#move back stagingdir so we can install packages   
mv ${TMPDIR}/pstage ${STAGING_DIR}

${PSTAGE_INSTALL_CMD} ${STAGING_DIR}  ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}

}

