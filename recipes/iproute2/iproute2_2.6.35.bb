require iproute2.inc

PR = "${INC_PR}.0"

SRC_URI = "http://devresources.linuxfoundation.org/dev/iproute2/download/${P}.tar.bz2 \
	   file://configure-cross.patch \
	  "

SRC_URI[md5sum] = "b0f281b3124bf04669e18f5fe16d4934"
SRC_URI[sha256sum] = "8ab2f47e129925fb8acb09421008d07aeafa01b2ddd1fcba4a056de079f090a3"

S = "${WORKDIR}/iproute2-${PV}"

do_configure () {
    ./configure ${STAGING_DIR_TARGET}
}

FILES_${PN} += "${base_libdir}/tc/*.so"
FILES_${PN}-dbg += "${base_libdir}/tc/.debug"