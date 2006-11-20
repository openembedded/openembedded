#
# Populated ${STAGING} using packages
#
# To use it add that line to conf/local.conf:
#
# INHERIT += "packaged-staging"
#
# You also need ipkg-cl and ipkg-make-index installed on your host
# put ipkg-build from org.openembedded.packaged-staging/contrib/ in your $PATH

# BUGS:
# * does not distinguish between -native, -cross and other packages

# TODO:
# * also build a feed for native and cross packages 
# * make package detection a bit smarter (search for compatible archs)
# * make do_clean clean staging as well

# Summary:
# This class will have two modes of operation:
# PSTAGE_MODE = 'repopulate': repopulated staging from scratch for each packages
# PSTAGE_MODE = 'append': append each package to staging (current behaviour)

inherit package

DEPENDS = "stagemanager-native"

DEPLOY_DIR_PSTAGE 	= "${DEPLOY_DIR}/pstage" 

PSTAGE_BUILD_CMD        = "${IPKGBUILDCMD}"
PSTAGE_INSTALL_CMD      = "ipkg-cl install -force-depends -f ${DEPLOY_DIR_PSTAGE}/ipkg.conf -o "
PSTAGE_UPDATE_CMD	= "ipkg-cl update -f ${DEPLOY_DIR_PSTAGE}/ipkg.conf -o "
PSTAGE_LIST_CMD		= "ipkg-cl list_installed -f ${DEPLOY_DIR_PSTAGE}/ipkg.conf -o "
PSTAGE_PKGNAME 		= "staging-${PN}_${PV}-${PR}_${PACKAGE_ARCH}.ipk"
PCROSS_PKGNAME		= "cross-${PN}_${PV}-${PR}_${BUILD_ARCH}.ipk"

SPAWNFILE 		= "${STAGING_DIR}/pkgmaps/${P}-${PR}.spawn"
SPAWNIPK                = "${spawn}"

PSTAGE_TMPDIR_STAGE     = "${TMPDIR}/tmp-staging"
PSTAGE_TMPDIR_CROSS     = "${TMPDIR}/tmp-cross"

STAGING_BASEDIR		= "${STAGING_LIBDIR}/.."

PACKAGEFUNCS += "do_write_ipk_list"

python do_write_ipk_list () {
        import os, sys
        ipkdir = bb.data.getVar('DEPLOY_DIR_IPK', d, 1)
        stagingdir = bb.data.getVar('STAGING_DIR', d, 1)
        tmpdir = bb.data.getVar('TMPDIR', d, 1)
        p = bb.data.getVar('P', d, 1)
        pr = bb.data.getVar('PR', d, 1)

        packages = bb.data.getVar('PACKAGES', d, 1)
        if not packages:
                bb.debug(1, "PACKAGES not defined, nothing to package")
                return

        if packages == []:
                bb.debug(1, "No packages; nothing to do")
                return

        # Generate ipk.conf if it or the stamp doesnt exist
        listfile = os.path.join(stagingdir,"pkgmaps","%s-%s.spawn" %  ( p , pr ))
        os.system('mkdir -p ' + stagingdir + '/pkgmaps')
        if not os.access(listfile, os.R_OK):
                os.system('rm -f ' + listfile)
                f = open(listfile,"w")
                for spawn in packages.split():
                        #check if the packagename has changed due to debian shlib renaming
                        localdata = bb.data.createCopy(d)
                        pkgname = bb.data.getVar('PKG_%s' % spawn, localdata, 1)
                        if not pkgname:
                                pkgname = spawn
                        f.write("%s\n" % pkgname)
                f.close()
}


do_clean_append() {
	"""clear the build and temp directories"""
        stagepkg = bb.data.expand("${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}", d)
        if stagepkg == '//': raise bb.build.FuncFailed("wrong DATADIR")
        bb.note("removing " + stagepkg)
        os.system('rm -rf ' + stagepkg)
}


do_stage_prepend() {

	stage-manager -p ${STAGING_DIR} -c ${DEPLOY_DIR_PSTAGE}/staging-stamp-cache -u

	stage-manager -p ${CROSS_DIR} -c ${DEPLOY_DIR_PSTAGE}/cross-stamp-cache -u

	if [ ! -e ${STAGING_BASEDIR} ]; then
		mkdir -p ${STAGING_BASEDIR}
	fi

	if [ ! -e ${DEPLOY_DIR_PSTAGE} ]; then
		mkdir -p ${DEPLOY_DIR_PSTAGE}
	fi

	if [ -e ${STAGING_BASEDIR}/usr ]; then
	        oenote "${STAGING_BASEDIR}/usr already present, leaving it alone"
	else
		oenote "${STAGING_BASEDIR}/usr not present, symlinking it"
		ln -s ${STAGING_BASEDIR}/ ${STAGING_BASEDIR}/usr
	fi

	#assemble appropriate ipkg.conf
	if [ -e ${DEPLOY_DIR_PSTAGE}/ipkg.conf ]; then
	        rm ${DEPLOY_DIR_PSTAGE}/ipkg.conf
	fi

	ipkgarchs="${BUILD_ARCH} all any noarch ${TARGET_ARCH} ${PACKAGE_ARCHS} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}"
	priority=1
	for arch in $ipkgarchs; do
		echo "arch $arch $priority" >> ${DEPLOY_DIR_PSTAGE}/ipkg.conf
		priority=$(expr $priority + 5)
	done
	echo "src oe file:${DEPLOY_DIR_IPK}" >> ${DEPLOY_DIR_PSTAGE}/ipkg.conf 
	export OLD_PWD=`pwd`
	cd ${DEPLOY_DIR_IPK} && rm *${BUILD_ARCH}.ipk -f ; ipkg-make-index -p Packages . ; cd ${OLD_PWD}
	${PSTAGE_UPDATE_CMD} ${STAGING_BASEDIR}

	#check for generated packages
	if [ -e ${SPAWNFILE} ]; then
        	oenote "List of spawned packages found: ${P}.spawn"
        	for spawn in `cat ${SPAWNFILE} | grep -v locale | grep -v dbg | grep -v gconv | grep -v charmap` ; do \
			if [ -e ${DEPLOY_DIR_IPK}/${spawn}_* ]; then
               	 		${PSTAGE_INSTALL_CMD} ${STAGING_BASEDIR} ${spawn}          
				# clean up .la files to avoid having references to the builddirs in the binaries
				for lafile in ${STAGING_LIBDIR}/*.la ; do \
					sed -i s:installed=yes:installed=no:g ${lafile} || true
				done

				#fix up linker script to poin to staging
				if [ -e ${STAGING_LIBDIR}/libc.so ]; then
					sed -i s:\ /lib:\ ${STAGING_LIBDIR}:g ${STAGING_LIBDIR}/libc.so
					sed -i s:\ /usr/lib:\ ${STAGING_LIBDIR}:g ${STAGING_LIBDIR}/libc.so
				fi
			else
				oenote "${spawn} not found, probably empty package"
			fi
        	done
        	exit 0
	else
		oenote "Spawn file not found!"
	fi

        if [ -e ${DEPLOY_DIR_PSTAGE}/${PCROSS_PKGNAME} ]; then
                oenote "Cross stuff already packaged, using that instead"
                ${PSTAGE_INSTALL_CMD} ${CROSS_DIR}  ${DEPLOY_DIR_PSTAGE}/${PCROSS_PKGNAME}
        fi

	if [ -e ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME} ]; then
		oenote "Staging stuff already packaged, using that instead"
		${PSTAGE_INSTALL_CMD} ${STAGING_DIR}  ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}
		exit 0      
	fi


	mkdir -p ${STAGING_BINDIR}
	mkdir -p ${STAGING_LIBDIR}
	mkdir -p ${STAGING_INCDIR}
	mkdir -p ${STAGING_DATADIR}/aclocal
}

do_stage_append() {

	mkdir -p ${DEPLOY_DIR_PSTAGE}

	# list the packages currently installed in staging
	${PSTAGE_LIST_CMD} ${STAGING_DIR} | awk '{print $1}' > ${DEPLOY_DIR_PSTAGE}/installed-staging_list         
	${PSTAGE_LIST_CMD} ${CROSS_DIR} | awk '{print $1}' > ${DEPLOY_DIR_PSTAGE}/installed-cross_list

	set +e
	rm -rf ${PSTAGE_TMPDIR_STAGE}
	stage-manager -p ${STAGING_DIR} -c ${DEPLOY_DIR_PSTAGE}/staging-stamp-cache -u -d ${PSTAGE_TMPDIR_STAGE}
	rc=$?
	set -e

	if [ $rc == 5 ]; then

		#make a package for staging
		mkdir -p ${PSTAGE_TMPDIR_STAGE}/CONTROL

		echo "Package: staging-${PN}"           >  ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Version: ${PV}-${PR}"             >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Description: ${DESCRIPTION}"      >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Section: ${SECTION}"              >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Priority: Optional"               >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Maintainer: ${MAINTAINER}"        >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Architecture: ${PACKAGE_ARCH}"    >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
		echo "Source: ${SRC_URI}"               >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control

	        ${PSTAGE_BUILD_CMD} ${PSTAGE_TMPDIR_STAGE} ${DEPLOY_DIR_PSTAGE}

		${PSTAGE_INSTALL_CMD} ${STAGING_DIR} ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}
	fi

	set +e
	rm -rf ${PSTAGE_TMPDIR_CROSS}
	stage-manager -p ${CROSS_DIR} -c ${DEPLOY_DIR_PSTAGE}/cross-stamp-cache -u -d ${PSTAGE_TMPDIR_CROSS}
	rc=$?
	set -e

	if [ $rc == 5 ]; then

		#make a package for cross
	        mkdir -p ${PSTAGE_TMPDIR_CROSS}/CONTROL

	        echo "Package: cross-${PN}"           	>  ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Version: ${PV}-${PR}"             >> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Description: ${DESCRIPTION}"      >> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Section: ${SECTION}"              >> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Priority: Optional"               >> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Maintainer: ${MAINTAINER}"        >> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Architecture: ${BUILD_ARCH}"    	>> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	        echo "Source: ${SRC_URI}"               >> ${PSTAGE_TMPDIR_CROSS}/CONTROL/control
	
		${PSTAGE_BUILD_CMD} ${PSTAGE_TMPDIR_CROSS} ${DEPLOY_DIR_PSTAGE}

		${PSTAGE_INSTALL_CMD} ${CROSS_DIR} ${DEPLOY_DIR_PSTAGE}/${PCROSS_PKGNAME}
	fi
}

