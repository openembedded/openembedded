#------------------------------------------------------
# freesmartphone.org Image Recipe, Light Edition
#------------------------------------------------------

require fso-image.bb

IMAGE_LINGUAS = ""

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${PYTHON_INSTALL} \
  ${ZHONE_INSTALL} \
"

inherit image

# perform some convenience tweaks to the rootfs
mickey_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    date "+%m%d%H%M%Y" >./etc/timestamp
    echo "alias pico=nano" >>./etc/profile
    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    mkdir -p ./local/pkg
    echo >>./etc/fstab
    echo "# NFS Host" >>./etc/fstab
    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab
    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "mickey_rootfs_postprocess"
