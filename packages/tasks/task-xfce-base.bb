# task-xfce-base OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "All packages required for an base XFCE installation"
LICENSE = "MIT"
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
PR = "r2"

RDEPENDS = "xfce-mcs-manager xfwm4 xfwm4-theme-default xfce-utils xfdesktop \
	xfce4-panel xfce4-panel-plugins xfce-mcs-plugins xfwm4-mcs-plugins \
	xfce4-panel-mcs-plugins \
	xfdesktop-mcs-plugins"
RRECOMMENDS = "xfce-utils-mcs-plugins"
