#
# Populate builds using prebuilt packages where possible to speed up builds
# and allow staging to be reconstructed.
#
# To use it add that line to conf/local.conf:
#
# INHERIT = "packaged-staging"

python () {
    import bb
    if not bb.data.inherits_class('native', d) and not bb.data.inherits_class('image', d) and not bb.data.inherits_class('cross', d) and not bb.data.inherits_class('sdk', d):
        deps = bb.data.getVarFlag('do_populate_staging', 'depends', d) or ""
        deps += " stagemanager-native:do_populate_staging"
        bb.data.setVarFlag('do_populate_staging', 'depends', deps, d)

        deps = bb.data.getVarFlag('do_prepackaged_stage', 'depends', d) or ""
        deps += " ipkg-native:do_populate_staging ipkg-utils-native:do_populate_staging"
        bb.data.setVarFlag('do_prepackaged_stage', 'depends', deps, d)
    else:
        bb.data.setVar("PSTAGING_DISABLED", "1", d)
}

export PSTAGING_DISABLED = "0"

DEPLOY_DIR_PSTAGE 	= "${DEPLOY_DIR}/pstage" 

PSTAGE_BUILD_CMD        = "${IPKGBUILDCMD}"
PSTAGE_INSTALL_CMD      = "ipkg-cl install -force-depends -f ${DEPLOY_DIR_PSTAGE}/ipkg-${MACHINE}.conf -o ${TMPDIR}"
PSTAGE_UPDATE_CMD	= "ipkg-cl update -f ${DEPLOY_DIR_PSTAGE}/ipkg-${MACHINE}.conf -o ${TMPDIR}"
PSTAGE_REMOVE_CMD       = "ipkg-cl remove -force-depends -f ${DEPLOY_DIR_PSTAGE}/ipkg-${MACHINE}.conf -o ${TMPDIR}"
PSTAGE_LIST_CMD		= "ipkg-cl list_installed -f ${DEPLOY_DIR_PSTAGE}/ipkg-${MACHINE}.conf -o ${TMPDIR}"
PSTAGE_PKGNAME 		= "staging-${PN}_${PV}-${PR}_${MULTIMACH_ARCH}.ipk"

PSTAGE_TMPDIR_STAGE     = "${WORKDIR}/staging-pkg"

do_clean_append() {
        """
        Clear the build and temp directories
        """
	bb.note("Uninstalling package from staging...")
        path = bb.data.getVar("PATH", d, 1)
	removecmd = bb.data.getVar("PSTAGE_REMOVE_CMD", d, 1)
	removepkg = bb.data.expand("staging-${PN}", d)
        ret = os.system("PATH=\"%s\" %s %s" % (path, removecmd, removepkg))
        if ret != 0:
            bb.note("Failure removing staging package")

        stagepkg = bb.data.expand("${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}", d)
        bb.note("Removing staging package %s" % stagepkg)
        #os.system('rm -rf ' + stagepkg)
}

staging_helper () {
	#assemble appropriate ipkg.conf
	conffile=${DEPLOY_DIR_PSTAGE}/ipkg-${MACHINE}.conf
	mkdir -p ${DEPLOY_DIR_PSTAGE}/pstaging_lists
	if [ ! -e $conffile ]; then
		ipkgarchs="${BUILD_ARCH} all any noarch ${TARGET_ARCH} ${PACKAGE_ARCHS} ${PACKAGE_EXTRA_ARCHS} ${MACHINE}"
		priority=1
		for arch in $ipkgarchs; do
			echo "arch $arch $priority" >> $conffile
			priority=$(expr $priority + 5)
		done
		echo "src oe-staging file:${DEPLOY_DIR_PSTAGE}" >> $conffile

		OLD_PWD=`pwd`
		cd ${DEPLOY_DIR_PSTAGE}
		ipkg-make-index -p Packages . 
		cd ${OLD_PWD}

		${PSTAGE_UPDATE_CMD}
	fi
}

python do_prepackaged_stage () {
    import os

    if bb.data.getVar("PSTAGING_DISABLED", d, 1) == "1":
        bb.build.make_stamp("do_prepackaged_stage", d)
        return

    bb.note("Uninstalling any existing package from staging...")
    path = bb.data.getVar("PATH", d, 1)
    removecmd = bb.data.getVar("PSTAGE_REMOVE_CMD", d, 1)
    removepkg = bb.data.expand("staging-${PN}", d)
    lf = bb.utils.lockfile(bb.data.expand("${STAGING_DIR}/staging.lock", d))
    ret = os.system("PATH=\"%s\" %s %s" % (path, removecmd, removepkg))
    bb.utils.unlockfile(lf)
    if ret != 0:
        bb.note("Failure attempting to remove staging package")

    stagepkg = bb.data.expand("${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}", d)

    if os.path.exists(stagepkg):
        bb.note("Following speedup\n")
        path = bb.data.getVar("PATH", d, 1)
        installcmd = bb.data.getVar("PSTAGE_INSTALL_CMD", d, 1)

        bb.build.exec_func("staging_helper", d)

        bb.debug(1, "Staging stuff already packaged, using that instead")
        lf = bb.utils.lockfile(bb.data.expand("${STAGING_DIR}/staging.lock", d))
        ret = os.system("PATH=\"%s\" %s %s" % (path, installcmd, stagepkg))
        bb.utils.unlockfile(lf)
        if ret != 0:
            bb.note("Failure installing prestage package")

        bb.build.make_stamp("do_prepackaged_stage", d)
        bb.build.make_stamp("do_fetch", d)
        bb.build.make_stamp("do_unpack", d)
        bb.build.make_stamp("do_munge", d)
        bb.build.make_stamp("do_patch", d)
        bb.build.make_stamp("do_configure", d)
        bb.build.make_stamp("do_qa_configure", d)
        bb.build.make_stamp("do_rig_locales", d)
        bb.build.make_stamp("do_compile", d)
        bb.build.make_stamp("do_install", d)
        bb.build.make_stamp("do_deploy", d)
        bb.build.make_stamp("do_package", d)
        bb.build.make_stamp("do_populate_staging", d)
        bb.build.make_stamp("do_package_write_deb", d)
        bb.build.make_stamp("do_package_write_ipk", d)
        bb.build.make_stamp("do_package_write", d)
        bb.build.make_stamp("do_package_stage", d)
        bb.build.make_stamp("do_qa_staging", d)

    else:
        bb.build.make_stamp("do_prepackaged_stage", d)
}
do_prepackaged_stage[cleandirs] = "${PSTAGE_TMPDIR_STAGE}"
do_prepackaged_stage[selfstamp] = "1"
addtask prepackaged_stage before do_fetch

populate_staging_preamble () {
	if [ "$PSTAGING_DISABLED" != "1" ]; then
		#mkdir -p ${DEPLOY_DIR_PSTAGE}

		stage-manager -p ${STAGING_DIR} -c ${DEPLOY_DIR_PSTAGE}/stamp-cache-staging -u
		stage-manager -p ${CROSS_DIR} -c ${DEPLOY_DIR_PSTAGE}/stamp-cache-cross -u
	fi
}

populate_staging_postamble () {
	if [ "$PSTAGING_DISABLED" != "1" ]; then
		# list the packages currently installed in staging
		${PSTAGE_LIST_CMD} | awk '{print $1}' > ${DEPLOY_DIR_PSTAGE}/installed-list         

		set +e
		stage-manager -p ${STAGING_DIR} -c ${DEPLOY_DIR_PSTAGE}/stamp-cache-staging -u -d ${PSTAGE_TMPDIR_STAGE}/staging
		stage-manager -p ${CROSS_DIR} -c ${DEPLOY_DIR_PSTAGE}/stamp-cache-cross -u -d ${PSTAGE_TMPDIR_STAGE}/cross
		set -e
	fi
}

do_populate_staging[lockfiles] = "${STAGING_DIR}/staging.lock"
do_populate_staging[dirs] =+ "${DEPLOY_DIR_PSTAGE}"
python do_populate_staging_prepend() {
    bb.build.exec_func("populate_staging_preamble", d)
}

python do_populate_staging_append() {
    bb.build.exec_func("populate_staging_postamble", d)
}


staging_packager () {

	mkdir -p ${PSTAGE_TMPDIR_STAGE}/CONTROL

	echo "Package: staging-${PN}"           >  ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Version: ${PV}-${PR}"             >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Description: ${DESCRIPTION}"      >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Section: ${SECTION}"              >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Priority: Optional"               >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Maintainer: ${MAINTAINER}"        >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Architecture: ${MULTIMACH_ARCH}"    >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control
	echo "Source: ${SRC_URI}"               >> ${PSTAGE_TMPDIR_STAGE}/CONTROL/control

        ${PSTAGE_BUILD_CMD} ${PSTAGE_TMPDIR_STAGE} ${DEPLOY_DIR_PSTAGE}
	${PSTAGE_INSTALL_CMD} ${DEPLOY_DIR_PSTAGE}/${PSTAGE_PKGNAME}
}

python do_package_stage () {
    if bb.data.getVar("PSTAGING_DISABLED", d, 1) == "1":
        return

    bb.build.exec_func("read_subpackage_metadata", d)
    packages = (bb.data.getVar('PACKAGES', d, 1) or "").split()
    if len(packages) > 0:
        stagepath = bb.data.getVar("PSTAGE_TMPDIR_STAGE", d, 1)
        if bb.data.inherits_class('package_ipk', d):
            ipkpath = os.path.join(stagepath, "deploy", "ipk")
            bb.mkdirhier(ipkpath)
        if bb.data.inherits_class('package_deb', d):
            debpath = os.path.join(stagepath, "deploy", "deb")
            bb.mkdirhier(debpath)

        for pkg in packages:
            pkgname = bb.data.getVar('PKG_%s' % pkg, d, 1)
            if not pkgname:
                pkgname = pkg
            arch = bb.data.getVar('PACKAGE_ARCH_%s' % pkg, d, 1)
            if not arch:
                arch = bb.data.getVar('PACKAGE_ARCH', d, 1)
            if not packaged(pkg, d):
                continue
            if bb.data.inherits_class('package_ipk', d):
                srcname = bb.data.expand(pkgname + "_${PV}-${PR}_" + arch + ".ipk", d)
                srcfile = bb.data.expand("${DEPLOY_DIR_IPK}/" + arch + "/" + srcname, d)
                if not os.path.exists(srcfile):
                    bb.fatal("Package %s does not exist yet it should" % srcfile)
                bb.copyfile(srcfile, ipkpath + "/" + srcname)
            if bb.data.inherits_class('package_deb', d):
                if arch == 'all':
                    srcname = bb.data.expand(pkgname + "_${PV}-${PR}_all.deb", d)
                else:
                    srcname = bb.data.expand(pkgname + "_${PV}-${PR}_${DPKG_ARCH}.deb", d)
                srcfile = bb.data.expand("${DEPLOY_DIR_DEB}/" + arch + "/" + srcname, d)
                if not os.path.exists(srcfile):
                    bb.fatal("Package %s does not exist yet it should" % srcfile)
                bb.copyfile(srcfile, debpath + "/" + srcname)
    bb.build.exec_func("staging_helper", d)
    lf = bb.utils.lockfile(bb.data.expand("${STAGING_DIR}/staging.lock", d))
    bb.build.exec_func("staging_packager", d)
    bb.utils.unlockfile(lf)
}

addtask package_stage after do_package_write_ipk do_package_write_deb do_package_write do_populate_staging before do_build

