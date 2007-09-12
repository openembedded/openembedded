DESCRIPTION = "Meta package for a Scratchbox GPE SDK"
LICENSE = "MIT"
PACKAGES = ""
PR = "r0"

inherit rootfs_ipk sdk meta

SDK_DIR = "${WORKDIR}/sdk"
SDK_OUTPUT = "${SDK_DIR}/image"
SDK_DEPLOY = "${DEPLOY_DIR}/sdk"
prefix = "/"
exec_prefix = "${prefix}"
base_prefix = "${exec_prefix}"
FILES_${PN} = "${prefix}"

TARGET_INSTALL = "\
    task-sdk-base \
    task-sdk-sbox \
    task-sdk-sbox-gpe \
    task-sdk-x11 \
    task-sdk-x11-ext \
    task-sdk-gpe \
    task-sdk-gpephone"

DEPENDS = "ipkg-native ipkg-utils-native fakeroot-native sed-native"
RDEPENDS = "${TARGET_INSTALL}"


IPKG_TARGET = "ipkg-cl -f ${SDK_DIR}/ipkg-target.conf -o ${SDK_OUTPUT}/${prefix}"

do_populate_sdk() {
	set -ex
	package_update_index_ipk
	set +ex

	rm -rf ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}

        cat <<EOF >${SDK_DIR}/ipkg-target.conf
src oe file:${DEPLOY_DIR_IPK}
EOF
	ipkgarchs="${PACKAGE_ARCHS}"
        priority=1
        for arch in $ipkgarchs; do
                echo "arch $arch $priority" >> ${SDK_DIR}/ipkg-target.conf
	        priority=$(expr $priority + 5)
		if [ -e ${DEPLOY_DIR_IPK}/$arch/Packages ] ; then
		        echo "src oe-$arch file:${DEPLOY_DIR_IPK}/$arch" >> ${SDK_DIR}/ipkg-target.conf
		fi
        done

	rm -r ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}

	${IPKG_TARGET} update
	${IPKG_TARGET} install ${TARGET_INSTALL}

	mkdir -p ${SDK_OUTPUT}/${prefix}/usr/include
	#cp -pPR ${SDK_OUTPUT}/${prefix}/usr/* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}
	#rm -rf ${SDK_OUTPUT}/${prefix}/usr/

        #cp -pPR ${SDK_OUTPUT}/${prefix}/lib/* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib
        #rm -rf ${SDK_OUTPUT}/${prefix}/lib/*

	cp -pPR ${TMPDIR}/cross/${TARGET_SYS}/include/linux/ ${SDK_OUTPUT}/${prefix}/usr/include/
        cp -pPR ${TMPDIR}/cross/${TARGET_SYS}/include/asm/ ${SDK_OUTPUT}/${prefix}/usr/include/
	chmod -R a+r ${SDK_OUTPUT}/${prefix}/usr/include/
	find ${SDK_OUTPUT}/${prefix}/usr/include/ -type d | xargs chmod +x

        echo 'GROUP ( libpthread.so.0 libpthread_nonshared.a )' > ${SDK_OUTPUT}/${prefix}/lib/libpthread.so
        echo 'GROUP ( libc.so.6 libc_nonshared.a )' > ${SDK_OUTPUT}/${prefix}/lib/libc.so
	# remove unwanted housekeeping files
	mv ${SDK_OUTPUT}${libdir}/../*/lib/ipkg/status ${SDK_OUTPUT}/${prefix}/package-status
	rm -rf ${SDK_OUTPUT}${libdir}/ipkg

	# remove unwanted executables
	rm -rf ${SDK_OUTPUT}/${prefix}/sbin ${SDK_OUTPUT}/${prefix}/etc

	# fixup libtool files
	rm  ${SDK_OUTPUT}/${prefix}/usr/lib/*.la
	#cd  ${SDK_OUTPUT}/${prefix}/usr/lib/
	#for f in *.la ; do
        #        sed -i 's%${STAGING_DIR}/${TARGET_SYS}%/usr/%g' "$f"
        #done
	

	# fix pkgconfig data files
	cd ${SDK_OUTPUT}/${prefix}/usr/lib/pkgconfig
	for f in *.pc ; do
		sed -i 's%${STAGING_DIR}%/usr/%g' "$f"
	done

        mkdir -p ${SDK_DEPLOY}
	cd ${SDK_OUTPUT}
	fakeroot tar cfz ${SDK_DEPLOY}/sbox-gpesdk-${DISTRO}-${DISTRO_VERSION}-${TARGET_ARCH}.tar.gz .
}

do_populate_sdk[nostamp] = "1"
do_populate_sdk[recrdeptask] = "do_package_write"
addtask populate_sdk before do_build after do_install
