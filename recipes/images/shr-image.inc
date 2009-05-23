#------------------------------------------------------
# SHR Image Recipe
#------------------------------------------------------

PV = "2.0"
PR = "r1"

IMAGE_LINGUAS = "en-us"

DEPENDS += "task-shr-minimal"

RDEPENDS += "\
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  task-shr-minimal-base \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
  task-x11-illume \
  task-fso-compliance \
  task-cli-tools \
  task-cli-tools-python \
  task-fonts-truetype-core \
"

IMAGE_INSTALL += "\
  ${MACHINE_TASK_PROVIDER} \
  task-base \
  task-shr-minimal-base \
  task-shr-minimal-apps \
  task-shr-minimal-audio \
  task-shr-minimal-gtk \
  task-shr-minimal-x \
  task-x11-illume \
  task-fso-compliance \
  task-cli-tools \
  task-cli-tools-python \
  task-fonts-truetype-core \
"

inherit image

# perform some SHR convenience tweaks to the rootfs
shr_rootfs_postprocess() {
    dirs=`find ${FILESDIR} -type d -printf "%P\n" | grep -v "^.$" | grep -v ".git" | grep -v "^./patches$"`
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
    # fix .desktop files for illume
    #desktop=`find ./usr/share/applications -name "*.desktop"`
    #for file in $desktop; do
    #    echo "Categories=Office;" >>$file
    #done

    echo "Exec=vala-terminal -e htop" >> ./usr/share/applications/htop.desktop

    # minimal gtk theme foo
    mkdir -p ./etc/gtk-2.0/
    echo 'gtk-font-name = "Sans 5"' >> ./etc/gtk-2.0/gtkrc
    echo 'gtk-theme-name = "shr-theme-gtk-e17lookalike"' >> ./etc/gtk-2.0/gtkrc
    echo 'gtk-icon-theme-name = "openmoko-standard"' >> ./etc/gtk-2.0/gtkrc
    #echo 'style "treeview"' >> ./etc/gtk-2.0/gtkrc
    #echo '{   ' >> ./etc/gtk-2.0/gtkrc
    #echo '    GtkTreeView::expander-size = 40' >> ./etc/gtk-2.0/gtkrc
    #echo '}' >> ./etc/gtk-2.0/gtkrc
    #echo 'widget_class "*TreeView*" style "treeview"' >> ./etc/gtk-2.0/gtkrc

    echo '' >> ./etc/ld.so.conf
    # fix strange iconv/gconf bug
    ln -s libc.so.6 ./lib/libc.so

    #font cache optimization, persistent cache
    sed -i "s/<cachedir>.*\/var\/cache\/\(.*\)<\/cachedir>/<cachedir>\/var\/local\/\1<\/cachedir>/g" ./etc/fonts/fonts.conf

    #set up a nice gentoo-like PS1
    echo "export PS1=\"\[\033[01;32m\]\u@\h\[\033[01;34m\] \w \$\[\033[00m\] \"">> ./etc/profile

    #load modules on boot
    [ -d ./etc/modutils ] || mkdir ./etc/modutils
    echo "g_ether" > ./etc/modutils/g_ether
    echo "ppp_generic" > ./etc/modutils/ppp_generic
    echo "snd_pcm_oss" > ./etc/modutils/snd_pcm_oss

    #set up some variables to improve default settings
    echo "export DISPLAY=localhost:0" >> ./etc/profile
    echo "export HISTFILESIZE=1000" >> ./etc/profile
    echo "export HISTSIZE=1000" >> ./etc/profile
    echo "alias rm='rm -i'; alias cp='cp -i'; alias mv='mv -i'" >> ./etc/profile
    echo "alias la='ls $LS_OPTIONS -ltrA'; alias lh='ls $LS_OPTIONS -ltrh'; alias lr='ls $LS_OPTIONS -ltr';" >> ./etc/profile
    echo "alias lR='ls $LS_OPTIONS -ltrR'" >> ./etc/profile
    echo "# set your locale here:" >> ./etc/profile
    echo "export LC_ALL=en_GB.UTF-8" >> ./etc/profile
    echo "export LANG=en_GB.UTF-8" >> ./etc/profile

    #fix sound in elementary-alarm
    /bin/sh -c "cd ./usr/share; ln -s elementary-alarm elementary_alarm"

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

ROOTFS_POSTPROCESS_COMMAND += " shr_rootfs_postprocess"

ROOTFS_POSTPROCESS_COMMAND_append_om-gta02 = ";shr_rootfs_gta02_postprocess"
ROOTFS_POSTPROCESS_COMMAND_append_om-gta01 = ";shr_rootfs_gta01_postprocess"

#do_testlab() {
#	:
#}
