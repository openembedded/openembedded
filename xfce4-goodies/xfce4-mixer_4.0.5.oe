# xfce-mixer-plugin OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE panel mixer plugin"
SECTION = "x11"

DEPENDS="xfce4-panel"

inherit xfce

FILES_${PN}="${libdir}/xfce4/panel-plugins/*.so"

do_install() {
	oe_runmake DESTDIR=${D} plugindir="${libdir}/xfce4/panel-plugins" install
}
