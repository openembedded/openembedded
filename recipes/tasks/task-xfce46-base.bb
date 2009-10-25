# task-xfce46-base

DESCRIPTION = "All packages required for a base installation of XFCE 4.6.*"
PR = "r1"

inherit task

RDEPENDS_${PN} = " \
    xfwm4 \
    xfwm4-theme-default \
    xfce4-session \     
    xfconf \
    xfdesktop \
    xfce4-panel \
    \
    gtk-xfce-engine \
    \
    xfce-utils \
    xfce4-panel-plugin-actions \
    xfce4-panel-plugin-clock \
    xfce4-panel-plugin-iconbox \
    xfce4-panel-plugin-launcher \
    xfce4-panel-plugin-pager \
    xfce4-panel-plugin-separator \
    xfce4-panel-plugin-showdesktop \
    xfce4-panel-plugin-systray \
    xfce4-panel-plugin-tasklist \
    xfce4-panel-plugin-windowlist \   
    xfce4-settings \
    xfce-terminal \
    thunar \
"
