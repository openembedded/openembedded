LICENSE = "GPL"
DEPENDS = "nxcomp xserver-common libx11 pixman"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           file://nxlib.patch \
           "

CC += "-I${STAGING_INCDIR}/X11 -I${STAGING_INCDIR}/xorg -I${STAGING_INCDIR}/pixman-1"
CXX += "-I${STAGING_INCDIR}/X11 -I${STAGING_INCDIR}/xorg -I${STAGING_INCDIR}/pixman-1"

SRC_URI[md5sum] = "605a8e2a136f89477f0059a0d2af4582"
SRC_URI[sha256sum] = "75be77fe0cdc3aca21afd0b72590d600b131b849b8e65926c237c3d87dd1160e"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
}
