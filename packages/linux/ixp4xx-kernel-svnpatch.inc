addtask svnpatch before do_configure after do_patch

do_svnpatch() {
	svn co http://svn.nslu2-linux.org/svnroot/kernel/branches/ixp_npe/patches/${PV} --revision ${IXP4XX_KERNEL_SVN_REV} ${WORKDIR}/patches-${PV}
	cp ${WORKDIR}/patches-${PV}/defconfig ${WORKDIR}/defconfig
	rm -rf ${S}/patches
    cd ${S} && ln -s ${WORKDIR}/patches-${PV} ${S}/patches
	cd ${S} && ${STAGING_BINDIR}/quilt push -av
}

