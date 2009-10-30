# task-xfce46-extras

DESCRIPTION = "Extra suggested packages to produce a recommended XFCE 4.6.* installation"
PR = "r3"

inherit task

XFCE_THEMES = " \
    xfwm4-theme-daloa \
    xfwm4-theme-moheli \
    xfwm4-theme-default-4.0 \
    xfwm4-theme-default-4.2 \
    xfwm4-theme-default-4.4 \
    xfwm4-theme-kokodi \
    xfwm4-theme-moheli \
    xfwm4-theme-sassandra \
    xfwm4-theme-stoneage \
    xfwm4-theme-therapy \
    xfwm4-theme-tyrex \
    xfwm4-theme-wallis \  
"

RDEPENDS_${PN} = " \
    task-xfce46-base \
    \
    ${XFCE_THEMES} \
    \
    xfce4-notifyd \
    xfce4-mixer \
    xfce4-appfinder \
    xfprint \    
    midori \
    orage \
    squeeze \
    ristretto \
    mousepad \ 
    gigolo \
"
