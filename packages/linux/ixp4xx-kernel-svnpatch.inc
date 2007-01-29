addtask svnpatch before do_configure after do_patch

IXP4XX_KERNEL_SVN_REPO ?= "http://svn.nslu2-linux.org/svnroot/kernel/trunk"

do_svnpatch() {
	svn co ${IXP4XX_KERNEL_SVN_REPO}/patches/${IXP4XX_KERNEL_PATCH_DIR} --revision ${IXP4XX_KERNEL_SVN_REV} ${WORKDIR}/patches-${PV}
	if [ ! -f ${WORKDIR}/defconfig ] ; then \
	  cp ${WORKDIR}/patches-${PV}/defconfig ${WORKDIR}/defconfig ; \
	fi
	rm -rf ${S}/patches
	cd ${S} && ln -s ${WORKDIR}/patches-${PV} ${S}/patches
	if [ -f ${WORKDIR}/series ] ; then \
	  cp ${WORKDIR}/series ${WORKDIR}/patches-${PV}/series ; \
	fi
	cd ${S} && rm -rf .pc && ${STAGING_BINDIR_NATIVE}/quilt push -av
}
