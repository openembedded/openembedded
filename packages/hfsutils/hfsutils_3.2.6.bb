DESCRIPTION = "HFS file system utilities"
SECTION = "base"
LICENSE = "GPL"
PR = "r2"

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
	install -d ${D}/${bindir}
	install -m 755 hfsutil ${D}/${bindir}/hfsutil
	install -m 755 hfsck/hfsck ${D}/${bindir}/hfsck

	for util in hattrib hcd hcopy hdel hdir hformat \
		    his hmkdir hmount hpwd hrename hrmdir \
		    humount hvol; do 
		ln -sf hfsutil ${D}/${bindir}/${util}
	done
}
