DESCRIPTION = "HFS file system utilities"
SECTION = "base"
LICENSE = "GPL"
PR = "r1"

inherit autotools pkgconfig

SRC_URI = "ftp://ftp.mars.org/pub/hfs/hfsutils-3.2.6.tar.gz \
	   file://hfsutils-3.2.6-errno.patch;patch=1 \
	   file://largerthan2gb.patch;patch=1 \
		"

do_configure () {
	oe_runconf --disable-x
}

do_compile () {
	oe_runmake
	cd hfsck; oe_runmake
}

do_install () {
	install -d ${D}/usr/bin
	install -m 755 hfsutil ${D}/usr/bin/hfsutil
	install -m 755 hfsck/hfsck ${D}/usr/bin/hfsck

	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hattrib
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hcd
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hcopy
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hdel
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hdir
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hformat
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/his
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hmkdir
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hmount
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hpwd
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hrename
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hrmdir
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/humount
	ln -sf /usr/bin/hfsutil ${D}/usr/bin/hvol
}
