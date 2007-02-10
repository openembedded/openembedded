DESCRIPTION = "FusionSound for DirectFB"
DEPENDS = "directfb"
SECTION = "libs"
LICENSE = "LGPL"

# this is a CVS only release

SRC_URI = "cvs://anonymous@cvs.directfb.org/cvs/directfb;method=pserver;module=FusionSound;date=${@bb.data.getVar('PV', d, 1)[9:]}"

S = "${WORKDIR}/FusionSound"

inherit autotools pkgconfig

do_configure_append() {
    find ${S} -type f | xargs sed -i 's:I/usr/include:I${STAGING_INCDIR}:g'
}

do_stage() {
        autotools_stage_all
}

do_install() {
        oe_runmake 'DESTDIR=${D}' install
}

FILES_fusionsound-dbg_append = " ${libdir}/directfb-1.0-0/*/*/.debug/*.so \
                              ${libdir}/directfb-1.0-0/*/.debug/*.so \
                          "

FILES_fusionsound-dev_append = " ${libdir}/directfb-1.0-0/interfaces/*/*.la \
			         ${libdir}/directfb-1.0-0/snddrivers/*.la \
			       "

FILES_fusionsound_append = " ${libdir}/directfb-1.0-0/interfaces/*/*.so \
                             ${libdir}/directfb-1.0-0/snddrivers/*.so \
			   "

