PR = "r2"

DEPENDS = "ipkg-native ipkg-utils-native binutils-cross-sdk gcc-cross-sdk gdb-cross fakeroot-native meta-gpe"

PACKAGES = ""

inherit sdk

SDK_DIR = "${WORKDIR}/sdk"
SDK_OUTPUT = "${SDK_DIR}/image"
SDK_DEPLOY = "${TMPDIR}/deploy/sdk"

IPKG_HOST = "ipkg-cl -f ${SDK_DIR}/ipkg-host.conf -o ${SDK_OUTPUT}"
IPKG_TARGET = "ipkg-cl -f ${SDK_DIR}/ipkg-target.conf -o ${SDK_OUTPUT}/${prefix}"

HOST_INSTALL = "binutils-cross-sdk gcc-cross-sdk gdb-cross"
TARGET_INSTALL = "libc6 libc6-dev \
compositeext-dev \
damageext-dev \
dbus-dev \
fixesext-dev \
gconf-dev \
gtk+-dev \
gtk-engines-dev \
libapm-dev \
libatk-1.0-dev \
libaudiofile-dev \
libbluetooth-dev \
libcairo-dev \
libdisplaymigration-dev \
libesd-dev \
libeventdb-dev \
libexpat-dev \
libfontconfig-dev \
libfreetype-dev \
libgcrypt-dev \
libglade-2.0-dev \
libglib-2.0-dev \
libgpelaunch-dev \
libgpepimc-dev \
libgpevtype-dev \
libgpewidget-dev \
libgpg-error-dev \
libice-dev \
libidl-2-dev \
libipkg-dev \
libjpeg-dev \
libmb-dev \
libmimedir-dev \
libopenobex-1.0-dev \
libpcap-dev \
libpixman-dev \
libpng-dev \
libpng12-dev \
libpopt-dev \
libreadline-dev \
libschedule-dev \
libsm-dev \
libsoundgen-dev \
libsqlite-dev \
libstartup-notification-1-dev \
libsvg-cairo-dev \
libsvg-dev \
libtododb-dev \
libts-0.0-dev \
libx11-dev \
libxau-dev \
libxcalibrate-dev \
libxcomposite-dev \
libxcursor-dev \
libxdamage-dev \
libxdmcp-dev \
libxext-dev \
libxfixes-dev \
libxfont-dev \
libxft-dev \
libxml2-dev \
libxpm-dev \
libxrandr-dev \
libxrender-dev \
libxsettings-client-dev \
libxsettings-dev \
libxss-dev \
libxt-dev \
libxtst-dev \
libz-dev \
matchbox-desktop-dev \
ncurses-dev \
orbit2-dev \
pango-dev \
randrext-dev \
recordext-dev \
renderext-dev \
resourceext-dev \
rxvt-unicode-dev \
wireless-tools-dev \
xcalibrateext-dev \
xextensions-dev \
xmu-dev \
xproto-dev \
xtrans-dev \
"

do_populate_sdk() {
	touch ${DEPLOY_DIR_IPK}/Packages
	ipkg-make-index -r ${DEPLOY_DIR_IPK}/Packages -p ${DEPLOY_DIR_IPK}/Packages -l ${DEPLOY_DIR_IPK}/Packages.filelist -m ${DEPLOY_DIR_IPK}

	rm -rf ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}

	cat <<EOF >${SDK_DIR}/ipkg-host.conf
src oe file:${DEPLOY_DIR_IPK}
arch ${BUILD_ARCH} 1
EOF
        cat <<EOF >${SDK_DIR}/ipkg-target.conf
src oe file:${DEPLOY_DIR_IPK}
EOF
	ipkgarchs="all any noarch ${TARGET_ARCH} ${IPKG_ARCHS} ${MACHINE}"
        priority=1
        for arch in $ipkgarchs; do
                echo "arch $arch $priority" >> ${SDK_DIR}/ipkg-target.conf
	        priority=$(expr $priority + 5)
        done

	rm -r ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}
	
	${IPKG_HOST} update
	${IPKG_HOST} -nodeps install ${HOST_INSTALL}

	${IPKG_TARGET} update
	${IPKG_TARGET} install ${TARGET_INSTALL}

	mkdir -p ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}
	cp -a ${SDK_OUTPUT}/${prefix}/usr/* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}
	rm -rf ${SDK_OUTPUT}/${prefix}/usr/

        cp -a ${SDK_OUTPUT}/${prefix}/lib/* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib
        rm -rf ${SDK_OUTPUT}/${prefix}/lib/*

	mv ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/gcc* ${SDK_OUTPUT}/${prefix}/lib

	cp -a ${TMPDIR}/cross/${TARGET_SYS}/include/linux/ ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/include/
        cp -a ${TMPDIR}/cross/${TARGET_SYS}/include/asm/ ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/include/
	chmod -R a+r ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/include/
	find ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/include/ -type d | xargs chmod +x

        echo 'GROUP ( libpthread.so.0 libpthread_nonshared.a )' > ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/libpthread.so
        echo 'GROUP ( libc.so.6 libc_nonshared.a )' > ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/libc.so
	# remove unwanted housekeeping files
	mv ${SDK_OUTPUT}${libdir}/ipkg/status ${SDK_OUTPUT}/${prefix}/package-status
	rm -rf ${SDK_OUTPUT}${libdir}/ipkg

	# remove unwanted executables
	rm -rf ${SDK_OUTPUT}/${prefix}/sbin ${SDK_OUTPUT}/${prefix}/etc

        mkdir -p ${SDK_DEPLOY}
	cd ${SDK_OUTPUT}
	fakeroot tar cfj ${SDK_DEPLOY}/oe-sdk-$(date +"%Y%m%d%H%M%S").tar.bz2 .
}

do_populate_sdk[nostamp] = 1
addtask populate_sdk before do_build after do_install
LICENSE = MIT
