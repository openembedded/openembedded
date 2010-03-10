inherit rootfs_${IMAGE_PKGTYPE}
inherit kernel-arch

LICENSE = "MIT"
PACKAGES = ""

#
# udev, devfsd, busybox-mdev (from busybox) or none
#
IMAGE_DEV_MANAGER ?= "${@base_contains("MACHINE_FEATURES", "kernel26",  "udev","",d)} "
#
# sysvinit, upstart
#
IMAGE_INIT_MANAGER ?= "sysvinit sysvinit-pidof"
IMAGE_INITSCRIPTS ?= "initscripts"
#
# tinylogin, getty
#
IMAGE_LOGIN_MANAGER ?= "tinylogin"

# set sane default for the SPLASH variable
SPLASH ?= ""

IMAGE_KEEPROOTFS ?= ""
IMAGE_KEEPROOTFS[doc] = "Set to non-empty to keep ${IMAGE_ROOTFS} around after image creation."

IMAGE_BOOT ?= "${IMAGE_INITSCRIPTS} \
${IMAGE_DEV_MANAGER} \
${IMAGE_INIT_MANAGER} \
${IMAGE_LOGIN_MANAGER} "

RDEPENDS += "${IMAGE_INSTALL} ${IMAGE_BOOT}"

# "export IMAGE_BASENAME" not supported at this time
IMAGE_BASENAME[export] = "1"
export PACKAGE_INSTALL ?= "${IMAGE_INSTALL} ${IMAGE_BOOT}"

# We need to recursively follow RDEPENDS and RRECOMMENDS for images
do_rootfs[recrdeptask] += "do_deploy do_populate_staging"

# Images are generally built explicitly, do not need to be part of world.
EXCLUDE_FROM_WORLD = "1"

USE_DEVFS ?= "0"

PID = "${@os.getpid()}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_rootfs[depends] += "makedevs-native:do_populate_staging fakeroot-native:do_populate_staging"

python () {
    import bb

    deps = bb.data.getVarFlag('do_rootfs', 'depends', d) or ""
    for type in (bb.data.getVar('IMAGE_FSTYPES', d, True) or "").split():
        for dep in ((bb.data.getVar('IMAGE_DEPENDS_%s' % type, d) or "").split() or []):
            deps += " %s:do_populate_staging" % dep
    for dep in (bb.data.getVar('EXTRA_IMAGEDEPENDS', d, True) or "").split():
        deps += " %s:do_populate_staging" % dep
    bb.data.setVarFlag('do_rootfs', 'depends', deps, d)

    runtime_mapping_rename("PACKAGE_INSTALL", d)
}

#
# Get a list of files containing tables of devices to be created.
# * IMAGE_DEVICE_TABLE is the old name to an absolute path to a device table file
# * IMAGE_DEVICE_TABLES is a new name for a file, or list of files, searched
#   for in the BBPATH
# If neither are specified then the default name of files/device_table-minimal.txt
# is searched for in the BBPATH (same as the old version.)
#
def get_devtable_list(d):
    import bb
    devtable = bb.data.getVar('IMAGE_DEVICE_TABLE', d, 1)
    if devtable != None:
        return devtable
    devtables = bb.data.getVar('IMAGE_DEVICE_TABLES', d, 1)
    if devtables == None:
        devtables = 'files/device_table-minimal.txt'
    return " ".join([ bb.which(bb.data.getVar('BBPATH', d, 1), devtable)
                      for devtable in devtables.split() ])

def get_imagecmds(d):
    import bb
    cmds = "\n"
    old_overrides = bb.data.getVar('OVERRIDES', d, 0)
    for type in bb.data.getVar('IMAGE_FSTYPES', d, True).split():
        localdata = bb.data.createCopy(d)
        bb.data.setVar('OVERRIDES', '%s:%s' % (type, old_overrides), localdata)
        bb.data.update_data(localdata)
        cmd  = "\t#Code for image type " + type + "\n"
        cmd += "\t${IMAGE_CMD_" + type + "}\n"
        cmd += "\tcd ${DEPLOY_DIR_IMAGE}/\n"
        cmd += "\trm -f ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}." + type + "\n"
        cmd += "\tln -s ${IMAGE_NAME}.rootfs." + type + " ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}." + type + "\n\n"
        cmds += bb.data.expand(cmd, localdata)
    return cmds

IMAGE_POSTPROCESS_COMMAND ?= ""
MACHINE_POSTPROCESS_COMMAND ?= ""
ROOTFS_POSTPROCESS_COMMAND ?= ""

# some default locales
IMAGE_LINGUAS ?= "de-de fr-fr en-gb"

LINGUAS_INSTALL = "${@" ".join(map(lambda s: "locale-base-%s" % s, bb.data.getVar('IMAGE_LINGUAS', d, 1).split()))}"

do_rootfs[nostamp] = "1"
do_rootfs[dirs] = "${TOPDIR}"
do_build[nostamp] = "1"

# Must call real_do_rootfs() from inside here, rather than as a separate
# task, so that we have a single fakeroot context for the whole process.
fakeroot do_rootfs () {
	set -x
	rm -rf ${IMAGE_ROOTFS}
	mkdir -p ${IMAGE_ROOTFS}
	mkdir -p ${DEPLOY_DIR_IMAGE}

	if [ "${USE_DEVFS}" != "1" ]; then
		for devtable in ${@get_devtable_list(d)}; do
			makedevs -r ${IMAGE_ROOTFS} -D $devtable
		done
	fi

	rootfs_${IMAGE_PKGTYPE}_do_rootfs

	insert_feed_uris

	${IMAGE_PREPROCESS_COMMAND}

	ROOTFS_SIZE=`du -ks ${IMAGE_ROOTFS}|awk '{size = ${IMAGE_EXTRA_SPACE} + $1; print (size > ${IMAGE_ROOTFS_SIZE} ? size : ${IMAGE_ROOTFS_SIZE}) }'`
	${@get_imagecmds(d)}

	${IMAGE_POSTPROCESS_COMMAND}
	
	${MACHINE_POSTPROCESS_COMMAND}
	${@['rm -rf ${IMAGE_ROOTFS}', ''][bool(d.getVar("IMAGE_KEEPROOTFS", 1))]}
}

do_deploy_to[nostamp] = "1"
do_deploy_to () {
	# A standalone task to deploy built image to the location specified
	# by DEPLOY_TO variable (likely passed via environment).
	# Assumes ${IMAGE_FSTYPES} is a single value!
	cp "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.${IMAGE_FSTYPES}" ${DEPLOY_TO}
}

insert_feed_uris () {
	
	echo "Building feeds for [${DISTRO}].."

	for line in ${FEED_URIS}
	do
		# strip leading and trailing spaces/tabs, then split into name and uri
		line_clean="`echo "$line"|sed 's/^[ \t]*//;s/[ \t]*$//'`"
		feed_name="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\1/p'`"
		feed_uri="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\2/p'`"
		
		echo "Added $feed_name feed with URL $feed_uri"
		
		# insert new feed-sources
		echo "src/gz $feed_name $feed_uri" >> ${IMAGE_ROOTFS}/etc/opkg/${feed_name}-feed.conf
	done

	# Allow to use package deploy directory contents as quick devel-testing
	# feed. This creates individual feed configs for each arch subdir of those
	# specified as compatible for the current machine.
	# NOTE: Development-helper feature, NOT a full-fledged feed.
	if [ -n "${FEED_DEPLOYDIR_BASE_URI}" ]; then
	    for arch in ${PACKAGE_ARCHS}
	    do
		echo "src/gz local-$arch ${FEED_DEPLOYDIR_BASE_URI}/$arch" >> ${IMAGE_ROOTFS}/etc/opkg/local-$arch-feed.conf
	    done
	fi
}

log_check() {
	set +x
	for target in $*
	do
		lf_path="${WORKDIR}/temp/log.do_$target.${PID}"
		
		echo "log_check: Using $lf_path as logfile"
		
		if test -e "$lf_path"
		then
			rootfs_${IMAGE_PKGTYPE}_log_check $target $lf_path
		else
			echo "Cannot find logfile [$lf_path]"
		fi
		echo "Logfile is clean"
	done

	set -x
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

# Turn any symbolic /sbin/init link into a file
remove_init_link () {
	if [ -h ${IMAGE_ROOTFS}/sbin/init ]; then
		LINKFILE=${IMAGE_ROOTFS}`readlink ${IMAGE_ROOTFS}/sbin/init`
		rm ${IMAGE_ROOTFS}/sbin/init
		cp $LINKFILE ${IMAGE_ROOTFS}/sbin/init
	fi
}

make_zimage_symlink_relative () {
	if [ -L ${IMAGE_ROOTFS}/boot/zImage ]; then
		(cd ${IMAGE_ROOTFS}/boot/ && for i in `ls zImage-* | sort`; do ln -sf $i zImage; done)
	fi
}

# Make login manager(s) enable automatic login.
# Useful for devices where we do not want to log in at all (e.g. phones)
set_image_autologin () {
        sed -i 's%^AUTOLOGIN=\"false"%AUTOLOGIN="true"%g' ${IMAGE_ROOTFS}/etc/sysconfig/gpelogin
}

# Can be use to create /etc/timestamp during image construction to give a reasonably 
# sane default time setting
rootfs_update_timestamp () {
	date "+%m%d%H%M%Y" >${IMAGE_ROOTFS}/etc/timestamp
}

# Install locales into image for every entry in IMAGE_LINGUAS
install_linguas() {
if [ -e ${IMAGE_ROOTFS}/usr/bin/opkg-cl ] ; then
	OPKG="opkg-cl ${IPKG_ARGS}"

	${OPKG} update || true
	${OPKG} list_installed | awk '{print $1}' |sort | uniq > /tmp/installed-packages

	for i in $(cat /tmp/installed-packages | grep -v locale) ; do
		for translation in ${IMAGE_LINGUAS}; do
			translation_split=$(echo ${translation} | awk -F '-' '{print $1}')
			echo ${i}-locale-${translation}
			echo ${i}-locale-${translation_split}
		done
	done | sort | uniq > /tmp/wanted-locale-packages

	${OPKG} list | awk '{print $1}' |grep locale |sort | uniq > /tmp/available-locale-packages

	cat /tmp/wanted-locale-packages /tmp/available-locale-packages | sort | uniq -d > /tmp/pending-locale-packages

	cat /tmp/pending-locale-packages | xargs ${OPKG} -nodeps install
	rm -f ${IMAGE_ROOTFS}${libdir}/opkg/lists/*

    for i in ${IMAGE_ROOTFS}${libdir}/opkg/info/*.preinst; do
        if [ -f $i ] && ! sh $i; then
            opkg-cl ${IPKG_ARGS} flag unpacked `basename $i .preinst`
        fi
    done

    for i in ${IMAGE_ROOTFS}${libdir}/opkg/info/*.postinst; do
        if [ -f $i ] && ! sh $i configure; then
            opkg-cl ${IPKG_ARGS} flag unpacked `basename $i .postinst`
        fi
    done

fi
}

# export the zap_root_password, create_etc_timestamp and remote_init_link
EXPORT_FUNCTIONS zap_root_password create_etc_timestamp remove_init_link do_rootfs make_zimage_symlink_relative set_image_autologin rootfs_update_timestamp install_linguas

addtask rootfs before do_build after do_install
addtask deploy_to after do_rootfs
