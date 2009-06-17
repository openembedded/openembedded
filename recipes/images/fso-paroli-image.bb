require fso-image.inc

ILLUME_THEME = "paroli"

BASE_INSTALL += " \
#  udev-static-devices \
  locale-base-en-ca \
  libx11-locale \
  localedef \
"

# not many extra apps
GTK_INSTALL = " \
   vala-terminal \
"

GAMES_INSTALL = ""
APPS_INSTALL = ""

PAROLI_INSTALL = "\
  paroli \
  paroli-theme \
  paroli-sounds \
  paroli-autostart \
  task-fso-compliance \
"

PYTHON_INSTALL = "\
  python-evas \
  python-ecore \
  python-edje \
  python-emotion \
  python-etk \
  python-epsilon \
  python-edbus \
  python-codecs \
  python-gst \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${GTK_INSTALL} \
  ${GAMES_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  ${PAROLI_INSTALL} \
  ${APPS_INSTALL} \
"

paroli_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # set a default locale    
    echo "export LANG=en_CA.utf-8" >>./etc/profile
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "paroli_rootfs_postprocess;"

do_rootfs_append() {
	echo "[ubifs]" > ${S}/ubinize.cfg
	echo "mode=ubi" >> ${S}/ubinize.cfg
	echo "image=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.ubifs.img" >> ${S}/ubinize.cfg
	echo "vol_id=0" >> ${S}/ubinize.cfg
	echo "vol_size=200MiB" >> ${S}/ubinize.cfg
	echo "vol_type=dynamic" >> ${S}/ubinize.cfg
	echo "vol_name=rootfs" >> ${S}/ubinize.cfg
	echo "vol_flags=autoresize" >> ${S}/ubinize.cfg

	ubinize -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.ubifs.img.flashable -m 2048 -p 128KiB ${S}/ubinize.cfg
}

	