# xscreensaver OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "*The* screensaver package for X11"
HOMEPAGE = "http://www.jwz.org/xscreensaver/"
SECTION = "x11-misc"
LICENSE = "BSD"
DEPENDS = "intltool virtual/libgl freeglut virtual/libx11 gtk+ libxml2 libglade"

# xscreensaver-demo is a glade app
LDFLAGS_append = " -Wl,--export-dynamic"
TARGET_CC_ARCH += "${LDFLAGS}"

INC_PR = "r4"

inherit autotools

export INTLTOOL_PERL="/usr/bin/env perl"

EXTRA_OECONF=" --with-xml \
               --with-gtk \
               --disable-locking \
               --without-pixbuf \
               --with-jpeg \
               --with-xpm \
               --with-randr-ext \
               --with-gl \
               --without-gle \
               --with-xshm-ext \
               --with-setuid-hacks \
"

PACKAGES =+  " xscreensaver-demo xscreensaver-extra"

FILES_${PN}= "${bindir}/xscreensaver ${bindir}/xscreensaver-text ${bindir}/xscreensaver-command ${datadir}/applications \
	${libdir}/X11/"

FILES_${PN}-dbg += "${libexecdir}/xscreensaver/.debug"

FILES_xscreensaver-demo="${bindir}/xscreensaver-demo ${datadir}/xscreensaver \
	${datadir}/pixmaps/"

FILES_xscreensaver-extra="${bindir}/xscreensaver-getimage*"

do_configure_prepend() {
	sed -i 's:GTK_DATADIR="$GTK_DATADIR/share":GTK_DATADIR="${datadir}":' ${S}/configure.in
	
	export includedir="/lib"
	sed -i -e s:AC_PROG_CC:AC_PROG_CXX:g configure.in
	echo AC_PROG_CXX >> configure.in
	export CC="${CXX}"
}

do_compile() {
	oe_runmake CC="${CC}" LD="${CXX}" CC_HACK="${CXX}" GNOME_DATADIR=${datadir} all
}

fakeroot do_install() {
	unset KDEDIR
	oe_runmake -C ${S}/driver GNOME_DATADIR=${datadir} \
	install_prefix=${D} install

	oe_runmake -C ${S}/hacks install_prefix=${D} install-program

	# Install the defaults file
	install -d ${D}/${libdir}/X11/app-defaults
	install -m 0644 ${WORKDIR}/XScreenSaver ${D}/${libdir}/X11/app-defaults
}

PACKAGES_DYNAMIC = "xscreensaver-hack-*"

python populate_packages_prepend () {
	hackdir = bb.data.expand('${libexecdir}/xscreensaver', d)
	do_split_packages(d, hackdir, '^(.*)', 'xscreensaver-hack-%s', 'XScreensaver hack %s')
	metapkg = "xscreensaver-hacks"
	bb.data.setVar('ALLOW_EMPTY_' + metapkg, "1", d)
	bb.data.setVar('FILES_' + metapkg, "", d)
	blacklist = [ 'xscreensaver-locale', 'xscreensaver-dev', 'xscreensaver-dbg', 'xscreensaver-doc', 'xscreensaver-extra' ]
	metapkg_rdepends = []
	packages = bb.data.getVar('PACKAGES', d, 1).split()
	for pkg in packages[1:]:
		if not pkg in blacklist and not pkg in metapkg_rdepends:
			metapkg_rdepends.append(pkg)
	bb.data.setVar('RDEPENDS_' + metapkg, ' '.join(metapkg_rdepends), d)
	bb.data.setVar('DESCRIPTION_' + metapkg, 'Xscreensaver hacks meta package', d)
	packages.append(metapkg)
	bb.data.setVar('PACKAGES', ' '.join(packages), d)
}

