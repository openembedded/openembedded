DESCRIPTION = "the file manager at the core of the ROX desktop"
HOMEPAGE = "http://rox.sf.net"
LICENSE = "GPL"
DEPENDS = "gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/rox/${P}.tar.bz2 \
           file://no-strip-objcopy.patch;patch=1;pnum=3"

inherit pkgconfig

S = "${WORKDIR}/${P}/ROX-Filer/src/"

do_compile() {
	../AppRun --compile
}	

do_install() {
	install -d ${D}${bindir}
	install -m 755 ../ROX-Filer ${D}${bindir}
}

