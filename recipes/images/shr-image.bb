require shr-image.inc

IMAGE_BASENAME = "full"

DEPENDS += "task-shr"
RDEPENDS += "\
    task-shr-apps \
    task-shr-games \
    task-shr-gtk \
    task-shr-cli \
"

IMAGE_INSTALL += "\
  task-shr-apps \
  task-shr-games \
  task-shr-gtk \
  task-shr-cli \
"

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess_append() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}


    #Replace desktop files
    echo "Icon=pidgin.png" >> ./usr/share/applications/pidgin.desktop
    sed -i "s/^X-Icon-path.*$//g" ./usr/share/applications/vagalume.desktop

    cd $curdir
}

