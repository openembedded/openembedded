DESCRIPTION = "DirectFB extra providers"
DEPENDS = "directfb"
SECTION = "libs"
LICENSE = "GPL"

SRC_URI = " \
           http://www.directfb.org/downloads/Extras/DirectFB-examples-${PV}.tar.gz \
          "
S = "${WORKDIR}/DirectFB-examples-${PV}"

inherit autotools

do_configure_append() {
#    find ${S} -type f | xargs sed -i 's:-L/usr/lib::g'
    find ${S} -type f | xargs sed -i 's:-I/usr/include::g'
}

do_stage() {
	autotools_stage_all
}


