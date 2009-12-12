# xscreensaver OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "*The* screensaver package for X11"
HOMEPAGE = "http://www.jwz.org/xscreensaver/"
SECTION = "x11-misc"
LICENSE = "BSD"
DEPENDS = "intltool virtual/libx11 gtk+ libxml2 libglade"

PR = "${INC_PR}.0"

SRC_URI = "http://www.jwz.org/xscreensaver/xscreensaver-${PV}.tar.gz \
           file://fixes.patch;patch=1 \
           file://configure.in.patch;patch=1 \
	   file://configure.in-includedir.patch;patch=1 \
           file://XScreenSaver"

# xscreensaver-demo is a glade app
LDFLAGS_append = " -Wl,--export-dynamic"

inherit autotools

export INTLTOOL_PERL="/usr/bin/env perl"

EXTRA_OECONF="--with-xml --with-gtk --disable-locking --without-pixbuf \
	--with-jpeg --with-xpm"

PACKAGES =+  " xscreensaver-demo xscreensaver-extra"

FILES_${PN}= "${bindir}/xscreensaver ${bindir}/xscreensaver-command \
	/usr/X11R6/lib/X11/app-defaults"

FILES_xscreensaver-demo="${bindir}/xscreensaver-demo ${datadir}/xscreensaver \
	${datadir}/pixmaps/"

FILES_xscreensaver-extra="${bindir}/xscreensaver-getimage*"

do_configure_prepend() {
	sed -i 's:GTK_DATADIR="$GTK_DATADIR/share":GTK_DATADIR="${datadir}":' ${S}/configure.in
	
	export includedir="/lib"
}

do_compile() {
	oe_runmake GNOME_DATADIR=${datadir} all
}

do_install() {
	unset KDEDIR
	oe_runmake -C ${S}/driver GNOME_DATADIR=${datadir} \
	install_prefix=${D} install

	oe_runmake -C ${S}/hacks install_prefix=${D} install-program

	# Install the defaults file
	install -d ${D}/usr/X11R6/lib/X11/app-defaults
	install -m 0644 ${WORKDIR}/XScreenSaver ${D}/usr/X11R6/lib/X11/app-defaults
}

PACKAGES_DYNAMIC = "xscreensaver-hack-*"

python populate_packages_prepend () {
	hackdir = bb.data.expand('${libexecdir}/xscreensaver', d)
	do_split_packages(d, hackdir, '^(.*)', 'xscreensaver-hack-%s', 'XScreensaver hack %s')
}
