DESCRIPTION = "Task packages for GPE Palmtop Environment Phone Edition"
PR = "r10"
LICENSE = "MIT"

inherit task

PACKAGES = "\
    gpephone-task-base \
    gpephone-task-settings \
    gpephone-task-pim \
    gpephone-task-connectivity \
    gpephone-task-apps \
    gpephone-task-development"

RDEPENDS_gpephone-task-development = "\
    rxvt-unicode \
    gpe-terminal \
    gpe-edit \
    gdb \
    strace \
    e2fsprogs \
    bluez-utils-compat \
    minicom"

RDEPENDS_gpephone-task-base = "\
    cms92init \
    gsmmux \
    connect \
    phoneserver \
    soundserver \
    voicecall \
    vochistory \
    sms \
    audioplayer \
    videoplayer \
    addressbook \
    calendar \
    gpe-applauncher \
    gpe-phonepanel \
    gpe-bootsplash \
    gpe-bootsplash-theme-gpephone \
    bluez-utils-dbus \
    matchbox \
    xcursor-transparent-theme \
    gtk2-theme-angelistic \
    matchbox-themes-gtk \
    xst \
    xhost \
    xrdb \
    gpe-soundserver \
    ttf-bitstream-vera \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    gpe-dm \
    gpe-login \
    gpe-session-scripts-phone \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    gdk-pixbuf-loader-gif \
    pango-module-basic-x \
    pango-module-basic-fc \
    detect-stylus \
    ptim-manager \
    ptim-helper \
    ptim-engine \
    ${@base_contains("MACHINE_FEATURES", "touchscreen", "libgtkstylus xtscal", "",d)} \
"

RDEPENDS_gpephone-task-pim = "\
     gpesyncd"

RDEPENDS_gpephone-task-settings = "\
    gpe-su \
    gpe-conf \
    gpe-mixer \
    gpe-taskmanager \
    minilite \
    machined"

RDEPENDS_gpephone-task-apps = "\
    gpe-what \
    gpe-scap \
    gpe-windowlist"

RDEPENDS_gpephone-task-connectivity = "\
"
