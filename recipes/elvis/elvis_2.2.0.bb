DESCRIPTION = "A vi clone"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "Perl Clarified Artistic License"
DEPENDS = "ncurses"

SRC_URI = "ftp://ftp.cs.pdx.edu/pub/elvis/elvis-2.2_0.tar.gz"
S = "${WORKDIR}/elvis-2.2_0"

CFLAGS_prepend = " -I. -Iosunix -L${STAGING_LIBDIR} "

do_configure() {
	./configure --without-x --without-gnome --datadir=/etc/elvis --bindir=/usr/bin linux
}

do_compile() {
        (
                unset CC LD CXX CCLD CFLAGS LDFLAGS CPPFLAGS
                oe_runmake 'CC=${BUILD_CC}' elvtags
		rm *.o
		mv elvtags elvtags-native
        ) || exit 1
	oe_runmake all
	mv elvtags elvtags-target
	mv elvtags-native elvtags
}

do_install() {
	install -d -m 755 ${D}/usr
	install -d -m 755 ${D}/etc/elvis
	oe_runmake PREFIX=${D} \
		BINDIR=${D}/usr/bin \
		DATADIR=${D}/usr/share/elvis \
		DOCDIR=${D}/usr/share/elvis/manual \
		install
	install -m 755 elvtags-target ${D}/usr/bin/elvtags
	cd ${D}/usr/share/elvis
	for i in ali arf awf brf bwf clr ini msg ps spe syn; do
		mv elvis."$i" ${D}/etc/elvis
	done
	rm elvis.x11
	rm elvis.rc
	rm -rf ${D}/usr/share/elvis/themes
	rm -rf ${D}/usr/share/elvis/stubs
	rm -rf ${D}/usr/share/elvis/icons
}

pkg_postinst_${PN}() {
	update-alternatives --install /bin/vi vi /usr/bin/elvis 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove vi /usr/bin/elvis
}

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-tools"
FILES_${PN}-doc = "/usr/share/elvis/manual /usr/share/elvis/README"
FILES_${PN}-tools = "/usr/bin/elvfmt /usr/bin/elvtags /usr/bin/ref"
FILES_${PN} = "/usr/bin/elvis /etc/elvis /usr/share/elvis/scripts /usr/share/elvis/README /usr/share/elvis/*.*"



SRC_URI[md5sum] = "6831b8df3e4a530395e66c2889783752"
SRC_URI[sha256sum] = "9a8466b2293798441056bc279736af3a616baaba2f11940396cc60ff71924ea0"
