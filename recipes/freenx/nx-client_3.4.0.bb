LICENSE = "GPL"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/nx-X11-3.4.0-4.tar.gz;name=nx11 \
           http://64.34.161.181/download/3.4.0/sources/nxauth-3.4.0-3.tar.gz;name=nxauth \
           http://64.34.161.181/download/3.4.0/sources/nxagent-3.4.0-9.tar.gz;name=nxagent \
           http://64.34.161.181/download/3.4.0/sources/nxwin-3.4.0-5.tar.gz;name=nxwin \
           http://64.34.161.181/download/3.4.0/sources/nxcomp-3.4.0-7.tar.gz;name=nxcomp \
           http://64.34.161.181/download/3.4.0/sources/nxcompext-3.4.0-1.tar.gz;name=nxcompext \
           http://64.34.161.181/download/3.4.0/sources/nxcompshad-3.4.0-3.tar.gz;name=nxcompshad \
          "
SRC_URI[nx11.md5sum] = "38a84d4521a41e5ff988a84181ddcaf5"
SRC_URI[nx11.sha256sum] = "c8654b5a5d607ace755a3a44831335af9f65a45bcb6501d92d94e81af338b1da"
SRC_URI[nxauth.md5sum] = "bfb758edd51271b31aa6b902557fa0cc"
SRC_URI[nxauth.sha256sum] = "6ac8238852b1b3754ed1ed917ede5cd7473c482c0d847f2fb2c8c9a1334e3516"
SRC_URI[nxagent.md5sum] = "4b59e373bf86788bd496abe2681d38a5"
SRC_URI[nxagent.sha256sum] = "3682b018b06a0610c5b88ea694d11596b21bb97edc0c97fabc17eab3b7865ef6"
SRC_URI[nxwin.md5sum] = "88538694d4a0dce157bec0dd8da9f9d3"
SRC_URI[nxwin.sha256sum] = "9de969e51121dca76be927047b0cf6f92dd8acc0ee2fd03562e39d45582e0079"
SRC_URI[nxcomp.md5sum] = "cba926f2b855231a8fc3e0dabff52855"
SRC_URI[nxcomp.sha256sum] = "1c9eb63e46ae263899aec08c017c6af93b0632883ec916d465df9e438229e485"
SRC_URI[nxcompext.md5sum] = "605a8e2a136f89477f0059a0d2af4582"
SRC_URI[nxcompext.sha256sum] = "75be77fe0cdc3aca21afd0b72590d600b131b849b8e65926c237c3d87dd1160e"
SRC_URI[nxcompshad.md5sum] = "15deba68e12e13b524a723b49e7ec813"
SRC_URI[nxcompshad.sha256sum] = "8c5a67ea156afb0fb2a50adbb89b8b26b6f0860cf3f53c45eb53f59ec4deaa98"

S = "${WORKDIR}/${PN}"

inherit autotools

do_compile () {
        unset CC
        make -C config/imake -f Makefile.ini CC="${BUILD_CC}" BOOTSTRAPCFLAGS="${BUILD_CFLAGS}" clean imake
	oe_runmake CC="${BUILD_CC}" World
}

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
}
#do_compile() {
#	unset CC
#	make -C config/imake -f Makefile.ini CC="${BUILD_CC}" BOOTSTRAPCFLAGS="${BUILD_CFLAGS}" clean imake
#	make CC="${BUILD_CC}" xmakefile
#	make Makefiles
#	make clean
#	#make depend
#	make includes CC="${BUILD_CC}"
#	make -C config/util CC="${BUILD_CC}"
#	for l in font xtrans Xdmcp Xau lbxutil; do make -C lib/$l CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}"; done
#	make -C programs/Xserver CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}" INSTALLED_LIBS=""
#}
