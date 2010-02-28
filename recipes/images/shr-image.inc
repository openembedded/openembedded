#------------------------------------------------------
# SHR Image Recipe
#------------------------------------------------------

PV = "2.0"
PR = "r13"


DEPENDS += "task-shr-minimal"

RDEPENDS += "\
  task-shr-minimal-base \
  task-shr-minimal-cli \
  task-shr-minimal-fso \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
"

IMAGE_INSTALL += "\
  task-shr-minimal-base \
  task-shr-minimal-cli \
  task-shr-minimal-fso \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
"

inherit image

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess() {
    dirs=`find ${FILESDIR} -type d -printf "%P\n" | grep -v "^.$" | grep -v ".git"`
    for dir in $dirs; do
        mkdir -p ${IMAGE_ROOTFS}/$dir
    done
    files=`find ${FILESDIR} -type f -printf "%P\n" | grep -v ".git"`
    for file in $files; do
        cp -f ${FILESDIR}/$file ${IMAGE_ROOTFS}/$file
    done

    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    # date/time
    date "+%m%d%H%M%Y" >./etc/timestamp
    # alias foo
    echo "alias pico=nano" >>./etc/profile
    echo "alias fso='cd /local/pkg/fso'" >>./etc/profile
    echo "alias ipkg='opkg'" >>./etc/profile
    # dns
    echo "nameserver 208.67.222.222" >./etc/resolv.conf
    echo "nameserver 208.67.220.220" >>./etc/resolv.conf
    # nfs
    mkdir -p ./local/pkg
    echo >>./etc/fstab
    echo "# NFS Host" >>./etc/fstab
    echo "192.168.0.200:/local/pkg /local/pkg nfs noauto,nolock,soft,rsize=32768,wsize=32768 0 0" >>./etc/fstab

    # minimal gtk theme foo
    # this should be set in postinst phase of installed gtk-theme package
    #mkdir -p ./etc/gtk-2.0/
    #echo 'gtk-font-name = "Sans 5"' >> ./etc/gtk-2.0/gtkrc.default
    #echo 'gtk-theme-name = "shr-theme-gtk-e17lookalike"' >> ./etc/gtk-2.0/gtkrc.default
    #echo 'gtk-icon-theme-name = "openmoko-standard"' >> ./etc/gtk-2.0/gtkrc.default
    #echo 'style "treeview"' >> ./etc/gtk-2.0/gtkrc.default
    #echo '{   ' >> ./etc/gtk-2.0/gtkrc.default
    #echo '    GtkTreeView::expander-size = 40' >> ./etc/gtk-2.0/gtkrc.default
    #echo '}' >> ./etc/gtk-2.0/gtkrc.default
    #echo 'widget_class "*TreeView*" style "treeview"' >> ./etc/gtk-2.0/gtkrc.default
    #update-alternatives --install /etc/gtk-2.0/gtkrc gtk-theme /etc/gtk-2.0/gtkrc.default 1

    # elementary theme foo
    ELM_PROFILE_SCR=./etc/profile.d/elementary.sh
    echo 'export ELM_ENGINE=x11' > ${ELM_PROFILE_SCR}
    echo 'export ELM_THEME=gry' >> ${ELM_PROFILE_SCR}
    echo 'export ELM_SCALE=2' >> ${ELM_PROFILE_SCR}
    echo 'export ELM_FINGER_SIZE=70' >> ${ELM_PROFILE_SCR}
    chmod +x ${ELM_PROFILE_SCR}

    echo '' >> ./etc/ld.so.conf
    # fix strange iconv/gconf bug
    ln -s libc.so.6 ./lib/libc.so

    #font cache optimization, persistent cache
    sed -i "s/<cachedir>.*\/var\/cache\/\(.*\)<\/cachedir>/<cachedir>\/var\/local\/\1<\/cachedir>/g" ./etc/fonts/fonts.conf

    #set up a nice gentoo-like PS1
    echo "export PS1=\"\[\033[01;32m\]\u@\h\[\033[01;34m\] \w \$\[\033[00m\] \"">> ./etc/profile

    #set up some variables to improve default settings
    echo "if [ \"\$DISPLAY\" = \"\" ]" >> ./etc/profile
    echo "then" >> ./etc/profile
    echo "    export DISPLAY=localhost:0" >> ./etc/profile
    echo "fi" >> ./etc/profile
    echo "export HISTFILESIZE=1000" >> ./etc/profile
    echo "export HISTSIZE=1000" >> ./etc/profile
    echo "alias rm='rm -i'; alias cp='cp -i'; alias mv='mv -i'" >> ./etc/profile
    echo "alias la='ls $LS_OPTIONS -ltrA'; alias lh='ls $LS_OPTIONS -ltrh'; alias lr='ls $LS_OPTIONS -ltr';" >> ./etc/profile
    echo "alias lR='ls $LS_OPTIONS -ltrR'" >> ./etc/profile
    echo "# set your locale here:" >> ./etc/profile
    echo "export LANG=en_US.UTF-8" >> ./etc/profile

    # Add some missing entries to the passwd and group file; but do so carefully
    # since this will be fixed upstream at some point.
    grep -q '^tss:' ./etc/passwd || echo 'tss:x:93:93:Linux TSS User:/bin:/bin/sh' >>./etc/passwd
    grep -q '^scanner:' ./etc/group || echo 'scanner:*:91:' >>./etc/group
    grep -q '^nvram:'   ./etc/group || echo 'nvram:*:92:'   >>./etc/group
    grep -q '^tss:'     ./etc/group || echo 'tss:*:93:'     >>./etc/group
    grep -q '^fuse:'    ./etc/group || echo 'fuse:*:94:'    >>./etc/group
    grep -q '^kvm:'     ./etc/group || echo 'kvm:*:95:'     >>./etc/group
    grep -q '^rdma:'    ./etc/group || echo 'rdma:*:96:'    >>./etc/group

    cd $curdir
}

shr_rootfs_gta02_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    cd ${IMAGE_ROOTFS}/boot
    ln -s uImage uImage-GTA02.bin
    cd $curdir
}

shr_rootfs_gta01_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}
    cd ${IMAGE_ROOTFS}/boot
    ln -s uImage uImage-GTA01.bin
    cd $curdir
}

# We don't want /boot directory in jffs2/ubi/ubifs images
IMAGE_CMD_jffs2 = "mv ${IMAGE_ROOTFS}/boot ${IMAGE_ROOTFS}-boot && mkfs.jffs2 -x lzo --root=${IMAGE_ROOTFS} --faketime --output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 ${EXTRA_IMAGECMD} && mv ${IMAGE_ROOTFS}-boot ${IMAGE_ROOTFS}/boot"
IMAGE_CMD_ubi = "mv ${IMAGE_ROOTFS}/boot ${IMAGE_ROOTFS}-boot && echo \[ubifs\] > ubinize.cfg ; echo mode=ubi >> ubinize.cfg ; echo image=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ubifs >> ubinize.cfg ; echo vol_id=0 >> ubinize.cfg ; echo vol_type=dynamic >> ubinize.cfg ; echo vol_name=${UBI_VOLNAME} >> ubinize.cfg ; echo vol_flags=autoresize >> ubinize.cfg;mkfs.ubifs -r ${IMAGE_ROOTFS} -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ubifs ${MKUBIFS_ARGS} && ubinize -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ubi ${UBINIZE_ARGS} ubinize.cfg && mv ${IMAGE_ROOTFS}-boot ${IMAGE_ROOTFS}/boot"
IMAGE_CMD_ubifs = "mv ${IMAGE_ROOTFS}/boot ${IMAGE_ROOTFS}-boot && mkfs.ubifs -r ${IMAGE_ROOTFS} -o ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.ubifs.img ${MKUBIFS_ARGS} && mv ${IMAGE_ROOTFS}-boot ${IMAGE_ROOTFS}/boot"

ROOTFS_POSTPROCESS_COMMAND += " shr_rootfs_postprocess"

ROOTFS_POSTPROCESS_COMMAND_append_om-gta02 = ";shr_rootfs_gta02_postprocess"
ROOTFS_POSTPROCESS_COMMAND_append_om-gta01 = ";shr_rootfs_gta01_postprocess"
