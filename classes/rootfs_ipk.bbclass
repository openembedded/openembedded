#
# Creates a root filesystem out of IPKs
#
# This rootfs can be mounted via root-nfs or it can be put into an cramfs/jffs etc.
# See image_ipk.oeclass for a usage of this.
#

DEPENDS_prepend="ipkg-native ipkg-utils-native fakeroot-native "
DEPENDS_append=" ${EXTRA_IMAGEDEPENDS}"

PACKAGES = ""

do_rootfs[nostamp] = 1
do_rootfs[dirs] = ${TOPDIR}
do_build[nostamp] = 1

IPKG_ARGS = "-f ${T}/ipkg.conf -o ${IMAGE_ROOTFS}"

ROOTFS_POSTPROCESS_COMMAND ?= ""

PID = "${@os.getpid()}"

# some default locales
IMAGE_LINGUAS ?= "de-de fr-fr en-gb"
LINGUAS_NAMES ?= "de fr en"

LINGUAS_INSTALL = "${@" ".join(map(lambda s: "locale-base-%s" % s, bb.data.getVar('IMAGE_LINGUAS', d, 1).split()))}"

real_do_rootfs () {
	set -x
		
	mkdir -p ${IMAGE_ROOTFS}/dev
	mkdir -p ${T}

	if [ 1 == "${USE_FEED_FOR_IMAGES}" ]; then
		insert_feed_uris_t
	else
		if [ -z "${DEPLOY_KEEP_PACKAGES}" ]; then
			touch ${DEPLOY_DIR_IPK}/Packages
			ipkg-make-index -r ${DEPLOY_DIR_IPK}/Packages -p ${DEPLOY_DIR_IPK}/Packages -l ${DEPLOY_DIR_IPK}/Packages.filelist -m ${DEPLOY_DIR_IPK}
		fi
		echo "src oe file:${DEPLOY_DIR_IPK}" > ${T}/ipkg.conf
	fi
	
 	ipkgarchs="${IPKG_ARCHS}"
	priority=1
	for arch in $ipkgarchs; do
		echo "arch $arch $priority" >> ${T}/ipkg.conf
		priority=$(expr $priority + 5)
	done

	echo "lists_dir ext /tmp/lists/" >>${T}/ipkg.conf
	
	ipkg-cl ${IPKG_ARGS} update
	if [ ! -z "${LINGUAS_INSTALL}" ]; then
		ipkg-cl ${IPKG_ARGS} install glibc-localedata-i18n
		for i in ${LINGUAS_INSTALL}; do
			ipkg-cl ${IPKG_ARGS} install $i
		done
	fi
	if [ ! -z "${IPKG_INSTALL}" ]; then
		ipkg-cl ${IPKG_ARGS} install ${IPKG_INSTALL}
	fi

	export D=${IMAGE_ROOTFS}
	export IPKG_OFFLINE_ROOT=${IMAGE_ROOTFS}
	mkdir -p ${IMAGE_ROOTFS}/etc/ipkg/
	grep "^arch" ${T}/ipkg.conf >${IMAGE_ROOTFS}/etc/ipkg/arch.conf

	for i in ${IMAGE_ROOTFS}${libdir}/ipkg/info/*.preinst; do
		if [ -f $i ] && ! sh $i; then
			ipkg-cl ${IPKG_ARGS} flag unpacked `basename $i .preinst`
		fi
	done
	for i in ${IMAGE_ROOTFS}${libdir}/ipkg/info/*.postinst; do
		if [ -f $i ] && ! sh $i configure; then
			ipkg-cl ${IPKG_ARGS} flag unpacked `basename $i .postinst`
		fi
	done

	install -d ${IMAGE_ROOTFS}/${sysconfdir}
	echo ${BUILDNAME} > ${IMAGE_ROOTFS}/${sysconfdir}/version

	rm -rf ${IMAGE_ROOTFS}/tmp/lists
	${ROOTFS_POSTPROCESS_COMMAND}
	
	log_check rootfs 	
}

log_check() {
	set +x
	for target in $*
	do
		lf_path="${WORKDIR}/temp/log.do_$target.${PID}"
		
		echo "log_check: Using $lf_path as logfile"
		
		if test -e "$lf_path"
		then
			lf_txt="`cat $lf_path`"
			
			for keyword_die in "Cannot find package" "exit 1" ERR Fail
			do				
				
				if (echo "$lf_txt" | grep -v log_check | grep "$keyword_die") &>/dev/null
				then
					echo "log_check: There were error messages in the logfile"
					echo -e "log_check: Matched keyword: [$keyword_die]\n"
					echo "$lf_txt" | grep -v log_check | grep -i "$keyword_die" -C1
					echo ""
					do_exit=1				
				fi
			done
			test "$do_exit" = 1 && exit 1						
		else
			echo "Cannot find logfile [$lf_path]"
		fi
		echo "Logfile is clean"		
	done

	set -x
	
}

fakeroot do_rootfs () {
	rm -rf ${IMAGE_ROOTFS}
	real_do_rootfs
}

# set '*' as the rootpassword so the images
# can decide if they want it or not

zap_root_password () {
	sed 's%^root:[^:]*:%root:*:%' < ${IMAGE_ROOTFS}/etc/passwd >${IMAGE_ROOTFS}/etc/passwd.new
	mv ${IMAGE_ROOTFS}/etc/passwd.new ${IMAGE_ROOTFS}/etc/passwd	
} 

create_etc_timestamp() {
	date +%2m%2d%2H%2M%Y >${IMAGE_ROOTFS}/etc/timestamp
}

# export the zap_root_password and create_etc_timestamp
EXPORT_FUNCTIONS zap_root_password create_etc_timestamp

insert_feed_uris_t () {

        echo "Adding feed descriptors for [${DISTRO}] to get built from"

        for line in ${FEED_URIS}
        do
                # strip leading and trailing spaces/tabs, then split into name and uri
                line_clean="`echo "$line"|sed 's/^[ \t]*//;s/[ \t]*$//'`"
                feed_name="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\1/p'`"
                feed_uri="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\2/p'`"

                echo "Added $feed_name feed with URL $feed_uri"

                # insert new feed-sources
                echo "src/gz $feed_name $feed_uri" >> ${T}/ipkg.conf
        done
		for line in ${LINGUAS_NAMES}; do
				feed_name="locale-${line}"
				feed_uri="${FEED_BASE_URI}/feed/locale/${line}"

                echo "Added $feed_name feed with URL $feed_uri"

                # insert new feed-sources
                echo "src/gz $feed_name $feed_uri" >> ${T}/ipkg.conf
		done
}



addtask rootfs before do_build after do_install
