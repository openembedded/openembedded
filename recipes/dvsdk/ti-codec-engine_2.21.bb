require dsplink.inc

INSANE_SKIP_ti-codec-engine-apps = True
INSANE_SKIP_ti-dsplink-apps = True
INSANE_SKIP_${PN} = True

DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

# tconf from xdctools dislikes '.' in pwd :/
PV = "221"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_21.tar.gz \
           file://cmem-class-device-27-and-sched-include-fix.patch;patch=1 \
           file://sdma-class-device-and-includes-fix.patch;patch=1 \
           file://dsplink-semaphore-27.patch;patch=1 \
           file://dsplink-add-class-device-create-support.patch;patch=1 \
           file://lpm-device-create-and-semaphore-include-fix.patch;patch=1 \
           file://lpm-make-symbol-warnings-fix.patch;patch=1 \
           file://Makefile-dsplink-gpp \
           file://Makefile-dsplink-dsp \
           file://loadmodules-ti-dsplink-apps.sh \
           file://unloadmodules-ti-dsplink-apps.sh \
           file://loadmodules-ti-codec-engine-apps.sh \
           file://unloadmodules-ti-codec-engine-apps.sh \
"

S = "${WORKDIR}/codec_engine_2_21"

require ti-paths.inc

export DSPLINK="${S}/cetools/packages/dsplink"

PARALLEL_MAKE = ""

# the include files on top define do_compile for the submodules 
do_compile_append() {

#dsplink already done from inclusion of require dsplink.inc

#lpm bits
	if [ -e ${S}/cetools/packages/ti/bios/power/ ] ; then
		
		# Build the DSP power manager kernel module
		cd ${S}/cetools/packages/ti/bios/power/modules/${DSPPOWERSOC}/lpm

		# Still need to move this into the patch file
		if [ $(echo ${KERNEL_VERSION} | cut -c5,6) -gt 26 ] ; then
			sed -i -e s:asm/semaphore:linux/semaphore: lpm_driver.c
		fi

		#what is this for?
		rm -f *o
		
		# lpm also needs KERNEL_INSTALL_DIR and MVTOOL_PREFIX which come from ti-paths.inc
		export DSPLINK_REPO=${DSPLINK}/..
		# should move the clean step into the clean stage..
		#oe_runmake clean
		oe_runmake
	fi

#cmemk bits
	if [ -e ${S}/cetools/packages/ti/sdo/linuxutils/cmem ] ; then
                echo "MVTOOL_PREFIX=${TARGET_PREFIX}" > ${S}/Rules.make
                echo "UCTOOL_PREFIX=${TARGET_PREFIX}" >> ${S}/Rules.make
                echo "LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}"  >> ${S}/Rules.make
                #export DSPLINK=${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/dsplink

		# Build the cmem kernel module and associated test apps
		# We unset CFLAGS because kernel modules need different ones, this is basically a verbatim copy of kernel.bbclass and module-base.bbclass	
		unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS	

		cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem
		oe_runmake clean
		oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
   	        KERNEL_SRC=${STAGING_KERNEL_DIR}    \
   	        KERNEL_VERSION=${KERNEL_VERSION}    \
   	        CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
   	        AR="${KERNEL_AR}"
	fi

#sdma bits
        if [ -e ${S}/cetools/packages/ti/sdo/linuxutils/sdma ] ; then
               echo "MVTOOL_PREFIX=${TARGET_PREFIX}" > ${S}/Rules.make
               echo "UCTOOL_PREFIX=${TARGET_PREFIX}" >> ${S}/Rules.make
               echo "LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}"  >> ${S}/Rules.make

                # Build the sdma kernel module and associated test apps
                # We unset CFLAGS because kernel modules need different ones, this is basically a verbatim copy of kernel.bbclass and module-base.bbclass
                unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

                cd ${S}/cetools/packages/ti/sdo/linuxutils/sdma
                oe_runmake clean
                oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
                KERNEL_SRC=${STAGING_KERNEL_DIR}    \
                KERNEL_VERSION=${KERNEL_VERSION}    \
                CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
                AR="${KERNEL_AR}"
        fi


#need to add other modules here, like IRQ, etc


#now build the CE examples
	cd ${S}/examples

	# Fix paths to arm crosstools, c6x codegen and x86 gcc
	# Also disable uclibc and x86 builds
	sed -i -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3:${CROSS_DIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/opensource/gcc/4.1.0/Linux/gcc-4.1.0-glibc-2.3.6/i686-unknown-linux-gnu:/usr:g \
        -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
        -e 's:true, // build for uC Linux:false,:g' \
        -e 's:true,  // build for PC Linux:false,:g' \
        ${S}/examples/user.bld

        # For now, remove all targets, except dm6446 and omap3530
        sed -i \
        -e '/evmDM357/d' \
        -e '/evmDM6446/d' \
        -e '/evmDM6467/d' \
        -e '/evmDM355/d' \
        -e '/evmDM6437/d' \
        -e '/evmDM648/d' \
        -e '/sdp3430/d' \
        -e '/evm2530/d' \
        ${S}/examples/user.bld

	# Fix path to c6x codegen
	sed -i -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
	        xdcpaths.mak
	
	# Start building the CE examples: codecs, extensions, servers (codec bundles) and ARM side apps	
	# the DSP side uses CC to point to the c6x codegen, but would get the gcc tool
	unset CC

	# Make clean doesn't do what you'd expect, it only cleans stuff you've enabled, so some cruft remains	

	# First clean
	for i in codecs extensions servers apps ; do
		make -e -C ${S}/examples/ti/sdo/ce/examples/$i clean
	done	

	# Then build the examples
	for i in codecs extensions servers apps ; do
		make -e -C ${S}/examples/ti/sdo/ce/examples/$i
	done
}

do_install_append () {
    #driver - kernel module
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
        cp ${S}/cetools/packages/ti/bios/power/modules/${DSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true
	cp ${S}/cetools/packages/ti/sdo/linuxutils/cmem/src/module/cmemk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true
        cp ${S}/cetools/packages/ti/sdo/linuxutils/sdma/src/module/sdmak.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true

    #library
	#install -d ${D}/${libdir}
	#install -m 0755 ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE/dsplink.lib  ${D}/${libdir}

    #sample apps - this is very 64x / v5T specific at the moment - we really need CE to give us this list...
	install -d ${D}/${datadir}/ti-codec-engine
	# we change pwd so that find gives us relative path to the files, which we use to create the same structure on the target
	cd ${S}/examples/ti/sdo/ce

    #test app module un/load scripts
	install ${WORKDIR}/loadmodules-ti-dsplink-apps.sh ${D}/${datadir}/ti-dsplink
	install ${WORKDIR}/unloadmodules-ti-dsplink-apps.sh ${D}/${datadir}/ti-dsplink

    #ce samples
	# first find all the app files named '.out'
	for i in $(find . -name "*.out") ; do
		# first create the directory
		install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
		# now copy the file		
		install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
	done

	# next find all the app files named '.xv5T'
	for i in $(find . -name "*.xv5T") ; do
		# first create the directory
		install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
		# now copy the file		
		install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
	done

	# then find all the app/server files named '.x64P'
	for i in $(find . -name "*.x64P") ; do
		# first create the directory
		install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
		# now copy the file		
		install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
	done

	# finally find all the app files named '.dat'
	for i in $(find . -name "*.dat") ; do
		# first create the directory
		install -d ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
		# now copy the file		
		install ${i} ${D}/${datadir}/ti-codec-engine/`dirname ${i}`
	done

    #test app module un/load scripts
	install ${WORKDIR}/loadmodules-ti-codec-engine-apps.sh ${D}/${datadir}/ti-codec-engine
	install ${WORKDIR}/unloadmodules-ti-codec-engine-apps.sh ${D}/${datadir}/ti-codec-engine

	# we should install the CMEM apps as well here

	# finally, strip targets that we're not supporting here
	# - TODO...
}

PACKAGES =+ "ti-lpm-module ti-cmem-module ti-sdma-module ti-codec-engine-apps"

FILES_ti-lpm-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"
FILES_ti-cmem-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/cmemk.ko"
FILES_ti-sdma-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/sdmak.ko"
FILES_ti-codec-engine-apps = "${datadir}/ti-codec-engine/*"

pkg_postinst_ti-lpm-module () {
	if [ -n "$D" ]; then
		exit 1
	fi
	depmod -a
	update-modules || true
}

pkg_postrm_ti-lpm-module () {
	update-modules || true
}

pkg_postinst_ti-cmem-module () {
	if [ -n "$D" ]; then        
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_ti-cmem-module () {
        update-modules || true
}

pkg_postinst_ti-sdma-module () {
        if [ -n "$D" ]; then
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_ti-sdma-module () {
        update-modules || true
}

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#legacy upgrade helpers
RPROVIDES_ti-cmem-module += "ti-cmemk-module"
RREPLACES_ti-cmem-module += "ti-cmemk-module"

# ti-dsplink-module can be built by either codec-engine or standalone dsplink - tell it to use this one, else unwanted dependence
PREFERRED_PROVIDER_ti-dsplink-module = "ti-codec-engine"

#add run-time dependencies - note for kernel module we can only use RRECOMMENDS, since modules might be built into the kernel
RRECOMMENDS_ti-codec-engine-apps += "ti-dsplink-module ti-lpm-module ti-cmem-module ti-sdma-module"

