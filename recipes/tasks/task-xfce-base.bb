# task-xfce-base OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "All packages required for an base XFCE installation"
LICENSE = "MIT"
PR = "r4"

inherit task

RDEPENDS_${PN} = " \
    xfce-mcs-manager \
    xfwm4 \
    xfwm4-theme-default \
    xfce-utils \
    xfdesktop \
    xfce4-panel \
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
    xfce-mcs-plugins \
    xfwm4-mcs-plugins \
    xfce4-panel-mcs-plugins \
    xfdesktop-mcs-plugins \
"

RRECOMMENDS_${PN} = "xfce-utils-mcs-plugins"
